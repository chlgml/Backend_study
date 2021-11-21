package com.example.entity_mapping.OneToOne_Twoways;

import com.example.entity_mapping.OneToOne_Oneway.StudentEntity_OneToOne_Oneways;
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
public class SexualEntity_OneToOne_Twoway {

    // 1:1 양방향 연관관계

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private Integer number;

    @OneToOne
    @JoinColumn(name = "sexual_Id") // 주 테이블에 외래키를 둔다.
    private StudentEntity_OneToOne_Oneways studentEntity_oneToOneTwoways;
}
