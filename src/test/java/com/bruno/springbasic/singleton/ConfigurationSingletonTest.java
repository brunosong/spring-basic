package com.bruno.springbasic.singleton;

import com.bruno.springbasic.java_sample1.AppConfig;
import com.bruno.springbasic.java_sample1.member.MemberRepository;
import com.bruno.springbasic.java_sample1.member.MemberService;
import com.bruno.springbasic.java_sample1.member.MemberServiceImpl;
import com.bruno.springbasic.java_sample1.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        System.out.println(" memberService --> memberRepository = " + memberService.getMemberRepository());
        System.out.println(" orderService --> memberRepository = " + orderService.getMemberRepository());
        System.out.println(" memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println(appConfig.getClass());

    }


}
