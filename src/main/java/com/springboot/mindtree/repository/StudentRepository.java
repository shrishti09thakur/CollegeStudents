package com.springboot.mindtree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.springboot.mindtree.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

	@Query(value="SELECT * FROM shrishticlgstud WHERE clg_fid=:clg_fid ORDER BY name ASC", nativeQuery = true)
	List<Student> getByDeptId(@Param("clg_fid") long clg_fid);
	@Query(value="SELECT * FROM shrishticlgstud WHERE clg_fid=:clg_fid ORDER BY age DESC", nativeQuery = true)
	List<Student> getStudentByCollegeWithDescAge(@Param("clg_fid") long clg_fid);

}
