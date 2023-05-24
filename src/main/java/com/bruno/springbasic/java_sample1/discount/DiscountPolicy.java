package com.bruno.springbasic.java_sample1.discount;

import com.bruno.springbasic.java_sample1.member.Member;

public interface DiscountPolicy {

    /**
     * 
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
    
}
