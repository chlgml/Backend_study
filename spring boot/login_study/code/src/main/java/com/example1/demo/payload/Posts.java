package com.example1.demo.payload;

import lombok.Builder;
import lombok.Getter;

@Getter // Getter 메소드를 생성해 준다.
@Builder // 자동으로 해당클래스에 빌드를 생성
public class Posts {

    public Integer id;

    public String title;

}
