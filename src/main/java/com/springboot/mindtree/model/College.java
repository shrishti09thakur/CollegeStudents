package com.springboot.mindtree.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="college")
public class College {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long id ;
	@Column(name="name",nullable=false)

	private String name;
	@Column(name="noofstudents")
	private String noofstudents;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="clg_fid",referencedColumnName="id")
	List<Student> student=new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNoofstudents() {
		return noofstudents;
	}
	public void setNoofstudents(String noofstudents) {
		this.noofstudents = noofstudents;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	

	public College(long id, String name, String noofstudents, List<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.noofstudents = noofstudents;
		this.student = student;
	}
	
	public College() {
		super();
	}

	

}
