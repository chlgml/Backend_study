package com.example.entity_mapping;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "comment") // 주인인 Entity에는 양방향일 경우 존재
    private List<Comment> comment = new ArrayList<>(); // 매핑한 Entity가 n개라면 List로!

    @Builder
    public Post (String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }


}
