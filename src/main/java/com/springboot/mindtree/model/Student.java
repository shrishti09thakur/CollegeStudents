package com.springboot.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rollno;
	
	@Column(name="name",nullable=false)
	private String name;
	
	
	
	public Student(long rollno, String name, String age, String gender, String stream) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.Stream = stream;
	}

	public Student() {
		super();
	}

	public long getRollno() {
		return rollno;
	}

	public void setRollno(long rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		this.Stream = stream;
	}


	@Column(name="age")
	private String age;
	
	@Column(name="gender")
	private String gender;
	@Column(name="stream")
	private String Stream;

}
