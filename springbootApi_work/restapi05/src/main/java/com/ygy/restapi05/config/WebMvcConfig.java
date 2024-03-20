package com.ygy.restapi05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebMvcConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 스프링 부터 3 버전은 람다문법을 써야지만 에러가 발생하지 않는다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //스프링부트 2버전
        // post 방식 put 방식 delete 방식을 사용할 때 csrf 토글을 사용하지 않겠다. 허용해주겠다.
        //http.csrf(csrf -> csrf.disable()); 같은 거
        //http.csrf(s -> s.disable());
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http
                .authorizeRequests(
                        req ->
                                req.requestMatchers("/**").permitAll() // 인증된 사용자? 페이지 지정. 전체로 지정
                                        .anyRequest() // 인증된 사용자? 페이지만
                                        .authenticated() // 허용하겠다.
                                        //.notifyAll()
                );

        // 스프링시큐리티에서 필터를 다루는 방법
        //http.addFilter(filter);

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 유저 관리 하는 매니저 클래스
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        // 로그인 할 수 있는 유저 생성
//        UserDetails userDetails = User.withUsername("user")
//                    .password(passwordEncoder().encode("1234"))
//                    .roles("USER")
//                    .build();
//
//        // 유저관리 하는 매니저 클래스 유저 등록
//        userDetailsManager.createUser(userDetails);
//
//        // 유저관리 하는 매니저 IOC 컨테이너에 등록. 등록후 securityConfig 에서 사용한다.
//        return userDetailsManager;
//    }
}
