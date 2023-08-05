package com.task.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.task.project.Model.User;
import com.task.project.Model.UserPhtoto;
import com.task.project.Repository.UserPhotoRepository;
import com.task.project.Repository.UserRepository;

import io.jsonwebtoken.io.IOException;

@Service
public class UserPhotoService {

    @Autowired
    private UserPhotoRepository userPhotoRepository;
    @Autowired
    private UserRepository userRepository;

    public HttpStatusCode uplodadPic(Integer id, MultipartFile file) throws java.io.IOException {
        try {
            byte[] picByte = file.getBytes();
            User user = userRepository.findById(id).orElseThrow();
            UserPhtoto userPhoto = new UserPhtoto();
            userPhoto.setPicByte(picByte);
            userPhoto.setUser(user);
            userPhotoRepository.save(userPhoto);
            return HttpStatusCode.valueOf(200);
        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatusCode.valueOf(400);

        }
    }
}
