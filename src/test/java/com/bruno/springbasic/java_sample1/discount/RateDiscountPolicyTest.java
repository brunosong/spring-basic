package com.bruno.springbasic.java_sample1.discount;

import com.bruno.springbasic.java_sample1.member.Grade;
import com.bruno.springbasic.java_sample1.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10프로 할인이 적용되어야 한다.")
    void vip_o() {

        Member member = new Member(1L, "vip", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);

    }


    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {

        Member member = new Member(1L, "vip", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);

    }

}