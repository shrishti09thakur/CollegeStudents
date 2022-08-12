package com.springboot.mindtree.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.mindtree.exception.ResourceNotFoundException;
import com.springboot.mindtree.model.Student;
import com.springboot.mindtree.repository.StudentRepository;
import com.springboot.mindtree.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		else {
			throw new ResourceNotFoundException("Student","Id",id);
		}
	}
	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		Student existingStudent=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student","Id",id));
		existingStudent.setName(student.getName());
		existingStudent.setStream(student.getStream());
		existingStudent.setAge(student.getAge());
		existingStudent.setGender(student.getGender());
		studentRepository.save(existingStudent);
		return existingStudent;
	}
	@Override
	public List<Student> getStudentByCollegeWithDescAge(long clg_fid) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByCollegeWithDescAge(clg_fid);
	}
	
	
	}


