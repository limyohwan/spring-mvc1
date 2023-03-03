package com.hello.servlet.web.springmvc.v3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;

@Controller
public class SpringMemberControllerV3 {
    
    private MemberRepository memberRepository = MemberRepository.getInstance();
    
    // @GetMapping
    @RequestMapping(value= "/springmvc/v3/members/new-form", method = RequestMethod.GET)
    public String newform(){
        return "new-form";
    }

    // @PostMapping
    @RequestMapping(value= "/springmvc/v3/members", method = RequestMethod.GET)
    public String save(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    // @GetMapping
    @RequestMapping(value ="/springmvc/v3/members/save", method = RequestMethod.POST)
    public String members(@RequestParam String username, @RequestParam int age, Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
