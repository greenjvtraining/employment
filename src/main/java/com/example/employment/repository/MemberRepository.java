package com.example.employment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employment.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	Member findByMidAndPw(String mid, String pw);
}
