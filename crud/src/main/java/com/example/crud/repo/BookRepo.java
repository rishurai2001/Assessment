package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.models.Book;

public interface BookRepo extends JpaRepository<Book,Long>{

}
