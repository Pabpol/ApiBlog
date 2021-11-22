package com.polan.apiblog.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;

import com.polan.apiblog.model.AppUser;
import com.polan.apiblog.model.Post;
import com.polan.apiblog.service.Impl.PostServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PostControllerTest {

    @Mock
    private PostServiceImpl postServiceImpl;

    @InjectMocks
    private PostController postController;
    
    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        post = new Post();
        post.setPostId(1);
        post.setTitle("title");
        post.setContent("content");
        post.setCategory("category");
        post.setImgUrl("imgUrl");
        post.setPublicationDate(Date.valueOf("2020-10-10"));
        post.setAppUser(new AppUser(1, "email", "password", null, null));
        
    }

    @Test
    void testAddPost() {

    }

    @Test
    void testDeletePost() {

    }

    @Test
    void testFindAllPostsSortedFilter(String title, String category) {
        title = "title";
        category = "category";
        when(postServiceImpl.findAllPostsSortedFilter(title, category)).thenReturn(Arrays.asList(post));
        assertNotNull(postController.findAllPostsSortedFilter(null, null));
    }

    @Test
    void testFindById() {

    }
}
