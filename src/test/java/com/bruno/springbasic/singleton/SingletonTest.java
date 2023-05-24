package com.bruno.springbasic.singleton;

import com.bruno.springbasic.java_sample1.AppConfig;
import com.bruno.springbasic.java_sample1.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotEqualTo(memberService2);

    }


    @Test
    @DisplayName("싱글톤 패턴")
    void singletonPatternTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        singletonService1.logic();
        singletonService2.logic();

        assertThat(singletonService1).isSameAs(singletonService2);
    }


    @Test
    @DisplayName("스프링 DI 컨테이너")
    void springContainer(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean(MemberService.class);
        MemberService memberService2 = ac.getBean(MemberService.class);

        assertThat(memberService1).isSameAs(memberService2);

    }







}
