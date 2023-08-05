package com.task.project.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.task.project.Service.UserPhotoService;

@RestController
@RequestMapping("/pic")
public class UserPhotoController {

    @Autowired
    private UserPhotoService userPhotoService;

    /**
     * The function `uploadpic` is a POST request handler that takes in a user ID
     * and a file, and
     * returns a response entity containing the result of uploading the picture.
     * 
     * @param userId The userId parameter is an Integer that represents the user's
     *               ID. It is used to
     *               identify the user for whom the picture is being uploaded.
     * @param file   The "file" parameter is of type MultipartFile, which is a
     *               Spring class that
     *               represents an uploaded file. It allows you to access the
     *               contents of the file, such as its name,
     *               size, and content. In this case, it is used to receive the
     *               uploaded picture file.
     * @return The method is returning a ResponseEntity object with a String as its
     *         body.
     */
    @PostMapping("/uploadPic")
    public ResponseEntity<String> uploadpic(@RequestParam(name = "userId") Integer userId,
            @RequestParam MultipartFile file) throws IOException {
        return new ResponseEntity<String>(userPhotoService.uplodadPic(userId, file));
    }
}
