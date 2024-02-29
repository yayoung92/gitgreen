package org.example.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // AOP 기능 활성화 하겠다. IOC 컨테이너에 이것을 적어줘야 Aspect 어노테이션 사용 가능하다.
@ComponentScan({"org.example.aspect","org.example.components"})
public class AppCtx {
}
