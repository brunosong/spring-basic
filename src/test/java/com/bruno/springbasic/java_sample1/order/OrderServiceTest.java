package com.bruno.springbasic.java_sample1.order;

import com.bruno.springbasic.java_sample1.AppConfig;
import com.bruno.springbasic.java_sample1.member.Grade;
import com.bruno.springbasic.java_sample1.member.Member;
import com.bruno.springbasic.java_sample1.member.MemberService;
import com.bruno.springbasic.java_sample1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000 );

        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);

    }
}
