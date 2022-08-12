package com.springboot.mindtree.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mindtree.model.Student;
import com.springboot.mindtree.service.StudentService;

@RestController
@RequestMapping("/shrstud")
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@PostMapping
	 public ResponseEntity<Student> saveStudent(@RequestBody Student student){
			return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	    	 
	     }
	@GetMapping
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id")long studentid){
		return new ResponseEntity<Student>(studentService.getStudentById(studentid),HttpStatus.OK);
		
		
	}
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id ,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
	
}
	@GetMapping("desc_age/{clg_fid}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable long clg_fid)
	{
		return studentService.getStudentByCollegeWithDescAge(clg_fid);
	}
}
