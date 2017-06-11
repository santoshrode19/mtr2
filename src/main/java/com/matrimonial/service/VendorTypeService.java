package com.matrimonial.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimonial.domain.VendorTypes;
import com.matrimonial.persitence.VendorTypesRepository;;

@Service
public class VendorTypeService {
	protected static final Logger LOGGER = Logger.getLogger(VendorTypeService.class);
	
	@Autowired
	private VendorTypesRepository vendorTypesRepository;
	
	public List<VendorTypes> getAllVendorTypes(){
		
		 List<VendorTypes> vendorTypesList=vendorTypesRepository.findAll();
		 LOGGER.debug("Successfully getting all vendor types   :");
		 
		return vendorTypesList;
		
	}

}
