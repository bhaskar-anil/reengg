package com.bhaskar.taskmonks.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhaskar.taskmonks.domain.User;
import com.bhaskar.taskmonks.repository.UserRepository;

public class UserService implements UserServiceInterface{
	
	@Autowired
	protected UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Boolean deleteUser(Long userId) {
		// TODO Auto-generated method stub
		User temp = userRepository.findOne(userId);
		if(temp!=null){
			userRepository.delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User findUser(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findOne(userId);
	}

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		Iterable<User> itr = userRepository.findAll();
		return (Collection<User>) itr;
	}

}
