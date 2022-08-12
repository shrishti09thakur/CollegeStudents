package com.springboot.mindtree;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.springboot.mindtree.model.Student;
import com.springboot.mindtree.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SpringbootCollegestudentApplicationTests {
	@Autowired
    private MockMvc mockMvc;
	@Autowired
    private StudentRepository studentRepository;
	@Test
	@BeforeEach
	void contextLoads() {
		  studentRepository.deleteAll();
	}
	public void givenListOfStudnet_whenGetAllStudent_thenReturnStudentList() throws Exception{
        // given - precondition or setup
        List<Student> listOfStudent = new ArrayList<>();
        listOfStudent.add(new Student(1,"Shrishti","Science","Female","34"));
        listOfStudent.add(new Student(2,"Parkriti","Commerce","Female","34"));
        studentRepository.saveAll(listOfStudent);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("http://localhost:9092/employee"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfStudent.size())));

    }

}
