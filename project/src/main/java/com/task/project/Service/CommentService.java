package com.task.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.project.Model.Comment;
import com.task.project.Model.Post;
import com.task.project.Model.User;
import com.task.project.Repository.CommentRepository;
import com.task.project.Repository.PostRepository;
import com.task.project.Repository.UserRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public String comment(Integer follower_id, String content, Integer user_id, Integer postId) {
        User a = userRepository.findById(follower_id).orElse(null);
        boolean b = a.getFollowersId().contains(Integer.valueOf(user_id));
        if (b == false) {
            return "YOu cannot comment , you need to follow first";
        }
        Post p = postRepository.findById(postId).orElse(null);
        Comment c = new Comment();
        c.setContent(content);
        c.setPost(p);
        commentRepository.save(c);
        return "comment is added";

    }
}
