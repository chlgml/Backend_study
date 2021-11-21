package com.example.entity_mapping.OneToOne_Twoways;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity_OneToOne_Twoways {

    // 1:1 양방향 연관관계

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sexual_Id")
    private Long id;

    private Integer English;

    private Integer math;

    @OneToOne(mappedBy = "StudentEntity_OneToOne_Twoways")
    private SexualEntity_OneToOne_Twoway sexualEntity_oneToOne_twoway;

}
