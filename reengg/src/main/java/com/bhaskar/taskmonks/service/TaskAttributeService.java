package com.bhaskar.taskmonks.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.taskmonks.domain.TaskAttribute;
import com.bhaskar.taskmonks.repository.TaskAttributeRepository;

@Service
@Transactional
public class TaskAttributeService implements TaskAtrServiceInterface{

	@Autowired
	protected TaskAttributeRepository taskAtrRepository;
	
	@Override
	public TaskAttribute saveTaskAtr(TaskAttribute taskAtr) {
		// TODO Auto-generated method stub
		return taskAtrRepository.save(taskAtr);
	}

	@Override
	public Boolean deleteTaskAtr(Long taskAtrId) {
		// TODO Auto-generated method stub
		TaskAttribute temp = taskAtrRepository.findOne(taskAtrId);
		if(temp!=null){
			taskAtrRepository.delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public TaskAttribute editTaskAtr(TaskAttribute taskAtr) {
		// TODO Auto-generated method stub
		return taskAtrRepository.save(taskAtr);
	}

	@Override
	public TaskAttribute findTaskAtr(Long taskAtrId) {
		// TODO Auto-generated method stub
		return taskAtrRepository.findOne(taskAtrId);
	}

	@Override
	public Collection<TaskAttribute> getAllTasksAtr(Long taskId) {
		// TODO Auto-generated method stub
		Iterable<TaskAttribute> itr = taskAtrRepository.getAllTasksAtrByTaskId(taskId);
		return (Collection<TaskAttribute>) itr;
	}

}
