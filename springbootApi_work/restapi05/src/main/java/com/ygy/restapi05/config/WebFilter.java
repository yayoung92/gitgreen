package com.ygy.restapi05.config;

import com.ygy.restapi05.jwt.TokenManager;
import com.ygy.restapi05.member.Member;
import com.ygy.restapi05.member.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;
import java.util.stream.Stream;

@Component  // IOC 컨테이너에 객체 주입
@RequiredArgsConstructor
public class WebFilter extends OncePerRequestFilter {

    private final TokenManager tokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("필터 동작");

        String token = request.getHeader("Authorization");
        String url = request.getRequestURI();

        // 이페이지에서는 token 을 검사하지 않는다.
        if(url.contains("login") || url.contains("join") || url.contains("token")){
            filterChain.doFilter(request, response);
            return;
        }

        if(token==null || !token.startsWith("Bearer ")){
            System.out.println("token 이 없습니다.");
            throw new RuntimeException("JWT 토큰 발생후에 해라.");
        }

        try{
            Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()));

            List<SimpleGrantedAuthority> roles =
                    Stream.of(jws.getBody().get("role").toString())
                            .map(SimpleGrantedAuthority::new)
                            .toList();

            System.out.println(roles);

            // 로그인 한 사람 정보를 Authenticaion 에 저장해라
            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                    Member.builder()
                            .email(jws.getPayload().get("email").toString())
                            .username(jws.getPayload().get("username").toString())
                            .id(jws.getPayload().get("id", Long.class))
                            .role(
                                    Role.fromString(jws.getPayload().get("role").toString())
                            )
                            .build(),
                    null,
                    roles
            );

            // 로그인한 사람 정보를 저장해라
            SecurityContextHolder.getContext().setAuthentication(authentication); // IOC 컨테이너에 돌아가면서 저장

            filterChain.doFilter(request, response);
        }
        catch (ExpiredJwtException e){
            System.out.println("토큰 만료");
            throw new RuntimeException("JWT 토큰 만료");
        }
        catch (Exception e){
            System.out.println("토큰 검증 실패");
            throw new RuntimeException("JWT 토큰 검증 실패");
        }

    }
}
