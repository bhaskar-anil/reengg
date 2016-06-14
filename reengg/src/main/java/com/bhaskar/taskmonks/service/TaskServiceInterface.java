package com.bhaskar.taskmonks.service;

import java.util.Collection;

import com.bhaskar.taskmonks.domain.Task;

public interface TaskServiceInterface {
	
	public Task saveTask(Task task);
	
	public Boolean deleteTask(Long taskId);
	
	public Task editTask(Task task);
	
	public Task findTask(Long taskId);
	
	public Collection<Task> getAllTasks();
	
	public int countTasks();
	
	public Collection<Task> findAllTasksByCatUri(String catUri);

}
