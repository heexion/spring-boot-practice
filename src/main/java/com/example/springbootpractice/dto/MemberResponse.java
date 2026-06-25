package com.example.springbootpractice.dto;

import com.example.springbootpractice.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponse {

    private Long id;
    private String loginId;
    private String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.name = member.getName();
    }
}