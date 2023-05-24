package com.bruno.springbasic2.study.service;

import com.bruno.springbasic2.study.vo.Member;
import com.bruno.springbasic2.study.repository.MemberRepository;
import com.bruno.springbasic2.study.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository;

    /* 이것을 생성자 주입이라고 한다. */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
