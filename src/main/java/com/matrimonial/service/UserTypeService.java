package com.matrimonial.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimonial.domain.UserTypes;
import com.matrimonial.persitence.UserTypesRepository;



@Service
public class UserTypeService {
	protected static final Logger LOGGER = Logger.getLogger(UserTypeService.class);
	
	@Autowired
	private UserTypesRepository userTypesRepository;
	
	public List<UserTypes> getAllUserTypes(){
		
		 List<UserTypes> userTypesLst=userTypesRepository.findAll();
		 LOGGER.debug("Successfully getting all users types   :");
		 
		return userTypesLst;
		
	}

}
