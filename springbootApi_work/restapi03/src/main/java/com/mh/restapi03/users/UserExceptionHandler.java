package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorResponse;
import com.mh.restapi03.exception.LogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LogException.class)  // Exception 이라고 적으면 모든 에러가 다 들어온다. 지금은 LogException 에러만 가져오라고 해 놓음
    public final ResponseEntity<ErrorResponse> handleLogException(LogException ex){
        System.out.println(ex.toString());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getErrorCode().getErrorCode()) // 에러코드 적용된것이 들어갈 것이고
                .errorMessage(ex.getErrorCode().getMessage())
                .errorDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }
}
