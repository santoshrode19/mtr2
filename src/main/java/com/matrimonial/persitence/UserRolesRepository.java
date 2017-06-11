package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matrimonial.domain.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, String> {

	public List<UserRoles> getUserRoles(String userid);

	public List<UserRoles> getUserByRole(String roleId);

	@Query("select ur from UserRoles ur where ur.user.email = ?1 and ur.id.roleId = ?2")
	public UserRoles isUserHasRoles(String email, String roleId);

}
