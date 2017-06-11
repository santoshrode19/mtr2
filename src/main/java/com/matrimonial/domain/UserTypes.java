package com.matrimonial.domain;
 



import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the USER_TYPES database table.
 * 
 */
@Entity
@Table(name = "user_types", schema="gdii")
public class UserTypes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_TYPE")
	private String userType;

	@Column(name="USER_TYPE_DESC")
	private String userTypeDesc;

    public UserTypes() {
    }

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTypeDesc() {
		return this.userTypeDesc;
	}

	public void setUserTypeDesc(String userTypeDesc) {
		this.userTypeDesc = userTypeDesc;
	}

}