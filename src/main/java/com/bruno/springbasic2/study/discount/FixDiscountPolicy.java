package com.bruno.springbasic2.study.discount;

import com.bruno.springbasic2.study.vo.Grade;
import com.bruno.springbasic2.study.vo.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    /*
    *  클래스 설명
    *
    *  사용자 정보와 물건의 가격을 넣으면 등급에 따라
    *  할인 금액인 1000원을 리턴해준다.
    *  결국 최종적으로 얼마를 할인 받을지 알려주는 클래스 이다.
    *
    * */

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }


    }
}
