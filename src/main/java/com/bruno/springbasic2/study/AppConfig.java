package com.bruno.springbasic2.study;

import com.bruno.springbasic2.study.discount.DiscountPolicy;
import com.bruno.springbasic2.study.discount.RateDiscountPolicy;
import com.bruno.springbasic2.study.order.OrderService;
import com.bruno.springbasic2.study.order.OrderServiceImpl;
import com.bruno.springbasic2.study.repository.MemoryMemberRepository;
import com.bruno.springbasic2.study.service.MemberService;
import com.bruno.springbasic2.study.service.MemberServiceImpl;

/* 전체적인 코드를 관리하는 객체 */
/* 구성정보에는 한눈에 구성이 어떻게 되어있는지 확인 되어야 한다. */
/* 사용영역과 구성영역으로 완벽하게 나뉘었다. 구성(설정)영역을 분리하는것은 완전 중요한 일이다.
*
*
*
* */
public class AppConfig {

    //멤버 서비스는 멤버 리포지토리를 쓰는구나라고 바로 알수 있음
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }


    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //리팩토링을 통해서 각 역활이 정확하게 보여진다.
    //디스카운트 폴리시는 정률 할인를 사용하는구나 라는게 한눈에 보인다.
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
