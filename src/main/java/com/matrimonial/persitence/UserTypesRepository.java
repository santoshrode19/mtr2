package com.matrimonial.persitence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimonial.domain.UserTypes;

@Repository
public interface UserTypesRepository extends JpaRepository<UserTypes, String> {

}
