package conf;
// 환경 설정하는 파일

import component.AA;
import component.BB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public AA aa(){
        return new AA();
    }
    @Bean
    public BB bb(){
        return new BB();
    }
}
