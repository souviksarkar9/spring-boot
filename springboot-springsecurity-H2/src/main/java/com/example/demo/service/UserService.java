package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository urepo;

	public List<User> getAllUsers() {
		logger.info("Inside getAllUsers");
		return urepo.findAll();
	}

	public User saveUserResult(User s) {
		logger.info("Inside Save");
		return urepo.save(s);
	}

	public User deleteUserResult(User s) {
		logger.info("Inside Delete");
		urepo.delete(s);
		return s;
	}

	public User findUserByEmail(String email) {
		logger.info("Inside findUserByEmail");
		return urepo.findByEmail(email);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder encoder = passwordEncoder();
		User user = Optional.ofNullable(findUserByEmail(username)).orElseThrow(RuntimeException::new);
		return new UserDetailsImpl(user , encoder);
	}

}
