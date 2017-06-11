package com.matrimonial.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the city_dtls database table.
 * 
 */
@Entity
@Table(name="city_dtls")
@NamedQuery(name="CityDtl.findAll", query="SELECT c FROM CityDtl c")
public class CityDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	@Column(name="CREATED_BY")
	private String createdBy;

	@JsonIgnore
	@Column(name="CREATED_TS")
	private Timestamp createdTs;

	@JsonIgnore
	@Column(name="IS_ACTIVE")
	private String isActive;

	@JsonIgnore
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@JsonIgnore
	@Column(name="MODIFIED_TS")
	private Timestamp modifiedTs;

	private String name;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATE_DTLS_ID")
	private StateDtl stateDtl;

	public CityDtl() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTs() {
		return this.modifiedTs;
	}

	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StateDtl getStateDtl() {
		return this.stateDtl;
	}

	public void setStateDtl(StateDtl stateDtl) {
		this.stateDtl = stateDtl;
	}

}