package com.bhaskar.taskmonks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhaskar.taskmonks.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
