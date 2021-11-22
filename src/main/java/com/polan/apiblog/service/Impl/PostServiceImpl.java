package com.polan.apiblog.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.polan.apiblog.model.Post;
import com.polan.apiblog.repository.PostRepository;
import com.polan.apiblog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllPostsSorted() {
        return postRepository.findByOrderByPublicationDateDesc();
    }

    @Override
    public List<Post> findAllPostsSortedFilter(String title, String category) {
        List<Post> posts = postRepository.findByOrderByPublicationDateDesc();
        List<Post> filteredPosts = new ArrayList<Post>();
        List<Predicate<Post>> predicates = new ArrayList<Predicate<Post>>();

        if (title != null && !title.equals("")) {
            predicates.add(post -> post.getTitle().equals(title));
        }
        if (category != null && !category.equals("")) {
            predicates.add(post -> post.getCategory().equals(category));

        }
        if (predicates.size() != 0) {
            Predicate<Post> finalPredicate = predicates.get(0);
            for (int i = 0; i < predicates.size(); i++) {
                finalPredicate = finalPredicate.and(predicates.get(i));
            }
            filteredPosts = posts.stream().filter(finalPredicate).collect(Collectors.toList());
        }else{
            filteredPosts = postRepository.findByOrderByPublicationDateDesc();
        }

        return filteredPosts;
    }

    @Override
    public Post findById(Integer id) {

        return postRepository.getById(id);
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);

    }

    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);

    }

}
