package com.example.entity_mapping.ManyToMany_Twoways;

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
public class academyEntity_ManyToMany_Twoway {

    // N:M 연관관계 양방향

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academy_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer number;

    @ManyToMany(mappedBy = "StudentEntity_ManyToMany_Twoway")
    private List<StudentEntity_ManyToMany_Twoway> studentEntity_manyToMany_twoways = new ArrayList<>();

}
