package com.personal.miniproject.controller;

import com.personal.miniproject.controller.pathURL.PathURL;
import com.personal.miniproject.entity.Member;
import com.personal.miniproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathURL.MEMBER)
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping
    private Member findMemberById(String memberId){
        return memberService.getMemberById(memberId);
    }
}
