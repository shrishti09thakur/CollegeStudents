package com.springboot.mindtree.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mindtree.model.College;
import com.springboot.mindtree.service.CollegeService;



	@RestController
	@RequestMapping("/shrclg")
	public class CollegeController {
		private CollegeService collegeService;

		public CollegeController(CollegeService collegeService) {
			super();
			this.collegeService = collegeService;
		}
		@PostMapping
		 public ResponseEntity<College> saveCollege(@RequestBody College college){
				return new ResponseEntity<College>(collegeService.saveCollege(college),HttpStatus.CREATED);
		    	 
		     }
		@GetMapping
		public List<College> getAllCollege(){
			return collegeService.getAllCollege();
		}
		@GetMapping("{id}")
		public ResponseEntity<College> getCollegeById(@PathVariable("id")long collegeid){
			return new ResponseEntity<College>(collegeService.getCollegeById(collegeid),HttpStatus.OK);
			
			
		}
	}

