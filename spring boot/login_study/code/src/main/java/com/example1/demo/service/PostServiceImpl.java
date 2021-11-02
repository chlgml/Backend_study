package com.example1.demo.service;

import com.example1.demo.entity.Post;
import com.example1.demo.entity.PostRepository;
import com.example1.demo.exception.PostNotFoundException;
import com.example1.demo.payload.PostRequest;
import com.example1.demo.payload.PostResponse;
import com.example1.demo.payload.Posts;
import com.example1.demo.payload.PostsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor // @NonNull이나 final이 붙은 필드에 대한 생성자를 생성한다.
@Service // Service Class에서 쓰인다. 비지니스 로직을 수행하는 Class하는 것을 나타내는 용도
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override // 오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.
    // 오버라이딩 : 상위 클래스에 정의된 메소드를 하위 클래스에서 다시 정의하는 것
    public void writePost(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        postRepository.save(post);
    }

    @Override // 오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.
    public PostsResponse getPosts() {
        List<Post> postList = postRepository.findAllBy();
        List<Posts> posts = new ArrayList<>();

        for (Post post : postList) {
            posts.add(
                    Posts.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .build()
            );
        }

        return PostsResponse.builder()
                .posts(posts)
                .build();
    }

    @Override // 오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.
    public PostResponse getDetailPost(Integer id) {
        Post post= postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
