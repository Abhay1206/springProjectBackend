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

    /**
     * The function creates a comment by taking in parameters such as follower_id,
     * content, user_id, and
     * post_id.
     * 
     * @param follower_id The ID of the user who is creating the comment. This is
     *                    the ID of the user who
     *                    is following the post or the user who is commenting on the
     *                    post.
     * @param content     The "content" parameter is a string that represents the
     *                    content of the comment.
     * @param user_id     The user_id parameter represents the ID of the user who is
     *                    creating the comment.
     * @param post_id     The `post_id` parameter is an Integer that represents the
     *                    ID of the post for which
     *                    the comment is being created.
     * @return The method is returning a ResponseEntity object with a String as the
     *         response body and
     *         HttpStatus.OK as the status code.
     */
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
