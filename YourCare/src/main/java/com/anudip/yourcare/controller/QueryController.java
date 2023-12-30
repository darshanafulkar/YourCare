package com.anudip.yourcare.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.yourcare.dto.QueryDto;
import com.anudip.yourcare.entity.Query;
import com.anudip.yourcare.service.impl.QueryServiceImpl;

@RestController
public class QueryController {

	@Autowired
	QueryServiceImpl queryServiceImpl;
	
	//This will get the request for creating a new query
	@PostMapping("/query/create")
	public Query addQuery(@RequestBody Query query)
	{
		return queryServiceImpl.createQuery(query);
	}
	
	//This will get the request to print all the available query
	@GetMapping("/query/allQuery")
	public List<QueryDto> findAllQuery(@RequestBody QueryDto query)
	{
		return queryServiceImpl.getAllQuery();
	}

	//This will get the request to print the query by id
	@GetMapping("/query/byId/{id}")
	public QueryDto findQueryById(@PathVariable int id)
	{
		return queryServiceImpl.getQueryById(id);
	}
	
	//This will get the request to print the query by name
	@GetMapping("/query/byName/{name}")
	public QueryDto findQueryByName(@PathVariable String name)
	{
		return queryServiceImpl.getQueryByName(name);
	}
	
	//This will get the request to update the query into database according to name 
	@PutMapping("/query/update")
	public Query updateQueryByname(@RequestBody Query query)
	{
		return queryServiceImpl.updateQueryByName(query);	
	}
	
	//This will get the request to delete the existing Doctor record in DB
	@DeleteMapping("/query/delete/{name}")
	public String deleteQueryByName(@PathVariable String name)
	{
		String msg = queryServiceImpl.deleteQueryByName(name);
		
		return msg;
	}
}
