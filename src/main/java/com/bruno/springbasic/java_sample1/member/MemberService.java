package com.bruno.springbasic.java_sample1.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
