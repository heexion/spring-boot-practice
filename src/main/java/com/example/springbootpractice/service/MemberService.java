package com.example.springbootpractice.service;

import com.example.springbootpractice.dto.MemberLoginRequest;
import com.example.springbootpractice.dto.MemberResponse;
import com.example.springbootpractice.dto.MemberSignupRequest;
import com.example.springbootpractice.entity.Member;
import com.example.springbootpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String signup(MemberSignupRequest request) {
        Member member = new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getName()
        );

        memberRepository.save(member);

        return "회원가입 성공";
    }

    public String login(MemberLoginRequest request) {
        Member member = memberRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        if (!member.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return "로그인 성공";
    }

    public List<MemberResponse> findMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::new)
                .toList();
    }
}