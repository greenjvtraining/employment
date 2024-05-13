package com.example.employment.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	private String mid;
	private String pw;
	private String name;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<Resume> resumes;

/*	
	@Override
    public String toString() {
        return "Member{" +
                "mid='" + mid + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
*/    

}
