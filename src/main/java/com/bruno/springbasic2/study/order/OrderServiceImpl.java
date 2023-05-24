package com.bruno.springbasic2.study.order;

import com.bruno.springbasic2.study.discount.DiscountPolicy;
import com.bruno.springbasic2.study.discount.FixDiscountPolicy;
import com.bruno.springbasic2.study.discount.RateDiscountPolicy;
import com.bruno.springbasic2.study.repository.MemberRepository;
import com.bruno.springbasic2.study.service.MemberService;
import com.bruno.springbasic2.study.service.MemberServiceImpl;
import com.bruno.springbasic2.study.vo.Member;

public class OrderServiceImpl implements OrderService {


    //역활과 구현을 충분히 분리했다.
    //다형성도 활용하고 인터페이스도 분리했다.
    //클래스 의존관계를 분석해 보자. 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다

    MemberRepository memberRepository;
    DiscountPolicy discountPolicy;

    /*
    *
    * 이렇게 바꿔주면 철저하게 DIP를 준수하는것이다.
    * 이렇게 해주면 밖에서 메모리 리포지토리를 넣어줄지 다른 리포지토리를 넣어줄지 이 클래스는 알수가 없다.
    * 딱 인터페이스에만 의존을 하고 있다.
    * 인터페이스만 보고 그 로직만 실행을 해주면 되는것이다.
    *
    * */

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
