package com.bhaskar.taskmonks.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.taskmonks.domain.AttributeValues;
import com.bhaskar.taskmonks.repository.AttributeValuesRepository;

@Service
@Transactional
public class AttributeValuesService implements AttributeValuesServiceInterface{
	
	@Autowired
	protected AttributeValuesRepository atrValuesRepository;

	@Override
	public AttributeValues saveAtrValue(AttributeValues atrValue) {
		// TODO Auto-generated method stub
		return atrValuesRepository.save(atrValue);
	}

	@Override
	public Boolean deleteAtrValue(Long atrValueId) {
		// TODO Auto-generated method stub
		AttributeValues temp = atrValuesRepository.findOne(atrValueId);
		if(temp!=null){
			atrValuesRepository.delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public AttributeValues editAtrValue(AttributeValues atrValue) {
		// TODO Auto-generated method stub
		return atrValuesRepository.save(atrValue);
	}

	@Override
	public AttributeValues findAtrValue(Long atrValueId) {
		// TODO Auto-generated method stub
		return atrValuesRepository.findOne(atrValueId);
	}

	@Override
	public Collection<AttributeValues> getAllAtrValues(Long atrId) {
		// TODO Auto-generated method stub
		return atrValuesRepository.getAllAtrValuesByAtrId(atrId);
	}

}
