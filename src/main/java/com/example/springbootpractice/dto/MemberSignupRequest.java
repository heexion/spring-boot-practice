package com.example.springbootpractice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupRequest {

    private String loginId;
    private String password;
    private String name;
}