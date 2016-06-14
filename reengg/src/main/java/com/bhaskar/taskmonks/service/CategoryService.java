package com.bhaskar.taskmonks.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.taskmonks.domain.Category;
import com.bhaskar.taskmonks.repository.CategoryRepository;


@Service
@Transactional
public class CategoryService implements CategoryServiceInterface{
	
	@Autowired
	protected CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(Category cat) {
		
		String catUri = cat.getCatName().replaceAll("[,|*|;|'|#]+","")
										.trim().replaceAll(" +", " ")
										.replace(' ', '-');		
		if (catUri.length() > 50) {
			catUri = catUri.substring(0, 49);
		}
		cat.setCatUri(catUri);
		return categoryRepository.save(cat);
	}

	@Override
	public Boolean deleteCategory(Long catId) {
		Category temp = categoryRepository.findOne(catId);
		if(temp!=null){
			categoryRepository.delete(temp);
			 return true;
		}
		return false;
	}

	@Override
	public Category editCategory(Category cat) {
		return categoryRepository.save(cat);
	}

	@Override
	public Category findCategory(Long catId) {
		return categoryRepository.findOne(catId);
	}

	@Override
	public Collection<Category> getAllCategories() {
		Iterable<Category> itr = categoryRepository.findAll();
		return (Collection<Category>)itr;
	}
	
	/*Some service methods for dashboard*/
	@Override
	public int countCategories(){
		return categoryRepository.findAll().size();
	}
	
}
