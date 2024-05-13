package com.example.employment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employment.entity.Member;
import com.example.employment.entity.Resume;
import com.example.employment.repository.MemberRepository;
import com.example.employment.repository.ResumeRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ResumeRepository resumeRepository;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/regForm")
	public void regForm() {
		System.out.println("regForm......");
	}
	
	@RequestMapping("/regProc")
	public String regProc(Member member) {
		memberRepository.save(member);
		return "redirect:/loginForm";
	}
	
	@RequestMapping("/loginForm")
	public void loginForm() {
		System.out.println("loginForm.....");
	}
	
	@RequestMapping("/loginProc")
	public String loginProc(HttpServletRequest request, @RequestParam("mid") String mid,@RequestParam("pw") String pw) {
		Member member = memberRepository.findByMidAndPw(mid, pw);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(HttpServletRequest request) {
		String view = "/writeForm";
		HttpSession session = request.getSession();
		if(session.getAttribute("member") == null) {
			view = "/loginForm";
		}
		
		return view;
	}
	
	@RequestMapping("/writeProc")
	public String writeProc(Resume resume) {
		resumeRepository.save(resume);
		
		return "redirect:/mypage";
	}
	
	@RequestMapping("/mypage")
	public void mypage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		List<Resume> list = resumeRepository.findByMember(member);
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/mypage2")
	public void mypage2(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Member member0 = (Member)session.getAttribute("member");
		Optional<Member> result = memberRepository.findById(member0.getMid());
		//Optional<Member> result = memberRepository.findById("user02");
		Member member = result.get();
		
		List<Resume> list = member.getResumes();
		
		System.out.println(member);
		System.out.println(member.getResumes());
		model.addAttribute("list", list);
		
	}
}
