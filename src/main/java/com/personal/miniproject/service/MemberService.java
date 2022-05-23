package com.personal.miniproject.service;

import com.personal.miniproject.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMember();
    Member getMemberById(String memberId);
    void insertMember(Member member);
    void deleteMemberById(String memberId);

}
