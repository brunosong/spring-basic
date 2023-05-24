package com.bruno.springbasic.basic1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    MemberRepository memberRepository() {
        return new MemoryDbMemberRepository();
    }

}
