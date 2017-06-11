package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.StateDtl;

public interface StateRepository extends JpaRepository<StateDtl, Integer> {

	@Query("From StateDtl sd where sd.isActive ='Y'")
	public List<StateDtl> getStateList();
	
}
