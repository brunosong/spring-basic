package com.bruno.springbasic2.study.service;

import com.bruno.springbasic2.study.vo.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
