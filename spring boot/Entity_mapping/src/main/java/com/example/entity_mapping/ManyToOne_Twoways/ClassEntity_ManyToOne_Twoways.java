package com.example.entity_mapping.ManyToOne_Twoways;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassEntity_ManyToOne_Twoways {

    // N:1 연관관계 양방향

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ClassNumber;

    @OneToMany(mappedBy = "Class") // 양방향일때는 이부분을 추가한다.
    private List<StudentEntity_ManyToOne_Twoways> studentEntity_oneToManyList = new ArrayList<>();

}
