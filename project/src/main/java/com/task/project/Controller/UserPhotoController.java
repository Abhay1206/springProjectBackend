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

    @PostMapping("/uploadPic")
    public ResponseEntity<String> uploadpic(@RequestParam(name = "userId") Integer userId,
            @RequestParam MultipartFile file) throws IOException {
        return new ResponseEntity<String>(userPhotoService.uplodadPic(userId, file));
    }
}
