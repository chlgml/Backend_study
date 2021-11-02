package com.example1.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus // 예외처리 함수 앞에 사용. 요청에 대한 상태코드를 말해줌.
        (HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {
}
