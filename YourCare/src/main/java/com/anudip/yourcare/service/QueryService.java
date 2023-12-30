package com.anudip.yourcare.service;

import java.util.List;

import com.anudip.yourcare.dto.QueryDto;
import com.anudip.yourcare.entity.Query;


public interface QueryService {

	//Method for creating the Query
		public Query createQuery(Query query);
		
		//Methods for getting Query
		public List<QueryDto> getAllQuery();
		
		public QueryDto getQueryById(int id);
		
		public QueryDto getQueryByName(String name);
		
		//Method for Updating Query
		public Query updateQueryByName(Query query);
		
		
		//Method for Deleting the Query
		public String deleteQueryByName(String name);
		
		
}
