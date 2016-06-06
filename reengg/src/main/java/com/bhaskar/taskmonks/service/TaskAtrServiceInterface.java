package com.bhaskar.taskmonks.service;

import java.util.Collection;

import com.bhaskar.taskmonks.domain.TaskAttribute;

public interface TaskAtrServiceInterface {
	
	public TaskAttribute saveTaskAtr(TaskAttribute taskAtr);
	
	public Boolean deleteTaskAtr(Long taskAtrId);
	
	public TaskAttribute editTaskAtr(TaskAttribute taskAtr);
	
	public TaskAttribute findTaskAtr(Long taskAtrId);
	
	public Collection<TaskAttribute> getAllTasksAtr(Long taskId);

}
