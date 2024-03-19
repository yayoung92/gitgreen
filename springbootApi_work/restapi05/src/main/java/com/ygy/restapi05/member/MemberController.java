package com.ygy.restapi05.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping()
    public String member(){
        return "member";
    }

    @PostMapping()
    public String member(@Valid @RequestBody MemberDTO memberDTO){
        System.out.println(memberDTO);

        Member member = new Member();
        BeanUtils.copyProperties(memberDTO, member);

        System.out.println("member : " + member);
        memberService.save(member);

        return "memberdto";
    }
}
