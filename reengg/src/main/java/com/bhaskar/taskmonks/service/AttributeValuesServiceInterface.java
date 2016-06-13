package com.bhaskar.taskmonks.service;

import java.util.Collection;

import com.bhaskar.taskmonks.domain.AttributeValues;

public interface AttributeValuesServiceInterface {
	
	public AttributeValues saveAtrValue(AttributeValues atrValue);
	
	public Boolean deleteAtrValue(Long atrValueId);
	
	public AttributeValues editAtrValue(AttributeValues atrValue);
	
	public AttributeValues findAtrValue(Long atrValueId);
	
	public Collection<AttributeValues> getAllAtrValues(Long atrId);

}
