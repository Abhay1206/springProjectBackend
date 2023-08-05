package com.task.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.project.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
