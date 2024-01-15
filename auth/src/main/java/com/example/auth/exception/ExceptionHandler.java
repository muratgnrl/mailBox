package com.example.auth.exception;

import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userAlreadyException(UserAlreadyException exception, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();
        meta.errorCode=4012;
        meta.errorDescription="Bu kullanıcı mevcut";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> register(RegisterException exception, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();
        meta.errorCode=4011;
        meta.errorDescription="Hesapla ilgili veritabanı oluşturulamıyor";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> loginException(UserLoginException exception, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();
        meta.errorCode=4010;
        meta.errorDescription="Bilgilerini kontrol etmelisin";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findException(FindException exception, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();
        meta.errorCode=4009;
        meta.errorDescription="aranan obje (user) bulunamadı";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }
}
