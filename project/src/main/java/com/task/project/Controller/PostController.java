package com.task.project.Controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.project.Service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "content") String content) {
        return new ResponseEntity<String>(postService.createPost(userId, content), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> edit(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "content") String content) {
        return new ResponseEntity<String>(postService.editPost(userId, content), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "userId") Integer userId) {
        return new ResponseEntity<String>(postService.deletePost(userId), HttpStatus.OK);
    }

}
