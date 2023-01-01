package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.crud.repo.TeacherRepo;
import com.example.crud.models.Teacher;

@Service
public class TeacherService {
	@Autowired
	public TeacherRepo  teacherRepo;
	
	public List<Teacher> getAllTeachers() {
		
	    List<Teacher> teachers = new ArrayList<>();
		System.out.println("printing all students List");
	    teacherRepo.findAll()
	    .forEach(teachers::add);
		
	    return teachers;		
	}
	public void addTeacher(Teacher teacher) {
	     teacherRepo.save(teacher);
	}
	
	
	public Teacher getTeacher(Long id) {
	     return teacherRepo.findById(id).orElse(null);
	}
	public void updateTeacher(Long id, Teacher teacher) {
		
		Teacher newTeacher = getTeacher(id);
		newTeacher.setTeacherName(teacher.getTeacherName());
		newTeacher.setTeacherSubject(teacher.getTeacherSubject());
		
        
       teacherRepo.save(newTeacher);
	      
	}
	
	
	
	public void deleteTeacher(Long id) {
	     teacherRepo.deleteById(id);
	}
}
