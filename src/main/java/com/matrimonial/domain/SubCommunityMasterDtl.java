package com.matrimonial.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sub_community_master_dtls database table.
 * 
 */
@Entity
@Table(name="sub_community_master_dtls")
@NamedQuery(name="SubCommunityMasterDtl.findAll", query="SELECT s FROM SubCommunityMasterDtl s")
public class SubCommunityMasterDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="COMMUNITY_MASTER_DTLS_ID")
	private int communityMasterDtlsId;

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

	//bi-directional one-to-one association to CommunityMasterDtl
	@OneToOne
	@JoinColumn(name="ID")
	private CommunityMasterDtl communityMasterDtl;

	public SubCommunityMasterDtl() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommunityMasterDtlsId() {
		return this.communityMasterDtlsId;
	}

	public void setCommunityMasterDtlsId(int communityMasterDtlsId) {
		this.communityMasterDtlsId = communityMasterDtlsId;
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

	public CommunityMasterDtl getCommunityMasterDtl() {
		return this.communityMasterDtl;
	}

	public void setCommunityMasterDtl(CommunityMasterDtl communityMasterDtl) {
		this.communityMasterDtl = communityMasterDtl;
	}

}