package com.task.project.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResgisterRequest {

    private String name;
    private String bio;
    private String address;
    private String email;
    private String password;
}
