package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.repo.StudentRepo;
import com.example.crud.models.Student;

@Service
public class StudentService {
	@Autowired
	public StudentRepo  studentRepo;
	
	public List<Student> getAllStudents() {
		
	    List<Student> students = new ArrayList<>();
		System.out.println("printing all students List");
	    studentRepo.findAll()
	    .forEach(students::add);
		
	    return students;		
	}
	public void addStudent(Student student) {
	     studentRepo.save(student);
	}
	
	public Student getStudent(Long id) {
	     return studentRepo.findById(id).orElse(null);
	}
	public void updateStudent(Long id, Student student) {
		
	 
		Student existingStudent = getStudent(id);
        existingStudent.setStudentName(student.getStudentName());
         
        studentRepo.save(existingStudent);
	      
	}
	public void deleteStudent(Long id) {
	     studentRepo.deleteById(id);
	}
}
