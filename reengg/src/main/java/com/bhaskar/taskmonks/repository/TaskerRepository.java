package com.bhaskar.taskmonks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhaskar.taskmonks.domain.Tasker;

public interface TaskerRepository extends JpaRepository<Tasker, Long>{

}
