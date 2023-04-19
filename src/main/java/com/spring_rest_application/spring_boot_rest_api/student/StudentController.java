package com.spring_rest_application.spring_boot_rest_api.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("")
	public List<Student> getStudents() {
		return this.studentService.getStudents();
	}

	@PostMapping("")
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}

}
