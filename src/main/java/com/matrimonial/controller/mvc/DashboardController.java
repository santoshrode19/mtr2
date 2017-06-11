package com.matrimonial.controller.mvc;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.matrimonial.constants.RolesEnum;
import com.matrimonial.service.DashBoardService;

@Controller
public class DashboardController {
	
	protected static final Logger LOGGER = Logger.getLogger(DashboardController.class);
	
	@Autowired
	private DashBoardService dashBoardService;
/*
	@Autowired
	private ConvertLambertToLatLong convertLambertToLatLong;*/
	
	@RequestMapping(method=RequestMethod.POST, value="/loadDashboard")
	public ModelAndView loadDashBoard(@RequestParam("pageName") String pageName, HttpServletRequest request) {
		System.out.println("loadDashBoard..........");
		String username = "";
		GrantedAuthority a = null;
		Collection<? extends  GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority grantedAuthority : authorities){
			System.out.println("loadDashBoard Role...... "+grantedAuthority.getAuthority());
			if(grantedAuthority.getAuthority().equals(RolesEnum.ROLE_GDII_USER.toString())){
				pageName="dashboard/gdiiDashboard"; break;
			}else if(grantedAuthority.getAuthority().equals(RolesEnum.ROLE_ORG_USER.toString())){
				pageName="dashboard/orgDashboard"; break;
			}else if(grantedAuthority.getAuthority().equals(RolesEnum.ROLE_CUSTOMER_USER.toString())){
				pageName="dashboard/customerDashboard"; break;
			}
		}
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails){
			username = ((UserDetails)principal).getUsername();
		}else{
			username = principal.toString();
		}
		LOGGER.debug("username forward to ~~~~~~~~~~~~~~~~~~"+username +" "+pageName);	
		ModelAndView dashboardModel = new ModelAndView();
		String mapURL = "";
		dashboardModel.addObject("mapURL",mapURL);
		dashboardModel.setViewName(pageName);
		LOGGER.debug("pageName~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+pageName);
		return dashboardModel;
	}
}
