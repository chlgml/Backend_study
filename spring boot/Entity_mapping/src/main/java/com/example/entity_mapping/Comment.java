package com.example.entity_mapping;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comment;

    @ManyToOne // 매핑할 방식에 따라 어노테이션이 달라진다
    @JoinColumn(name = "postId") // 주인이 아닌 연결되어 있는 Entity의 경우에는 이 어노테이션을 사용한다.
    private Post post;

    @Builder
    public Comment (String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

}
