package com.hello.servlet.web.springmvc.v2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;

@Controller
public class SpringMemberControllerV2 {
    
    private MemberRepository memberRepository = MemberRepository.getInstance();
    
    @RequestMapping("/springmvc/v2/members/new-form")
    public ModelAndView newform(){
        return new ModelAndView("new-form");
    }

    @RequestMapping("/springmvc/v2/members")
    public ModelAndView save() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");

        mv.addObject("members", members);
        return mv;
    }

    @RequestMapping("/springmvc/v2/members/save")
    public ModelAndView members(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }
}
