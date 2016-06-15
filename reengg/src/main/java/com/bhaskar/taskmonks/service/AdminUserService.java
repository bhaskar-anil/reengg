package com.bhaskar.taskmonks.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.taskmonks.domain.Admin;
import com.bhaskar.taskmonks.repository.AdminUserRepository;

@Service
@Transactional
public class AdminUserService implements AdminUserServiceInterface{
	
	@Autowired
	protected AdminUserRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

}
