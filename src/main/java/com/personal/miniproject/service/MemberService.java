package com.personal.miniproject.service;

import com.personal.miniproject.entity.Member;

public interface MemberService {
    Member getMemberById(String memberId);
    Member insertMember(Member member);
    void deleteMemberById(String memberId);

}
