package com.mh.restapi02.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberRepository memberRepository;  // final 꼭 적어야 ㅎ마. final 안 적으면 주입 안됨
    @GetMapping("member") // select 구문이 실행된다.
    public List<Member> allMember(){
        List<Member> list = memberRepository.findAll();
        System.out.println(list);
        return list;
    }

    @PostMapping("member") // insert 구문이 실행된다.
    public Member memberSave(String username1, String email1){
        System.out.println(username1);
        System.out.println(email1);
        Member member = Member.builder()
                .username(username1)
                .email(email1)
                .build();
        Member dbmember = memberRepository.save(member);
        return dbmember;
    }

    @PutMapping("member") // update 구문이 실행된다.
    public Member update(Long id, String username, String email){
        Member member = Member.builder()
                .id(id)
                .username(username)
                .email(email)
                .build();
        Member dbmember = memberRepository.save(member);
        return dbmember;
    }

    @DeleteMapping("member") // update 구문이 실행된다.
    public String delete(Long id){
        memberRepository.deleteById(id);
        return "id = " + id + "가 삭제되었습니다.";
    }
}
