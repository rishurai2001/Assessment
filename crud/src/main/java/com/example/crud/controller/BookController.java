package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.models.Book;
import com.example.crud.repo.BookRepo;

@RestController
public class BookController {

	@Autowired
	BookRepo bookRepo;
	
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		System.out.print("Hello");
		bookRepo.save(book);
		
		return "Data saved successfully";
	}
}
