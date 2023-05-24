package com.bruno.springbasic2.study;


import com.bruno.springbasic2.study.service.MemberService;
import com.bruno.springbasic2.study.service.MemberServiceImpl;
import com.bruno.springbasic2.study.vo.Grade;
import com.bruno.springbasic2.study.vo.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void setup(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}