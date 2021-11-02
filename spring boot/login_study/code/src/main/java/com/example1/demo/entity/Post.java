package com.example1.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // Getter 메소드를 생성해 준다.
@Builder // 자동으로 해당클래스에 빌드를 생성
@NoArgsConstructor // 파라미터가 없는 생성자 생성
@AllArgsConstructor // 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성
@Entity // 객체와 테이블 매핑
public class Post {

    @Id // 기본 키 매핑
    @GeneratedValue // 옵션 설정 Entity와 함께 사용하면 자동으로 ++이 된다.
            (strategy = GenerationType.IDENTITY)

    private  Integer id;

    @Column // 필드와 컬럼 매핑
             (nullable = false, length = 20)
    private  String title;

    @Column// 필드와 컬럼 매핑
            (nullable = false,length = 300)
    private String content;

}
