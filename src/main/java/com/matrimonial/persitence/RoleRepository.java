/**
 * 
 */
package com.matrimonial.persitence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimonial.domain.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, String> {

}
