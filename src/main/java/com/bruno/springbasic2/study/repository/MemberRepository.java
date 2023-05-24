package com.bruno.springbasic2.study.repository;

import com.bruno.springbasic2.study.vo.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
