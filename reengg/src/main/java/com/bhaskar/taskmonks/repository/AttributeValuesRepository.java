package com.bhaskar.taskmonks.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bhaskar.taskmonks.domain.AttributeValues;;

public interface AttributeValuesRepository extends JpaRepository<AttributeValues, Long>{
	
	public final static String TASK_ATR_VALUES_BY_TASK_ATR_ID = 	"SELECT a FROM AttributeValues a "+
																	"WHERE a.taskAttribute.atrId = :atrid";
	
	@Query(TASK_ATR_VALUES_BY_TASK_ATR_ID)
	public Collection<AttributeValues> getAllAtrValuesByAtrId(@Param("atrid") Long atrid);

}
