package com.hotelize.exception.user_profile_service_exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(1000, "Sunucuda beklenmeye hata oluştu, lütfen terar deneyiniz",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_DUPLICATE_USERNAME(2000,"Bu Kullanıcı adı zaten kayıtlıdır. Lütfen değiştirerek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_LOGIN_PARAMETER(2001,"Kullanıcı adı ya da Şifre hatalıdır. Lütfen tekrar deneyiniz.t",HttpStatus.BAD_REQUEST),
    ERROR_FIND_ID_BY_TOKEN(1002,"Token auth id bilgisini bulamadi. ",HttpStatus.BAD_REQUEST),
    ERROR_CREATE_TOKEN(1003,"Token oluşturma hatası. Lütfen tekrar deneyiniz.",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_USER_NOT_FOUND(2001,"Kullanici bulunamamaistir.",HttpStatus.NOT_FOUND),
    BAD_REQUEST_ERROR(1001, "Girilen parametreler hatalıdır. Lütfen düzelterek tekrar deneyiniz", HttpStatus.BAD_REQUEST);


    int code;
    String message;
    HttpStatus httpStatus;
}
