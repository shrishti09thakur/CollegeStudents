package com.springboot.mindtree.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.mindtree.clgRepository.CollegeRepository;
import com.springboot.mindtree.exception.ResourceNotFoundException;
import com.springboot.mindtree.model.College;
import com.springboot.mindtree.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {
	private CollegeRepository collegeRepository;
	

	public CollegeServiceImpl(CollegeRepository collegeRepository) {
		super();
		this.collegeRepository = collegeRepository;
	}

	@Override
	public College saveCollege(College college) {
		// TODO Auto-generated method stub
		return collegeRepository.save(college);
	}

	@Override
	public List<College> getAllCollege() {
		// TODO Auto-generated method stub
		return collegeRepository.findAll();
	}

	@Override
	public College getCollegeById(long id) {
		// TODO Auto-generated method stub
		Optional<College> college=collegeRepository.findById(id);
		if(college.isPresent()) {
			return college.get();
		}
		else {
			throw new ResourceNotFoundException("College","Id",id);
		}
	}

}
