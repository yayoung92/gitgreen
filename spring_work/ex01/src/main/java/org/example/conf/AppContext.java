package org.example.conf;

import org.example.component.AA;
import org.example.component.BB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 객체 담는 통이다 라는 뜻(IOC 컨테이너, 공장)
@Configuration
public class AppContext {

    // 객체를 넣겠다 -Bean
    @Bean
    public AA aa(){
        return new AA();
    }

    @Bean
    public BB bb(){
        BB bb = new BB();
        bb.setHi(String.format("%s","안녕하세요"));
        return bb;
    }
}
