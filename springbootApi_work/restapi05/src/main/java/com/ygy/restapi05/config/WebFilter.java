package com.ygy.restapi05.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component  // IOC 컨테이너에 객체 주입
public class WebFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("필터 동작");

        // 서버에 해당되는 id, password 가 맞으면 그 다음 진행해라
        String myheader = request.getHeader("my-header");
        System.out.println(myheader);

        filterChain.doFilter(request,response);  // 필터 동작하고 들어오는거 진행해라 라는 뜻
    }
}
