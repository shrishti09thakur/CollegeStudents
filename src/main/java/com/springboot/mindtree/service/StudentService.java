package com.springboot.mindtree.service;

import java.util.List;

import com.springboot.mindtree.model.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(long id);
	Student updateStudent(Student student,long id);
	List<Student> getStudentByCollegeWithDescAge(long clg_fid);


}
