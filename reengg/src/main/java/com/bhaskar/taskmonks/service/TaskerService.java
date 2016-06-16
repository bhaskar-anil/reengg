package com.bhaskar.taskmonks.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.taskmonks.domain.Tasker;
import com.bhaskar.taskmonks.repository.TaskerRepository;

@Service
@Transactional
public class TaskerService implements TaskerServiceInterface{
	
	@Autowired
	protected TaskerRepository taskerRepo;

	@Override
	public Tasker save(Tasker tasker) {
		// TODO Auto-generated method stub
		return taskerRepo.save(tasker);
	}

}
