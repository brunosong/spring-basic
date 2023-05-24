package com.bruno.springbasic.java_sample1.order;

import com.bruno.springbasic.java_sample1.discount.DiscountPolicy;
import com.bruno.springbasic.java_sample1.member.Member;
import com.bruno.springbasic.java_sample1.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    //정확하게 DIP를 지키고 있다.
    private final DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy,MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
