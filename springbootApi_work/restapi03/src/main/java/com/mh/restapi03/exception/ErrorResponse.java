package com.mh.restapi03.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    @JsonFormat(pattern = "yyy/MM/dd HH:mm:ss")
    private LocalDateTime errorDateTime;
}
