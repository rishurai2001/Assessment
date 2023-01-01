package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.models.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
