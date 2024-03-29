package com.mh.restapi03.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {  // UserEx.. -> Gloable... 로 바꿈 User 뿐 아니라 모든
    @ExceptionHandler(LogicException.class)  // Exception 이라고 적으면 모든 에러가 다 들어온다. 지금은 LogException 에러만 가져오라고 해 놓음
    public final ResponseEntity<ErrorResponse> handleLogException(LogicException ex){
        System.out.println(ex.toString());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getErrorCode().getErrorCode()) // 에러코드 적용된것이 들어갈 것이고
                .errorMessage(ex.getErrorCode().getMessage())
                .errorDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }
    @ExceptionHandler(Exception.class)  // 모든 예외
    public final ResponseEntity<ErrorResponse> handleException(UsersException e){
        ErrorResponse errorResponse
                = ErrorResponse.builder()
                .errorMessage(e.getErrorCode().getMessage())
                .errorCode(e.getErrorCode().getErrorCode())
                .errorDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // @ExceptionHandler(BindException.class)  // = validException 이랑 같다.

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, 
                                                                  HttpStatusCode status, 
                                                                  WebRequest request) {
        System.out.println("유효성 getMessage " + ex.getMessage());
        System.out.println("유효성 getBindingResult " + ex.getBindingResult());

//        System.out.println("유효성 실패22" + headers.get("aa"));
//        System.out.println("유효성 실패22" + status);
//        System.out.println("유효성 실패22" + request);

        ErrorResponse errorResponse = ErrorResponse
                                        .builder()
                                        .errorCode(HttpStatus.BAD_REQUEST.toString())
                                        .errorMessage(ex.getBindingResult().toString())
                                        .errorDateTime(LocalDateTime.now())
                                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
