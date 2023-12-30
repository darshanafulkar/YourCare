package com.anudip.yourcare.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.yourcare.dto.QueryDto;
import com.anudip.yourcare.entity.Query;
import com.anudip.yourcare.repository.QueryRepository;
import com.anudip.yourcare.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService{

	@Autowired
	QueryRepository queryRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	//Method to add the new query into DB
	@Override
	public Query createQuery(Query query) {
		
		return queryRepository.save(query);
	}
	
	//Method to get/print all the query available
	@Override
	public List<QueryDto> getAllQuery() {
		
		List<Query> queres = queryRepository.findAll();
		
		return queres.stream().map(query -> modelMapper.map(query, QueryDto.class)).collect(Collectors.toList());
		
	}

	//Method to find the query by query id
	@Override
	public QueryDto getQueryById(int id) {
		Optional<Query> query = queryRepository.findById(id);
		
		if(query.isPresent())
		{
			QueryDto queryDto = modelMapper.map(query, QueryDto.class);
			return queryDto;
		}
		return null;
	}

	//Method to find the Query by name
	@Override
	public QueryDto getQueryByName(String name) {
		
		Query query = queryRepository.findByFname(name);
		
		QueryDto queryDto = modelMapper.map(query, QueryDto.class);
		return queryDto;
	}

	@Override
	public Query updateQueryByName(Query query) {
		
		Query existingQuery = queryRepository.findByFname(query.getFname());
		
		if(existingQuery == null)
		{
			return null;
		}
	
		existingQuery.setLname(query.getLname());
		existingQuery.setEmail(query.getEmail());
		existingQuery.setPhoneno(query.getPhoneno());
		existingQuery.setSpeciality(query.getSpeciality());
		existingQuery.setMessage(query.getMessage());
		
		return queryRepository.save(existingQuery);
	}

	@Override
	public String deleteQueryByName(String name) {
		
		Query checkquery = queryRepository.findByFname(name);
		
		if(checkquery == null)
		{
			return null;
		}
		
		queryRepository.deleteById(checkquery.getId());
		return "Data deleted successfully";
	}

}
