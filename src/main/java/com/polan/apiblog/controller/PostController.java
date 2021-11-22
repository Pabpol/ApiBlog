package com.polan.apiblog.controller;

import java.util.List;

import com.polan.apiblog.model.Post;
import com.polan.apiblog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

  /*   @GetMapping("/posts")
    public List<Post> findAllPostsSorted(){
       return postService.findAllPostsSorted();
    } */

    @GetMapping("/{postId}")
    public Post findById(@PathVariable Integer postId){
        return postService.findById(postId);
    }

    @GetMapping()
    public List<Post> findAllPostsSortedFilter(@RequestParam(required = false) String title, @RequestParam(required = false) String category ){
       return postService.findAllPostsSortedFilter(title,category);
    }

     @PostMapping
     public void addPost(@RequestBody Post post){
        postService.addPost(post);
     }

     @DeleteMapping
     public void deletePost(@RequestBody Post post){
         postService.deleteById(post.getPostId());
     }
    
}
