package com.library.lending.dao;

import com.library.lending.model.User;

public interface IUserRepository {

	public User getUser(long uid);

	public User addUser(User user);

}
