package com.bruno.springbasic.java_sample2.member;

import com.bruno.springbasic.java_sample1.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
