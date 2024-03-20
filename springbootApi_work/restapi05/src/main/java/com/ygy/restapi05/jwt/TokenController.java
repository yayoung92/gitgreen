package com.ygy.restapi05.jwt;

import com.ygy.restapi05.member.Member;
import com.ygy.restapi05.member.MemberRepository;
import com.ygy.restapi05.member.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenManager tokenManager;
    private final MemberRepository memberRepository;

    @GetMapping("/token")
    public String token(@RequestBody TokenDTO tokenDTO){
        System.out.println("email = " + tokenDTO.getEmail());
        System.out.println("password = " + tokenDTO.getPassword());
        Member dbmember = memberRepository.findByEmailAndPassword(tokenDTO.getEmail(), tokenDTO.getPassword());
        if(dbmember == null){
            throw new RuntimeException("인증안됨");
        }

        /*        Member member = Member.builder()
                .email("aaa@naver.com")
                .id(1l)
                .username("홍길동")
                .role(Role.USER)
                .build();*/
        return tokenManager.generateToken(dbmember);
    }
}
