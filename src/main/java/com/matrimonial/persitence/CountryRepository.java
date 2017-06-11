package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.CountryDtl;

public interface CountryRepository extends JpaRepository<CountryDtl, Integer> {

	@Query("From CountryDtl c where c.isActive='Y'")
	public List<CountryDtl> selectCountryDtlsList();
	
}
