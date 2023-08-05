package com.task.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.project.Model.User;

import com.task.project.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String follow(Integer a_userId, Integer b_userId) {
        User a = userRepository.findById(a_userId).orElse(null);
        a.getFollowersId().add(b_userId);
        userRepository.save(a);
        return "followed";
    }

    public String editName(Integer userId, String name) {
        User user = userRepository.findById(userId).orElseThrow();
        if (user == null) {
            return "NO User found";
        }
        user.setName(name);
        userRepository.save(user);
        return "Name is updated successfully";

    }

    public User getuser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public String editBio(Integer userId, String bio) {
        User user = userRepository.findById(userId).orElseThrow();
        if (user == null) {
            return "NO User found";
        }
        user.setBio(bio);
        userRepository.save(user);
        return "Name is updated successfully";

    }

    public String editAddress(Integer userId, String address) {
        User user = userRepository.findById(userId).orElseThrow();
        if (user == null) {
            return "NO User found";
        }
        user.setAddress(address);
        userRepository.save(user);
        return "Name is updated successfully";

    }

}
