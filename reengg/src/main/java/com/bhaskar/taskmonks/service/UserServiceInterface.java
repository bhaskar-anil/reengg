package com.bhaskar.taskmonks.service;

import java.util.Collection;

import com.bhaskar.taskmonks.domain.User;

public interface UserServiceInterface {
	
	public User saveUser(User user);
	
	public Boolean deleteUser(Long userId);
	
	public User editUser(User user);
	
	public User findUser(Long userId);
	
	public Collection<User> getAllUsers();

}
