package com.example1.demo.service;

import com.example1.demo.payload.PostRequest;
import com.example1.demo.payload.PostResponse;
import com.example1.demo.payload.PostsResponse;

public interface PostService {
    void writePost(PostRequest request);
    PostsResponse getPosts();
    PostResponse getDetailPost(Integer id);
}
