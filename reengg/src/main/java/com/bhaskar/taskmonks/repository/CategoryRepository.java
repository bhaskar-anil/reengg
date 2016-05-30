package com.bhaskar.taskmonks.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhaskar.taskmonks.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
