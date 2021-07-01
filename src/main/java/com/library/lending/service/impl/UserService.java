package com.library.lending.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.lending.dao.IUserRepository;
import com.library.lending.model.User;
import com.library.lending.service.IUserService;

@Component
public class UserService implements IUserService {
	
	private final IUserRepository userRepo;

	@Autowired
	public UserService(IUserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User registerUser(String name, String contact) {
		User user = null;
		synchronized (userRepo) {
			user = userRepo.addUser(new User(name, contact));
		}
		return user;
	}

	public User getUser(long uid) {
		return userRepo.getUser(uid);
	}

}
