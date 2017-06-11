package com.matrimonial.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="state_dtls")
public class StateDtl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
    private String name;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@JsonIgnore
	@OneToMany(mappedBy="stateDtl",fetch=FetchType.LAZY)
	private List<CityDtl> cityDtls;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<CityDtl> getCityDtls() {
		return cityDtls;
	}

	public void setCityDtls(List<CityDtl> cityDtls) {
		this.cityDtls = cityDtls;
	}
	
}
