package com.example.employment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employment.entity.Member;
import com.example.employment.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long>{
	List<Resume> findByMember(Member member);
}
