package com.springboot.mindtree.service;

import java.util.List;

import com.springboot.mindtree.model.College;

public interface CollegeService  {
	List<College> getAllCollege();
	College getCollegeById(long id);
	College saveCollege(College college);

}
