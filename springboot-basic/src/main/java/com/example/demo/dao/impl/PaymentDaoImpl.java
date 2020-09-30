package com.example.demo.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.PaymentDao;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	Logger logger = LoggerFactory.getLogger(PaymentDaoImpl.class);

	@Override
	public void display(long amount) {
		logger.debug("Inside Payment Dao: amount paid {} " , amount );
	}

}
