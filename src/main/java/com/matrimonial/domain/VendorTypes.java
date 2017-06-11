package com.matrimonial.domain;
 



import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_TYPES database table.
 * 
 */
@Entity
@Table(name="vendor_types", schema="gdii")
public class VendorTypes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VENDOR_TYPE_ID")
	private String vendorTypeID;

	@Column(name="VENDOR_TYPE_NAME")
	private String vendorTypeName;

    public VendorTypes() {
    }

	public String getVendorTypeID() {
		return this.vendorTypeID;
	}

	public void setVendorTypeID(String vendorTypeID) {
		this.vendorTypeID = vendorTypeID;
	}

	public String getVendorTypeName() {
		return this.vendorTypeName;
	}

	public void setVendorTypeName(String vendorTypeName) {
		this.vendorTypeName = vendorTypeName;
	}

}