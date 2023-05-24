package com.bruno.springbasic.java_sample1.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
