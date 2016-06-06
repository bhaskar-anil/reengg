package com.bhaskar.taskmonks.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bhaskar.taskmonks.domain.TaskAttribute;



public interface TaskAttributeRepository extends JpaRepository<TaskAttribute, Long>{
	
	public final static String TASK_ATRS_BY_TASK_ID = 	"SELECT t FROM TaskAttribute t "+
														"WHERE t.task.taskId = :taskid";
	
	@Query(TASK_ATRS_BY_TASK_ID)
	public Collection<TaskAttribute> getAllTasksAtrByTaskId(@Param("taskid") Long taskid);

}
