package com.example.springbootpractice.controller;

import com.example.springbootpractice.dto.MemberLoginRequest;
import com.example.springbootpractice.dto.MemberResponse;
import com.example.springbootpractice.dto.MemberSignupRequest;
import com.example.springbootpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(@RequestBody MemberSignupRequest request) {
        return memberService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberLoginRequest request) {
        return memberService.login(request);
    }

    @GetMapping
    public List<MemberResponse> findMembers() {
        return memberService.findMembers();
    }
}