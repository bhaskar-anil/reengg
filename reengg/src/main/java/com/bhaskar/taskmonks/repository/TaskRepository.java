package com.bhaskar.taskmonks.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bhaskar.taskmonks.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	public final static String TASK_BY_CAT_URI = "SELECT t FROM Task t "+
												 "WHERE t.category.catUri = :catUri";
	
	@Query(TASK_BY_CAT_URI)
	public Collection<Task> findAllTasksByCatUri(@Param("catUri") String catUri);
	
	public Task findTaskByTaskUri(String taskUri);

}
