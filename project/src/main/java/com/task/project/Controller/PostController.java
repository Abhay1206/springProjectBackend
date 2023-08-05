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

    /**
     * The function creates a new post with the given user ID and content and
     * returns a response entity
     * with the created post's ID.
     * 
     * @param userId  An integer representing the user ID of the user creating the
     *                post.
     * @param content The "content" parameter is a string that represents the
     *                content of the post that
     *                the user wants to create.
     * @return The method is returning a ResponseEntity object with a String body
     *         and an HTTP status
     *         code of OK.
     */
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "content") String content) {
        return new ResponseEntity<String>(postService.createPost(userId, content), HttpStatus.OK);
    }

    /**
     * The function "edit" is a PUT request mapping that takes in a userId and
     * content as request
     * parameters, and returns a ResponseEntity with the result of calling the
     * editPost method from the
     * postService.
     * 
     * @param userId  The userId parameter is an Integer that represents the unique
     *                identifier of the
     *                user whose post is being edited.
     * @param content The "content" parameter is a string that represents the new
     *                content of the post
     *                that needs to be edited.
     * @return The method is returning a ResponseEntity object with a String as the
     *         response body and
     *         HttpStatus.OK as the status code.
     */
    @PutMapping("/edit")
    public ResponseEntity<String> edit(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "content") String content) {
        return new ResponseEntity<String>(postService.editPost(userId, content), HttpStatus.OK);
    }

    /**
     * This function handles a DELETE request to delete a post based on the provided
     * user ID.
     * 
     * @param userId The `userId` parameter is an integer value that represents the
     *               unique identifier of
     *               a user. It is used to specify which user's post should be
     *               deleted.
     * @return The delete method is returning a ResponseEntity object with a String
     *         body and an HTTP
     *         status code of OK.
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "userId") Integer userId) {
        return new ResponseEntity<String>(postService.deletePost(userId), HttpStatus.OK);
    }

}
