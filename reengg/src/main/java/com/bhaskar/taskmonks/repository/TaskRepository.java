package com.bhaskar.taskmonks.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhaskar.taskmonks.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

}
