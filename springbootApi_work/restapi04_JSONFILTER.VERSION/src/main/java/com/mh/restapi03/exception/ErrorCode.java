package com.mh.restapi03.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    DUPLICATE(HttpStatus.BAD_REQUEST,"A001","중복된 내용이 있습니다."),
    NOTFOUND(HttpStatus.NOT_FOUND, "B001","찾을 수 없습니다."),
    TEST(HttpStatus.BAD_GATEWAY, "C001","테스트중입니다.."),
    NOTUPDATE(HttpStatus.NOT_FOUND, "NOTUPDATE","수정할내용이 없습니다."),
    LOGINFAIL(HttpStatus.UNAUTHORIZED,"LOGINFAIL","이메일패스워드확인하세요")
    ;
    private HttpStatus httpStatus;

    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
