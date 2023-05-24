package com.bruno.springbasic.java_sample2.discount;

import com.bruno.springbasic.java_sample1.member.Grade;
import com.bruno.springbasic.java_sample1.member.Member;
import com.bruno.springbasic.java_sample2.annotation.MainDiscountPolicy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; //1000원 할인

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
