package com.matrimonial.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matrimonial.domain.UserRoles;
import com.matrimonial.domain.Users;
import com.matrimonial.persitence.UserDetailsRepository;
import com.matrimonial.persitence.UserRolesRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	protected static final Logger LOGGER = Logger.getLogger(UserDetailsService.class);

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private UserRolesRepository userRolesRepository;

	public Users loginValidation(String username, String password) {
		Users userDetails = userDetailsRepository.loginValidation(username, password);
		return userDetails;
	}

	public UserDetailsRepository getUserDetailsRepository() {
		return userDetailsRepository;
	}

	public void setUserDetailsRepository(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	public void getUserDetails() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LOGGER.debug(" getUserDetails- " + userDetails.getPassword());
		LOGGER.debug(" getUserDetails- " + userDetails.getUsername());
		LOGGER.debug(" getUserDetails- " + userDetails.isEnabled());
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername ..... ");

		LOGGER.debug(" ==========================      Got user id: " + userId);
		Users userDetails = userDetailsRepository.findUserByEmailId(userId);

		LOGGER.debug(userDetails);

		if (userDetails == null) {
			LOGGER.error("User " + userId + " not found");
			throw new UsernameNotFoundException("User " + userId + " is not registered. Please contact support.");
		}

		System.out.println("User Exist : " + userDetails);

		return userDetails;
	}

	public List<Users> getAllUsers() {
		List<Users> users = userDetailsRepository.findAll();
		return users;

	}

	public Users findUser(String userName) {
		return userDetailsRepository.findOne(userName);
	}

	public List<UserRoles> getAllUsersWithRoles() {
		List<UserRoles> usersWithRoles = userRolesRepository.findAll();
		return usersWithRoles;

	}

}
