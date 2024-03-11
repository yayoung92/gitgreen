package com.mh.restapi03.conf;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info=@Info(title = "YG 가 만든 USER,MAIN",
                description = "유저 등록 수정 삭제 조회 등이 가능합니다.",
                version = "v1.0.0"
    )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi groupedOpenApi(){
        String[] paths = {"/users/**"};  //users 로 시작하는 패키지만 보이게 된다.

        return GroupedOpenApi.builder()
                .group("userController 만 보내기")
                .pathsToMatch(paths)
                .build();
    }
}
