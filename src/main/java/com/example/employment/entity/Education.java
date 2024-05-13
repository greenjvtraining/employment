package com.example.employment.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eno;
	private String schoolName;
	private String status; //졸업여부
	private LocalDate inDate;
	private LocalDate outDate;
	@ManyToOne
	@JoinColumn(name = "rno")
	private Resume resume;
	
	//동기 혹은 동창을 찾기위해서는 Resume 객체를 속성으로 두기.(양방향매핑)
}
