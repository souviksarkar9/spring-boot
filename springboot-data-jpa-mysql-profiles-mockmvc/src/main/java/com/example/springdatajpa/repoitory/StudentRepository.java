package com.example.springdatajpa.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
