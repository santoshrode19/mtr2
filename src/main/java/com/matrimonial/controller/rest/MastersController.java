package com.matrimonial.controller.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimonial.domain.CityDtl;
import com.matrimonial.domain.StateDtl;
import com.matrimonial.service.MastersService;

@RestController
public class MastersController {
	
	protected static final Logger LOGGER = Logger.getLogger(MastersController.class);


	@Autowired
	private MastersService mastersService;
	
	@RequestMapping(value="state")
	public List<StateDtl> getStateList(){
		return mastersService.getStateList();
	}
	
	@RequestMapping(value="city/{stateDtlsId}")
	public List<CityDtl> getCityList(@PathVariable("stateDtlsId") Integer stateDtlsId){
		LOGGER.debug(" ---> getCityList(stateDtlsId)" +stateDtlsId);
		List<CityDtl> cityList= mastersService.getCityList(stateDtlsId);
		LOGGER.debug(" <--- response " +cityList);
		return cityList;
		
	}
	
}
