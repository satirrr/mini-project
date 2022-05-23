package com.personal.miniproject.controller;

import com.personal.miniproject.controller.pathURL.PathURL;
import com.personal.miniproject.entity.Member;
import com.personal.miniproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathURL.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/all")
    private List<Member> findAllMember(){
        return memberService.getAllMember();
    }

    @GetMapping
    private Member findMemberById(@RequestParam String memberId){
        return memberService.getMemberById(memberId);
    }

    @PostMapping
    private void insertMember(@RequestBody Member member){
        memberService.insertMember(member);
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
