package com.example.project.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @Column(name = "GAME_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private Integer Sstage;

    @Column(nullable = false, length = 2)
    private Integer Cstage;

    @Column(nullable = false, length = 2)
    private Integer Jstage;

}
