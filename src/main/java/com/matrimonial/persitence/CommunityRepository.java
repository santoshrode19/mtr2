package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.CommunityMasterDtl;

public interface CommunityRepository extends JpaRepository<CommunityMasterDtl, Integer> {

	@Query("From CommunityMasterDtl c where c.religionDtl.id=?1 and c.isActive='Y'")
	public List<CommunityMasterDtl> selectCommunityDtlsList(Integer id);

}
