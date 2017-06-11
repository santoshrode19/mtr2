package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.ReligionMasterDtl;

public interface ReligionRepository extends JpaRepository<ReligionMasterDtl, Integer> {

	@Query("From ReligionMasterDtl r where r.isActive='Y'")
	public List<ReligionMasterDtl> selectRelgionList();
}
