package com.project.cafesns.repository;

import com.project.cafesns.model.entitiy.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCafeId(Long cafeId);

}
