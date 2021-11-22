package com.polan.apiblog.service;

import java.util.List;

import com.polan.apiblog.model.Post;

public interface PostService {

    List<Post> findAllPostsSorted();
    List<Post> findAllPostsSortedFilter(String title, String category);
    Post findById(Integer id);
    void addPost(Post post);
    void updatePost(Post post);
    void deleteById(Integer id);
    
}
