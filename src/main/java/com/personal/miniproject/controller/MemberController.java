package com.personal.miniproject.controller;

import com.personal.miniproject.controller.pathURL.PathURL;
import com.personal.miniproject.entity.Member;
import com.personal.miniproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathURL.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping
    private Member findMemberById(@RequestParam String memberId){
        return memberService.getMemberById(memberId);
    }

    @PostMapping
    private Member insertMember(@RequestBody Member member){
        return memberService.insertMember(member);
    }

    @PutMapping
    private void updateMember(@RequestBody Member member){
        memberService.insertMember(member);
    }

    @DeleteMapping
    private void deleteMember(@RequestParam String memberId){
        memberService.deleteMemberById(memberId);
    }
}
