package com.task.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.project.Service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/createComment")
    public ResponseEntity<String> createComment(
            @RequestParam(name = "follower_id") Integer follower_id,
            @RequestParam(name = "content") String content,
            @RequestParam(name = "user_id") Integer user_id,
            @RequestParam(name = "post_id") Integer post_id) {
        return new ResponseEntity<String>(commentService.comment(follower_id, content, user_id, post_id),
                HttpStatus.OK);
    }
}
