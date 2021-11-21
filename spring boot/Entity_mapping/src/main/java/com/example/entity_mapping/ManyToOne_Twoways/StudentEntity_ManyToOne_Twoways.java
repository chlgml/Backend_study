package com.example.entity_mapping.ManyToOne_Twoways;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEntity_ManyToOne_Twoways {

    // N:1 양방향 관계

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "Class_ID")
    private ClassEntity_ManyToOne_Twoways classEntity_manyToOne_twoways;

}