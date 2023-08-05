package com.task.project.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    void testCreatePost() {
        postService.createPost(1, "Post1");

    }

    @Test
    void testDeletePost() {
        postService.deletePost(1);
    }

    @Test
    void testEditPost() {
        postService.editPost(2, "new Post1");
    }
}
