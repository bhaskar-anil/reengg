package com.bhaskar.taskmonks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhaskar.taskmonks.domain.Admin;

public interface AdminUserRepository extends JpaRepository<Admin, Long>{

}
