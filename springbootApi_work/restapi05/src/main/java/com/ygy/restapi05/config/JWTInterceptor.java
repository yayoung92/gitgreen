package com.ygy.restapi05.config;

import com.ygy.restapi05.jwt.TokenManager;
import com.ygy.restapi05.member.Member;
import com.ygy.restapi05.member.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {

    private final TokenManager tokenManager;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("일로오나");

        String token = request.getHeader("Authorization");

        if(token==null || !token.startsWith("Bearer ")){
            System.out.println("token 이 없습니다.");
//            throw new RuntimeException("JWT 토큰 발생후에 해라.");
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
        }
        catch (ExpiredJwtException e){
            System.out.println("토큰 만료");
            throw new RuntimeException("JWT 토큰 만료");
        }
        catch (Exception e){
            System.out.println("토큰 검증 실패");
            throw new RuntimeException("JWT 토큰 검증 실패");
        }
        //하고싶은거 하러 가라
        return true;
    }
}
