package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.models.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
