package com.task.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.project.Model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
