package com.git.ex03.conf;

import com.git.ex03.member.MemberRepository;
import com.git.ex03.member.MemberService;
import com.git.ex03.myanno.ManualBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan({"aa.bb.cc"})
@ComponentScan(value = "aa.bb.cc",
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class) // ManualBean 이름의 어노테이션 등록하지 않겠다.
        })
public class MyConf {

    @Bean
    public MemberService memberService(){
        return new MemberService();
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepository();
    }
}
