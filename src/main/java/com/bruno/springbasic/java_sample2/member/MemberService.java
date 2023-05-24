package com.bruno.springbasic.java_sample2.member;

import com.bruno.springbasic.java_sample1.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
