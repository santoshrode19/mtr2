package com.matrimonial.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users", schema = "matrimonial_db")
public class Users implements UserDetails {

	protected static final Logger LOGGER = Logger.getLogger(Users.class);
	private static final long serialVersionUID = 299817514520320650L;

	@Id
	@Column(name = "USER_ID")
	private String userId;

	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "MARKED_FOR_DELETE")
	private String markForDelete;

	@Column(name = "IS_ACCOUNT_LOCKED")
	private String isAccountLocked;
	/*
	 * @Column(name="FAILED_LOGIN_ATTEMPTS") private int failedLoginAttempts;
	 */

	@Column(name = "USER_TYPE")
	private String user_type;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "ADHAR_NUMBER")
	private String adharNumber;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "IFSC")
	private String ifscCode;

	@Column(name = "QUALIFICATION")
	private String qualification;

	@Column(name = "LOCAL_ADDRESS")
	private String localAddress;

	@Column(name = "PERMANENT_ADDRESS")
	private String permanentAddress;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "DOCUMENTS")
	private byte[] documents;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@Column(name = "FILE_NAME")
	private String fileName;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "RELIGION_MASTER_DTLS_ID")
	private ReligionMasterDtl religionDtl;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "CUNTRY_DTLS_ID")
	private CountryDtl countryDtl;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "SUB_COMMUNITY_MASTER_DTLS_ID")
	private SubCommunityMasterDtl subCommunityDtl;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "CITY_DTLS_ID")
	private CityDtl cityDtl;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "MOTHER_TONGUE_MASTER_DTLS_ID")
	private MotherTongueMasterDtl motherTongueDtl;
	
	@Column(name="IS_PROFILE_DTLS_ADDED")
	private String isProfileDtls_Added;
	
	@Column(name="PROFILE_FOR")
	private String profileFor;

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public byte[] getDocuments() {
		return documents;
	}

	public void setDocuments(byte[] documents) {
		this.documents = documents;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLES", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
	private Set<Roles> roles;

	public Users() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getMarkForDelete() {
		return markForDelete;
	}

	public void setMarkForDelete(String markForDelete) {
		this.markForDelete = markForDelete;
	}

	public String getIsAccountLocked() {
		return isAccountLocked;
	}

	public void setIsAccountLocked(String isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();

		for (Roles role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleId()));
		}

		return grantedAuthorities;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ReligionMasterDtl getReligionDtl() {
		return religionDtl;
	}

	public void setReligionDtl(ReligionMasterDtl religionDtl) {
		this.religionDtl = religionDtl;
	}

	public CountryDtl getCountryDtl() {
		return countryDtl;
	}

	public void setCountryDtl(CountryDtl countryDtl) {
		this.countryDtl = countryDtl;
	}

	public SubCommunityMasterDtl getSubCommunityDtl() {
		return subCommunityDtl;
	}

	public void setSubCommunityDtl(SubCommunityMasterDtl subCommunityDtl) {
		this.subCommunityDtl = subCommunityDtl;
	}

	public CityDtl getCityDtl() {
		return cityDtl;
	}

	public void setCityDtl(CityDtl cityDtl) {
		this.cityDtl = cityDtl;
	}

	public MotherTongueMasterDtl getMotherTongueDtl() {
		return motherTongueDtl;
	}

	public void setMotherTongueDtl(MotherTongueMasterDtl motherTongueDtl) {
		this.motherTongueDtl = motherTongueDtl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsProfileDtls_Added() {
		return isProfileDtls_Added;
	}

	public void setIsProfileDtls_Added(String isProfileDtls_Added) {
		this.isProfileDtls_Added = isProfileDtls_Added;
	}

	public String getProfileFor() {
		return profileFor;
	}

	public void setProfileFor(String profileFor) {
		this.profileFor = profileFor;
	}
	
	
}
