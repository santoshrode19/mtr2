package com.matrimonial.persitence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matrimonial.domain.Users;

public interface UserDetailsRepository extends JpaRepository<Users, String> {

	@Query("SELECT u FROM Users u WHERE u.email = ?1 AND u.password = ?2")
	public Users loginValidation(String email, String password);

	@Query("SELECT u FROM Users u WHERE u.email = ?1")
	public Users findUserByEmailId(String email);

	@Query(value="select uuid()",nativeQuery=true)
	public String getuuid();
	
	/*
	 * @Query("SELECT u FROM Users u WHERE u.user_type =?1") public List<Users>
	 * findAllUsersWithUserType(String userType);
	 */

	@Query("SELECT u FROM Users u WHERE u.email =?1")
	public Users searchUser(String email);

	/*
	 * @Query("UPDATE Users u SET u.markForDelete = :Y WHERE u.username =?1")
	 * public boolean deletUser(String userName);
	 */

	/*
	 * @Query("SELECT u.user_type FROM Users u WHERE u.username =?1") public
	 * String getUserType(String userName);
	 */

	@Query("SELECT u FROM Users u WHERE u.user_type = 'MASSAGER'")
	public List<Users> getMassagerList();

}
