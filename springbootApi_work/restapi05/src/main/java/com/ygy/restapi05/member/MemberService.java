package com.ygy.restapi05.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // 저장하는 메서드 (insert 메서드)
    // email 중복체크해서 중복이면 에러로 빠진다.
    public Member save(Member member){

        Optional<Member> optionalMember
            = memberRepository.findByEmail(member.getEmail());

        if(optionalMember.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        return memberRepository.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("일로오나");
        return null;
    }
}
