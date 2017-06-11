package com.matrimonial.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the community_master_dtls database table.
 * 
 */
@Entity
@Table(name="community_master_dtls")
@NamedQuery(name="CommunityMasterDtl.findAll", query="SELECT c FROM CommunityMasterDtl c")
public class CommunityMasterDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_TS")
	private Timestamp createdTs;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_TS")
	private Timestamp modifiedTs;

	private String name;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RELIGION_MASTER_DTLS_ID")
	private ReligionMasterDtl religionDtl;

	@OneToOne(mappedBy="communityMasterDtl")
	private SubCommunityMasterDtl subCommunityMasterDtl;

	public CommunityMasterDtl() {
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

	public SubCommunityMasterDtl getSubCommunityMasterDtl() {
		return this.subCommunityMasterDtl;
	}

	public void setSubCommunityMasterDtl(SubCommunityMasterDtl subCommunityMasterDtl) {
		this.subCommunityMasterDtl = subCommunityMasterDtl;
	}

	public ReligionMasterDtl getReligionDtl() {
		return religionDtl;
	}

	public void setReligionDtl(ReligionMasterDtl religionDtl) {
		this.religionDtl = religionDtl;
	}
}