package com.task.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.project.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
