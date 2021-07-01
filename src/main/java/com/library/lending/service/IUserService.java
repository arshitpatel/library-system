package com.library.lending.service;

import com.library.lending.model.User;

public interface IUserService {
	
	public User registerUser(String name, String contact);
	public User getUser(long uid);

}
