package com.bruno.springbasic.java_sample1.order;

import com.bruno.springbasic.java_sample1.AppConfig;
import com.bruno.springbasic.java_sample1.member.Grade;
import com.bruno.springbasic.java_sample1.member.Member;
import com.bruno.springbasic.java_sample1.member.MemberService;
import com.bruno.springbasic.java_sample1.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000 );

        System.out.println(order.calculatePrice());

        System.out.println(order);

    }

}
