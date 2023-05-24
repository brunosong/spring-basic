package com.bruno.springbasic.java_sample2.order;

import com.bruno.springbasic.java_sample2.annotation.MainDiscountPolicy;
import com.bruno.springbasic.java_sample2.discount.DiscountPolicy;
import com.bruno.springbasic.java_sample1.member.Member;
import com.bruno.springbasic.java_sample2.member.MemberRepository;
import com.bruno.springbasic.java_sample1.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    
    //여러가지 빈이 있을때는 크게 3가지가 있다. 
    //@Autowired 필드명 매칭
    //@Qualifier -> @Qualifier 끼리 매칭 -> 빈 이름 매칭
    //@Primary 사용

    
    private final DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;

    @Autowired
    //public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository ) {  1. rateDiscountPolicy로 바꿔주면 이름을 매칭해서 자동으로 넣어준다.
    public OrderServiceImpl(@MainDiscountPolicy DiscountPolicy discountPolicy, MemberRepository memberRepository ) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }


}
