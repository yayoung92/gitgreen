package com.ygy.restapi05.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice // controller 캐치
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object>
            handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
//        List<FieldError> list = ex.getBindingResult().getFieldErrors();
//        List<String> errorMessage = new ArrayList<>();
//        List<String> errorReason = new ArrayList<>();
//
//        for(FieldError error : list){
//            System.out.println("error.getField() = " + error.getField());
//            System.out.println("error.getDefaultMessage() = " + error.getDefaultMessage());
//            System.out.println("error.getCode() = " + error.getCode());
//            errorMessage.add(error.getCode());
//            errorReason.add(error.getField() + error.getDefaultMessage());
//        }

        List<String> errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField()  + " : " + fieldError.getCode())
                .collect(Collectors.toList());

        List<String> errorReason = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError ->fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(errorMessage.toString())
                .reason(errorReason.toString())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
