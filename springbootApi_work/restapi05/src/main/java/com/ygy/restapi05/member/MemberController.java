package com.ygy.restapi05.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping()
    public String member(Authentication authentication){
        Member member = (Member) authentication.getPrincipal();
        return "getMember email = " + member.getEmail() +
                " : username : " + member.getUsername() +
                " : role : " + member.getRole();
    }

    @PostMapping("join")
    public ResponseEntity<String> member(@Valid @RequestBody MemberDTO memberDTO){
        System.out.println(memberDTO);
        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDTO, Member.class);

        System.out.println("member : " + member);
        memberService.save(member);

        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }
    @GetMapping("list")
    public ResponseEntity<List<Member>> member(){
        List<Member> allMembers = memberService.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(allMembers);
    }
}
