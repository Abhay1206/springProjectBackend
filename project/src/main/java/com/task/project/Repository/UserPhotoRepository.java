package com.task.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.project.Model.UserPhtoto;

public interface UserPhotoRepository extends JpaRepository<UserPhtoto, Integer> {

}
