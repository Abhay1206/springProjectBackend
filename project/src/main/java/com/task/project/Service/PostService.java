package com.task.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.project.Model.Post;
import com.task.project.Model.User;
import com.task.project.Repository.PostRepository;
import com.task.project.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public String createPost(Integer userId, String content) {
        User user = userRepository.findById(userId).orElse(null);
        Post post = new Post();
        post.setContent(content);
        post.setUser(user);
        postRepository.save(post);
        return "Post is successfully Created";
    }

    public String editPost(Integer postId, String content) {

        Post post = postRepository.findById(postId).orElse(null);
        post.setContent(content);
        postRepository.save(post);
        return "Post is successfully updated";
    }

    public String deletePost(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        postRepository.delete(post);
        return "post is deleted";

    }

}
