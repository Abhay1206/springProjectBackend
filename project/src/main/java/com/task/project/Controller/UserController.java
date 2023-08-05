package com.task.project.Controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.project.Model.User;
import com.task.project.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    private final UserService userService;

    @PutMapping("/editName")
    public ResponseEntity<String> editName(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "name") String name) {
        return new ResponseEntity<String>(userService.editName(userId, name), HttpStatus.CREATED);
    }

    @PutMapping("/editBio")
    public ResponseEntity<String> editBio(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "bio") String bio) {
        return new ResponseEntity<String>(userService.editBio(userId, bio), HttpStatus.CREATED);
    }

    @PutMapping("/editAddress")
    public ResponseEntity<String> editAddress(@RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "address") String address) {
        return new ResponseEntity<String>(userService.editAddress(userId, address), HttpStatus.CREATED);
    }

    // @GetMapping("/getfollowers")
    // public ResponseEntity<Set<Follower>> getallf(@RequestParam(name = "userId")
    // Integer userId) {
    // return new ResponseEntity<Set<Follower>>(userService.getaLL(userId),
    // HttpStatus.OK);
    // }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam(name = "userId") Integer userId) {
        return new ResponseEntity<User>(userService.getuser(userId),
                HttpStatus.OK);
    }

    @PostMapping("/followUser")
    public ResponseEntity<String> follow(@RequestParam(name = "aId") Integer aId,
            @RequestParam(name = "bId") Integer bId) {
        return new ResponseEntity<String>(userService.follow(aId, bId), HttpStatus.OK);
    }
}
