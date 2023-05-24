package com.bruno.springbasic2.study.discount;

import com.bruno.springbasic2.study.vo.Grade;
import com.bruno.springbasic2.study.vo.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; //10% 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }


    }
}
