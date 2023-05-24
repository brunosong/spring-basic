package com.bruno.springbasic.java_sample1;

import com.bruno.springbasic.java_sample1.discount.DiscountPolicy;
import com.bruno.springbasic.java_sample1.discount.RateDiscountPolicy;
import com.bruno.springbasic.java_sample1.member.MemberRepository;
import com.bruno.springbasic.java_sample1.member.MemberService;
import com.bruno.springbasic.java_sample1.member.MemberServiceImpl;
import com.bruno.springbasic.java_sample1.member.MemoryMemberRepository;
import com.bruno.springbasic.java_sample1.order.OrderService;
import com.bruno.springbasic.java_sample1.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Autowired MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        //return new MemberServiceImpl(memberRepository);
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
