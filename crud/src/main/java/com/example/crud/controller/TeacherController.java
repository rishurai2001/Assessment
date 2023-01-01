package com.example.crud.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.models.Teacher;
import com.example.crud.service.TeacherService;


 

@RestController
public class TeacherController {
	@Autowired
	public TeacherService teacherService;
	
	@PostMapping("/teacherSave")
	public String addteacher(@RequestBody Teacher teacher) {
		System.out.print("teacher");
		teacherService.addTeacher(teacher);
		
		return "Data saved successfully";
	}
	
	
	@RequestMapping("/teachers")
	public List<Teacher> getAllteachers()
	{
		 
		return teacherService.getAllTeachers();
		 
	}
	
	@PutMapping("/teachers/{id}")
	public void updateteacher(@PathVariable Long id, @RequestBody Teacher teacher)
	{
		
		
		teacherService.updateTeacher(id,teacher);
	 }
	
	@DeleteMapping("/teachers/{id}")
	public void Deleteteacher(@PathVariable Long id)
	{
		teacherService.deleteTeacher(id);
		System.out.print("teacher deleted");
		
	}
}
