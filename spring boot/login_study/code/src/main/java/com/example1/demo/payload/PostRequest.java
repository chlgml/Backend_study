package com.example1.demo.payload;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter // Getter 메소드를 생성해 준다.
@Builder  // 자동으로 해당클래스에 빌드를 생성
public class PostRequest {

    @NotBlank // null이 아니고 단순한 띄어쓰기가 아닌지 확인
    private String title;

    @NotBlank // null이 아니고 단순한 띄어쓰기가 아닌지 확인
    private String content;

}

