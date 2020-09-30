package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.User;
import com.example.demo.model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long>{
	
}
