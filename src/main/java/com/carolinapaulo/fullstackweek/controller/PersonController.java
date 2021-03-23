package com.carolinapaulo.fullstackweek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolinapaulo.fullstackweek.domain.Person;
import com.carolinapaulo.fullstackweek.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public List<Person> listAll(){
		return personRepository.findAll();
	
	}
	
	@GetMapping("/{PersonId}")
	public Person getPerson(@PathVariable Long PersonId) {
		return personRepository.findById(PersonId).orElse(null);
	}
	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		return personRepository.save(person);
		
	}
	
	@PutMapping
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person){
		
		return personRepository.findById(id).map(
				record -> {
					record.setCpf(person.getCpf());
					record.setAge(person.getAge());
					record.setBirthdayDate(person.getBirthdayDate());
					record.setEmail(person.getEmail());
					record.setName(person.getName());
					record.setTelefone(person.getTelefone());
					Person personUpdated = personRepository.save(record);
					return ResponseEntity.ok().body(personUpdated);
				}).orElse(ResponseEntity.notFound().build());
	}
}

