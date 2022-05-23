package com.personal.miniproject.service.impl;

import com.personal.miniproject.entity.Member;
import com.personal.miniproject.repository.MemberRepository;
import com.personal.miniproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImplement implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(String memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()){
            return member.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public void insertMember(Member member) {
        System.out.println(member);
       memberRepository.save(member);
    }


    @Override
    public void deleteMemberById(String memberId) {
        memberRepository.deleteById(memberId);
    }
}
