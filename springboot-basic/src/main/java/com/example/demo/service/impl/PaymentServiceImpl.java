package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PaymentDao;
import com.example.demo.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;
	
	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public String payAmount(long amount) {
		logger.debug("Inside Payment Impl");
		paymentDao.display(amount);
		return "suceess";
	}

}
