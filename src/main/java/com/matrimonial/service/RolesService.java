package com.matrimonial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimonial.domain.Roles;
import com.matrimonial.persitence.RoleRepository;
 
@Service
public class RolesService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Roles> getRoles(){
		List<Roles> rolesList= roleRepository.findAll();
		return rolesList;		
	}
	
	 

}
