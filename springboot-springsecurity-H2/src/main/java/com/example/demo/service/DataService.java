package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Data;
import com.example.demo.repository.DataRepository;

@Service
public class DataService {

	private Logger logger = LoggerFactory.getLogger(DataService.class);

	@Autowired
	private DataRepository drepo;

	public List<Data> getAllData() {
		logger.info("Inside getAllData");
		return drepo.findAll();
	}

	public Data saveDataResult(Data s) {
		logger.info("Inside Save Data");
		return drepo.save(s);
	}

	public Data deleteDataResult(Data s){
		logger.info("Inside Delete Data");
		drepo.delete(s);
		return s;
	}
	

}
