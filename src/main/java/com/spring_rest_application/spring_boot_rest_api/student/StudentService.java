package com.spring_rest_application.spring_boot_rest_api.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public void deleteStudent(Long id) {
		boolean exists = studentRepository.existsById(id);

		if (!exists) {
			throw new IllegalStateException("Student with id " + id + " does not exits");
		}
		studentRepository.deleteById(id);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = this.studentRepository.findById(studentId)
							.orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(email);

			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}

			student.setEmail(email);
		}
	}

}
