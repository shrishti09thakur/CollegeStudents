package com.springboot.mindtree.clgRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mindtree.model.College;

public interface CollegeRepository extends JpaRepository<College,Long>  {

}
