package com.bruno.springbasic.java_sample1.discount;

import com.bruno.springbasic.java_sample1.member.Grade;
import com.bruno.springbasic.java_sample1.member.Member;

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
