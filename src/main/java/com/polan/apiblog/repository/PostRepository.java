package com.polan.apiblog.repository;

import java.util.List;

import com.polan.apiblog.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer>{
    
    List<Post> findByOrderByPublicationDateDesc();
  
    List<Post> findByTitleOrCategoryOrderByPublicationDateDesc(String title, String category);
 /*    List<Post> findByTitleOrderbyPublicationDateDesc();
    List<Post> findByCategoryOrderbyPublicationDateDesc(); */
    
    

}
