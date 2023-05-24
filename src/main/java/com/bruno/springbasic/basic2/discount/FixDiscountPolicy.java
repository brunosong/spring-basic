package com.bruno.springbasic.basic2.discount;

import com.bruno.springbasic.java_sample1.member.Grade;
import com.bruno.springbasic.java_sample1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
