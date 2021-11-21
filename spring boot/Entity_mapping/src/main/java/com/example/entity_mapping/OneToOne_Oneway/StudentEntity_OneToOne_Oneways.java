package com.example.entity_mapping.OneToOne_Oneway;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity_OneToOne_Oneways {

    // 1:1 단방향 연관관계

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sexual_Id")
    private Long id;

    private Integer English;

    private Integer math;

}
