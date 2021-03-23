package com.carolinapaulo.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolinapaulo.fullstackweek.domain.PriorityGroups;

public interface PriorityGroupsRepository extends JpaRepository<PriorityGroups, Long> {

}
