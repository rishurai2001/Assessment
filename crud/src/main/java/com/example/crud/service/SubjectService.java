package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.repo.SubjectRepo;
import com.example.crud.models.Subject;

@Service
public class SubjectService {
	@Autowired
	public SubjectRepo subjectRepo;
	
	public List<Subject> getAllSubjects() {
		
	    List<Subject> Subjects = new ArrayList<>();
		System.out.println("printing all Subjects List");
	    subjectRepo.findAll()
	    .forEach(Subjects::add);
		
	    return Subjects;		
	}
	public void addSubject(Subject subject) {
	     subjectRepo.save(subject);
	}
	
	public Subject getSubject(Long id) {
	     return subjectRepo.findById(id).orElse(null);
	}
	public void updateSubject(Long id, Subject subject) {
		
	 
		Subject exSubject = getSubject(id);
		exSubject.setSubjectName(subject.getSubjectName());
		exSubject.setTeacherName(subject.getTeacherName());
		
		subjectRepo.save(exSubject);
	      
	}
	public void deleteSubject(Long id) {
	     subjectRepo.deleteById(id);
	}
}
