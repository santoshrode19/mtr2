package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimonial.domain.StateDtl;
import com.matrimonial.domain.VendorTypes;

@Repository
public interface VendorTypesRepository extends JpaRepository<VendorTypes, String>{

}
