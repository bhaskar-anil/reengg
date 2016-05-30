package com.bhaskar.taskmonks.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bhaskar.taskmonks.domain.Category;

@Service
@Transactional
public class CategoryService implements CategoryServiceInterface{

	@Override
	public Category saveCategory(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCategory(Long catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category editCategory(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategory(Long catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
