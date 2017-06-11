package com.matrimonial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matrimonial.domain.CityDtl;
import com.matrimonial.domain.CommunityMasterDtl;
import com.matrimonial.domain.CountryDtl;
import com.matrimonial.domain.MotherTongueMasterDtl;
import com.matrimonial.domain.ReligionMasterDtl;
import com.matrimonial.domain.StateDtl;
import com.matrimonial.persitence.CityRepository;
import com.matrimonial.persitence.CommunityRepository;
import com.matrimonial.persitence.CountryRepository;
import com.matrimonial.persitence.MotherTongueRepository;
import com.matrimonial.persitence.ReligionRepository;
import com.matrimonial.persitence.StateRepository;
import com.matrimonial.service.MastersService;

@Service
public class MastersServiceImpl implements MastersService {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ReligionRepository religionRepository;

	@Autowired
	private MotherTongueRepository motherTongueRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CommunityRepository communityRepository;

	@Override
	@Transactional(readOnly = true)
	public List<StateDtl> getStateList() {
		return stateRepository.getStateList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CityDtl> getCityList(Integer stateDtlsId) {
		return cityRepository.getCityList(stateDtlsId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReligionMasterDtl> getReligionList() {
		return religionRepository.selectRelgionList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<MotherTongueMasterDtl> getMotherTongueDtlsList() {
		return motherTongueRepository.selectMotherTongueDtlsList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CountryDtl> getContryDtlsList() {
		return countryRepository.selectCountryDtlsList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommunityMasterDtl> getCommunityDtlsList(Integer religionId) {
		return communityRepository.selectCommunityDtlsList(religionId);
	}
}
