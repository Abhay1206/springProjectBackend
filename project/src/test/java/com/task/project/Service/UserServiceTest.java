package com.task.project.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.task.project.Model.User;
import com.task.project.Repository.UserRepository;

@SpringBootTest

public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void testEditAddress() {
        User u = new User();
        User.builder().id(4).name("arpit").email("arpit@gmail.com").password("1222").address("sanjay colony").bio("hi")
                .build();
        userRepository.save(u);
        userService.editAddress(4, "sector 56 56A");

    }

    @Test
    void testEditBio() {
        User u = new User();
        User.builder().id(4).name("arpit").email("arpit@gmail.com").password("1222").address("sanjay colony").bio("hi")
                .build();
        userRepository.save(u);
        userService.editBio(4, "sector 56 56A");
    }

    @Test
    void testEditName() {
        User u = new User();
        User.builder().id(4).name("arpit").email("arpit@gmail.com").password("1222").address("sanjay colony").bio("hi")
                .build();
        userRepository.save(u);
        userService.editName(4, "Arpit Singh");
    }

    @Test
    void testGetuser() {
        User u = userService.getuser(1);
        System.out.print(u.getEmail());
    }
}
