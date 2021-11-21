package com.example.entity_mapping.ManyToMany_Oneway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentEntity_ManyToMany_Oneway {

    // N:M 연관관계 단방향

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer ClassNumber;

    @ManyToMany
    @JoinColumn(name = "academy_ID")
    private List<academyEntity_ManyToMany_Oneway> academyEntity_manyToMany_oneways = new ArrayList<>();

}
