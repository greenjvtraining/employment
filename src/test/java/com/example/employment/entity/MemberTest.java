package com.example.employment.entity;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.employment.repository.MemberRepository;
import com.example.employment.repository.ResumeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MemberTest {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ResumeRepository resumeRepository;
	
	
	@Test
	@Transactional
	public void showMember() {
		Optional<Member> result = memberRepository.findById("user02");
		Member member = result.get();
		
		System.out.println(member.getResumes());
	}
	
	//@Test
	@Transactional
	public void showTest() {
		//회원의 이력서(들)조회
		Optional<Member> result = memberRepository.findById("user02");
		
		Member member = result.get();
		List<Resume> list = member.getResumes();
		System.out.println(member);
		System.out.println(list);
	}
	
	//@Test
	@Transactional
	public void showResume() {
		List<Resume> list = resumeRepository.findAll();
		
		System.out.println(list);
		//1. toString에 Member 속성 들어가 있으면 error(Lazy) => ToString에 Member속성 제외
		//2. toString에 Member 속성 들어가 있어도 실행 메소드(테스트메소드)에 @Transactional 어노테이션 있으면 정상수행됨.
	}
	
	//@Test
	@Transactional
	public void showResume2() {
		Member member = new Member();
		member.setMid("user02");
		List<Resume> list = resumeRepository.findByMember(member);
		
		System.out.println(list);
		//1. toString에 Member 속성 들어가 있으면 error(Lazy) => ToString에 Member속성 제외
		//2. toString에 Member 속성 들어가 있어도 실행 메소드(테스트메소드)에 @Transactional 어노테이션 있으면 정상수행됨.
	}
	
}
