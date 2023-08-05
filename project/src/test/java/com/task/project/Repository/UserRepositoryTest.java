package com.task.project.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.project.Model.User;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {

        User ex = new User();
        User.builder().name("Abhay").email("abhay2@gmail.com").password("5555").address("h125").bio("hello").id(3)
                .build();
        userRepository.save(ex);
        User ac = userRepository.findByEmail("abhay2@gmail.com").orElse(null);
        equals(ex.equals(ac));
    }
}
