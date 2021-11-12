package com.example.project.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@javax.persistence.Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false)
    private String pwd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_ID")
    private GameEntity gameEntity;

}
