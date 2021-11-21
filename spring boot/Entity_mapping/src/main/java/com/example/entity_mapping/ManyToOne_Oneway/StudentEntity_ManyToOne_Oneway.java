package com.example.entity_mapping.ManyToOne_Oneway;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity_ManyToOne_Oneway {

    // N:1 연관관계 단방향

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    // 1:N일때는 N인 부분에 외래키를 둔다.
    @ManyToOne
    @JoinColumn(name = "Class_ID") //외래키 이름 매핑할 Entity클래스에도 적어주어야함
    private ClassEntity_ManyToOne_Oneway classEntityManyToOne;
    // 매핑할 Entity 클래스로 필드를 만든다.

}