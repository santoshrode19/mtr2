package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.CityDtl;

public interface CityRepository extends JpaRepository<CityDtl, Integer> {

	@Query("From CityDtl cd where cd.isActive='Y' and cd.stateDtl.id = ?1")
	public List<CityDtl> getCityList(Integer stateDtlsId);
}
