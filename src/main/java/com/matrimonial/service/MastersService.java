package com.matrimonial.service;

import java.util.List;

import com.matrimonial.domain.CityDtl;
import com.matrimonial.domain.CommunityMasterDtl;
import com.matrimonial.domain.CountryDtl;
import com.matrimonial.domain.MotherTongueMasterDtl;
import com.matrimonial.domain.ReligionMasterDtl;
import com.matrimonial.domain.StateDtl;

public interface MastersService {

	public List<StateDtl> getStateList();
	
	public List<CityDtl> getCityList(Integer stateDtlsId);
	
	public List<ReligionMasterDtl> getReligionList();
	
	public List<MotherTongueMasterDtl> getMotherTongueDtlsList();
	
	public List<CountryDtl> getContryDtlsList();
	
	public List<CommunityMasterDtl> getCommunityDtlsList(Integer religionId);
}
