package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.MotherTongueMasterDtl;

public interface MotherTongueRepository extends JpaRepository<MotherTongueMasterDtl, Integer>{

	@Query("From MotherTongueMasterDtl mt where mt.isActive='Y'")
	public List<MotherTongueMasterDtl> selectMotherTongueDtlsList();
}
