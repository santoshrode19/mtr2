package com.matrimonial.controller.mvc;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.matrimonial.constants.ApplicationConstant;
import com.matrimonial.domain.Users;
import com.matrimonial.service.MastersService;
import com.matrimonial.service.UserDetailsService;

@Controller
public class LoginController {

	protected static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private MastersService mastersService;
	
	/*
	 * @Autowired private HttpServletRequest request;
	 */

	@Value("${max.failed.login.attempts}")
	private String maxFailedLoginAttempts;

	@RequestMapping({ "/","/index","/home"})
	public ModelAndView homePage() {
		LOGGER.debug("User Logging");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping({ "/login" })
	public ModelAndView loginPage() {
		LOGGER.debug("User Logging");
		ModelAndView model = new ModelAndView();
		//set state list
		/*model.addObject("stateList", mastersService.getStateList());
		//set religion list
		model.addObject("religionList",mastersService.getReligionList());
		//set mother tongue list
		model.addObject("mothertongueList", mastersService.getMotherTongueDtlsList());
		//set country list (living in)
		model.addObject("countryList", mastersService.getContryDtlsList());
		//model.setViewName("signup_step1");
*/		model.setViewName("login");
		return model;
	}

	@RequestMapping({ "/signup"})
	public ModelAndView signupPage() {
		LOGGER.debug("User Logging");
		ModelAndView model = new ModelAndView();
		//set state list
		model.addObject("stateList", mastersService.getStateList());
		//set religion list
		model.addObject("religionList",mastersService.getReligionList());
		//set mother tongue list
		model.addObject("mothertongueList", mastersService.getMotherTongueDtlsList());
		//set country list (living in)
		model.addObject("countryList", mastersService.getContryDtlsList());
		//model.setViewName("signup_step1");
		model.setViewName("signup_step1");
		return model;
	}
	
	

	
	@RequestMapping({ "/loginerror" })
	public ModelAndView loginErrorPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "Invalid UserName / Password. Account will be locked after " + maxFailedLoginAttempts + " attempts. ");
		model.setViewName("login");
		return model;
	}

	@RequestMapping("/profile")
	public ModelAndView profile() {
		ModelAndView profile = new ModelAndView();
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		Users userDetails = (Users) userDetailsService.loadUserByUsername(username);
		if(userDetails.getIsProfileDtls_Added().equals(ApplicationConstant.STATUS_NO)){
			profile.setViewName("signup_step2");
		}
		else{
			profile.setViewName("profile");
		}
		return profile;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView profile = new ModelAndView();
		profile.setViewName("about");
		return profile;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView profile = new ModelAndView();
		profile.setViewName("contact");
		return profile;
	}
	
	@RequestMapping("/view-profile")
	public ModelAndView viewProfile() {
		ModelAndView profile = new ModelAndView();
		profile.setViewName("view_profile");
		return profile;
	}
	
	@RequestMapping("/pagenotfound")
	public ModelAndView pageNotFound() {
		ModelAndView profile = new ModelAndView();
		profile.setViewName("404");
		return profile;
	}
	
	
	@RequestMapping("/navigate")
	public ModelAndView navigate(@RequestParam("pageName") String pageName) {
		ModelAndView navigate = new ModelAndView();
		navigate.setViewName(pageName);
		return navigate;
	}

	@RequestMapping({ "/accessDenied" })
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "Authorization Failed. Please contact system admin.");
		model.setViewName("login");
		return model;
	}

	@RequestMapping({ "/accountDelete" })
	public ModelAndView accountDelete() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "User is marked inactive. Please contact support.");
		model.setViewName("login");
		return model;
	}

	@RequestMapping({ "/accountLocked" })
	public ModelAndView accountLocked() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "Account is locked. Please contact system admin.");
		model.setViewName("login");
		return model;
	}

	@RequestMapping({ "/accountExpired" })
	public ModelAndView accountExpired() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "Account is Expired. Please contact system admin.");
		model.setViewName("login");
		return model;
	}

	/*
	 * @RequestMapping("/logout") public ModelAndView logoutPage() {
	 * ModelAndView model = new ModelAndView(); model.setViewName("login");
	 * return model; }
	 */
	@RequestMapping("/logout")
	public ModelAndView logoutPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			LOGGER.debug("LoginController . Username from if HomeController: " + username);
		} else {
			username = principal.toString();
			LOGGER.debug("LoginController . Username from else HomeController: " + username);
		}
		// loginHistoryService.insertUserLogin(username, "OUT", userIPAddress);
		return model;
	}

	@RequestMapping("/app")
	public ModelAndView homePage(Locale locale, HttpServletRequest httpServletRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("homePage .. ----");
		ModelAndView model = new ModelAndView();
		String username = "";
		String userFullName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		Users userDetails = (Users) userDetailsService.loadUserByUsername(username);
		userFullName = userDetails.getFirstName() + " " + userDetails.getLastName();
		model.addObject("userFullName", userFullName);
		model.setViewName("default");
		model.addObject("user_language", locale.getLanguage());
		model.addObject("user_country", locale.getCountry());
		LOGGER.debug("user_language  : " + locale.getLanguage());
		LOGGER.debug("user_country  : " + locale.getCountry());
		return model;

	}
}