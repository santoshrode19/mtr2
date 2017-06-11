package com.matrimonial.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matrimonial.domain.UserRoles;
import com.matrimonial.domain.Users;
import com.matrimonial.persitence.UserDetailsRepository;
import com.matrimonial.persitence.UserRolesRepository;

@Service
public class ManageUserService {

	protected static final Logger LOGGER = Logger.getLogger(ManageUserService.class);

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Transactional
	public boolean createUser(Users users, List<UserRoles> userRolesList) {

		try {
			userDetailsRepository.save(users);
			userRolesRepository.save(userRolesList);
			// userModulesRepository.save(userModulesList);
			// queueAccessRepository.save(userQueueList);
			return true;
		} catch (Exception e) {
			LOGGER.debug(e);
			return false;
		}
	}

	// search method
	public Users searchUser(String userId) {
		Users users = userDetailsRepository.searchUser(userId);
		LOGGER.debug("Successfully getting data from jpa   :");
		return users;
	}

	/* Display Name as First Name and Last Name */
	public String getDisplayName(String userId) {
		Users users = userDetailsRepository.searchUser(userId);
		LOGGER.debug("Successfully getting data from jpa   :");
		return users.getFirstName() + " " + users.getLastName();
	}

	public List<UserRoles> getUserRoles(String userId) {
		List<UserRoles> UserRolesList = userRolesRepository.getUserRoles(userId);
		return UserRolesList;
	}

	public List<UserRoles> getUserByRole(String roleId) {
		List<UserRoles> UserRolesList = userRolesRepository.getUserByRole(roleId);
		return UserRolesList;
	}

	@Transactional
	public boolean updateUser(Users users) {
		LOGGER.debug("Start update user   :");
		try {
			userDetailsRepository.save(users);
			LOGGER.debug("Successfully updated user    :");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateUser(Users users, List<UserRoles> userRoleList) {
		LOGGER.debug("Start update user   :");
		try {
			userDetailsRepository.save(users);
			updateUserRoles(userRoleList);
			LOGGER.debug("Successfully updated user    :");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Modifying
	@Transactional
	public boolean updateUserRoles(List<UserRoles> userRolesList) {
		LOGGER.debug("Start update roles   :");
		try {
			userRolesRepository.save(userRolesList);
			LOGGER.debug("Successfully updated roles     :");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteUserRoles(List<UserRoles> roles) {
		LOGGER.debug("Start delete roles   :");
		try {
			userRolesRepository.delete(roles);
			LOGGER.debug("Successfully delete roles     :");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public void saveUser(Users user) {
		userDetailsRepository.save(user);
	}
	
	public String getUUID(){
		return userDetailsRepository.getuuid();
	}

}
