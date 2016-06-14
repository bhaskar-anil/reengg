package com.bhaskar.taskmonks.service;

import java.util.Collection;

import com.bhaskar.taskmonks.domain.Category;

public interface CategoryServiceInterface {
	
	public Category saveCategory(Category cat);
	
	public Boolean deleteCategory(Long catId);
	
	public Category editCategory(Category cat);
	
	public Category findCategory(Long catId);
	
	public Collection<Category> getAllCategories();
	
	public int countCategories();
	
	public Category findByCatUri(String catUri);

}
