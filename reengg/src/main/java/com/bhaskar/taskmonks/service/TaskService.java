package com.bhaskar.taskmonks.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhaskar.taskmonks.domain.Task;
import com.bhaskar.taskmonks.repository.TaskRepository;

public class TaskService implements TaskServiceInterface{
	
	@Autowired
	protected TaskRepository taskRepository;

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public Boolean deleteTask(Long taskId) {
		Task temp = taskRepository.findOne(taskId);
		if(temp!=null){
			taskRepository.delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public Task editTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public Task findTask(Long taskId) {
		// TODO Auto-generated method stub
		return taskRepository.findOne(taskId);
	}

	@Override
	public Collection<Task> getAllTasks() {
		// TODO Auto-generated method stub
		Iterable<Task> itr = taskRepository.findAll();
		return (Collection<Task>) itr;
	}
	

}
