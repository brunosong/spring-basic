package com.bruno.springbasic2.study;

import com.bruno.springbasic2.study.order.Order;
import com.bruno.springbasic2.study.order.OrderService;
import com.bruno.springbasic2.study.service.MemberService;
import com.bruno.springbasic2.study.vo.Grade;
import com.bruno.springbasic2.study.vo.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void setup(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "ITEM_A", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}
