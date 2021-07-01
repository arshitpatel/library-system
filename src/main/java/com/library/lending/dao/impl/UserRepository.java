package com.library.lending.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.library.lending.dao.IUserRepository;
import com.library.lending.model.User;

@Component
public class UserRepository implements IUserRepository {

	private Map<Long, User> users = new HashMap<Long, User>();

	public User getUser(long uid) {
		return users.get(uid);
	}

	public synchronized User addUser(User user) {
		users.put(user.getuId(), user);
		return user;
	}

}
