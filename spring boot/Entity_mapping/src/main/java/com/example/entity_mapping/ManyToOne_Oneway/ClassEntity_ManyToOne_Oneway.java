package com.example.entity_mapping.ManyToOne_Oneway;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassEntity_ManyToOne_Oneway {

    // N:1 연관관계 단방향

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 매핑이 되었다고 하더라도 기본키 자동생성 전략을 정해주어야한다.
    @Column(name = "Class_ID") // 정했던 외래키 이름을 컬럼 어노테이션에 적어줌
    private Long id;

    @Column(nullable = false)
    private Integer ClassNumber;


}
