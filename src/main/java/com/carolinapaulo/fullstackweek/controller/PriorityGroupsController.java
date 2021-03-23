package com.carolinapaulo.fullstackweek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolinapaulo.fullstackweek.domain.PriorityGroups;
import com.carolinapaulo.fullstackweek.repository.PriorityGroupsRepository;

@RestController
@RequestMapping
public class PriorityGroupsController {

	@Autowired
	private PriorityGroupsRepository priorityGroupsRepository;
	
	@GetMapping
	public List<PriorityGroups> listAll(){
		return priorityGroupsRepository.findAll();
	
	}
	
	@PostMapping
	public PriorityGroups addPriorityGroup(@RequestBody PriorityGroups priorityGroups) {
		return priorityGroupsRepository.save(priorityGroups);
		
	}
	
	
	

}
