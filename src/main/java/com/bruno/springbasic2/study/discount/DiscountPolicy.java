package com.bruno.springbasic2.study.discount;

import com.bruno.springbasic2.study.vo.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
