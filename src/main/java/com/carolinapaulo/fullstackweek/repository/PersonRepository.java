package com.carolinapaulo.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolinapaulo.fullstackweek.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
