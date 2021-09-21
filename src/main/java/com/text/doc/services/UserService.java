 package com.text.doc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.doc.model.User;
import com.text.doc.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User login(String email, String password) {
		User user = repo.findByEmailAndPassword(email, password);
		return user;
	}
	
	
}
