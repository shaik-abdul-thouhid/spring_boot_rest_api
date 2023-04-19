package com.spring_rest_application.spring_boot_rest_api.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return this.studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		this.studentRepository.save(student);
	}
}
