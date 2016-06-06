package com.bhaskar.taskmonks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhaskar.taskmonks.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
