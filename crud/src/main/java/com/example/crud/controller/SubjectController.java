package com.example.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.models.Subject;
import com.example.crud.repo.SubjectRepo;
 

@RestController
public class SubjectController {
	@Autowired
	public SubjectRepo subjectRepo;
	
	@PostMapping("/subjectSave")
	public String addSubject(@RequestBody Subject subject) {
		System.out.print("student");
		subjectRepo.save(subject);
		
		return "Data saved successfully";
	}
	
	@RequestMapping("/subjects")
	public List<Subject> getAllSubjects()
	{
		List<Subject> subjects = new ArrayList<>();
		subjectRepo.findAll().forEach(subjects::add);
		System.out.print("HI");
//		subjects.forEach(value -> System.out.println(value.subjectName));
		return subjects;
		 
	}
	@PutMapping("/subjects/{id}")
	public ResponseEntity<?> updateSubject(@PathVariable Long id, @RequestBody Subject subject)
	{
		try {
			subjectRepo.save(subject);
		return new ResponseEntity<>(HttpStatus.OK);
			} 
		
		catch (NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	 }
	
	@DeleteMapping("/subjects/{id}")
	public void DeleteSubject(@PathVariable Long id)
	{
		subjectRepo.deleteById(id);
		System.out.print("subject deleted");
		
	}
}
