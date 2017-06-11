package com.matrimonial.controller.mvc;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matrimonial.constants.ApplicationConstant;
import com.matrimonial.domain.CountryDtl;
import com.matrimonial.domain.MotherTongueMasterDtl;
import com.matrimonial.domain.ReligionMasterDtl;
import com.matrimonial.domain.Roles;
import com.matrimonial.domain.UserRolePK;
import com.matrimonial.domain.UserRoles;
import com.matrimonial.domain.UserTypes;
import com.matrimonial.domain.Users;
import com.matrimonial.domain.VendorTypes;
import com.matrimonial.persitence.UserRolesRepository;
import com.matrimonial.service.ManageUserService;
import com.matrimonial.service.RolesService;
import com.matrimonial.service.UserDetailsService;
import com.matrimonial.service.UserTypeService;
import com.matrimonial.service.VendorTypeService;
import com.matrimonial.utils.DateUtility;
import com.matrimonial.utils.EncryptDecryptData;

@Controller
public class UsersController {
	protected static final Logger LOGGER = Logger.getLogger(UsersController.class);

	@Autowired
	private RolesService rolesService;

	@Autowired
	private UserTypeService userTypeService;

	@Autowired
	private VendorTypeService vendorTypeService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private ManageUserService manageUserService;

	@Autowired
	private DateUtility dateUtility;

	// Load create Manager Users Page
	@RequestMapping(method = RequestMethod.POST, value = "/loadCreateUser")
	public ModelAndView loadCreateUsers(@RequestParam("pageName") String pageName) {

		ModelAndView mav = new ModelAndView();
		List<Roles> rolesList = rolesService.getRoles();
		Collections.sort(rolesList, new Comparator<Roles>() {
			@Override
			public int compare(final Roles object1, final Roles object2) {
				return object1.getRoleName().compareTo(object2.getRoleName());
			}
		});

		List<UserTypes> userTypesList = userTypeService.getAllUserTypes();
		List<Users> usersList = userDetailsService.getAllUsers();
		List<VendorTypes> vendorTypesList = vendorTypeService.getAllVendorTypes();

		LOGGER.debug("Inside create Users  ");

		mav.addObject("rolesList", rolesList);
		mav.addObject("userTypesList", userTypesList);
		mav.addObject("usersList", usersList);

		mav.addObject("vendorTypesList", vendorTypesList);

		mav.setViewName(pageName);

		return mav;
	}

	// Load edit Manager Users Page
	@RequestMapping(method = RequestMethod.POST, value = "/loadEditUser")
	public ModelAndView loadEditUsers(@RequestParam("pageName") String pageName) {

		ModelAndView mav = new ModelAndView();
		List<Users> usersList = userDetailsService.getAllUsers();
		Collections.sort(usersList, new Comparator<Users>() {
			@Override
			public int compare(final Users object1, final Users object2) {
				return object1.getFirstName().compareTo(object2.getFirstName());
			}
		});
		LOGGER.debug("Inside edit Users  ");
		mav.addObject("usersList", usersList);
		mav.setViewName(pageName);
		return mav;
	}

	// method for search user
	@RequestMapping(method = RequestMethod.POST, value = "/searchUser")
	public ModelAndView searchUser(HttpServletRequest request) throws ParseException {

		ModelAndView mav = new ModelAndView();
		LOGGER.debug("Inside search user method   :");
		String userId = request.getParameter("users");

		LOGGER.debug("user id is     :" + userId);
		Users users = manageUserService.searchUser(userId);

		// List<Users>usersList = userDetailsService.getAllUsers();
		List<Roles> rolesList = rolesService.getRoles();
		Collections.sort(rolesList, new Comparator<Roles>() {
			@Override
			public int compare(final Roles object1, final Roles object2) {
				return object1.getRoleName().compareTo(object2.getRoleName());
			}
		});
		List<UserTypes> userTypesList = userTypeService.getAllUserTypes();
		List<UserRoles> userRolesList = manageUserService.getUserRoles(userId);

		mav.addObject("isMassager", "false");
		List<VendorTypes> vendorTypesList = vendorTypeService.getAllVendorTypes();
		Iterator<UserRoles> it = userRolesList.iterator();
		while (it.hasNext()) {
			UserRoles userRoles = it.next();
			System.out.println("user Id :" + userRoles.getId().getUserId() + " " + userRoles.getId().getRoleId());
			// LOGGER.debug("user roles :"+userRoles.getId().getRoleId());
			if (userRoles.getId().getRoleId().equals(ApplicationConstant.ROLE_MASSAGER)) {
				mav.addObject("isMassager", ApplicationConstant.ROLE_MASSAGER);
				break;
			}

		}

		mav.setViewName("userSearchResult");
		mav.addObject("users", users);
		// mav.addObject("usersList", usersList);
		mav.addObject("rolesList", rolesList);
		mav.addObject("userTypesList", userTypesList);
		mav.addObject("userRolesList", userRolesList);
		mav.addObject("vendorTypesList", vendorTypesList);
		LOGGER.debug("users id  " + users.getUsername());
		LOGGER.debug("Successfully return to view page   :");

		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/createUser")
	public String createUser(HttpServletRequest request,Model model,final RedirectAttributes redirectAttributes) {
		System.out.println("---------------------" + request);
		try {
			LOGGER.debug("Inside create manager user method");

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String profileFor=request.getParameter("profile_for");
			String gender=request.getParameter("gender");
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
		    String dob=request.getParameter("dob");
		    String religion=request.getParameter("religion");
			String motherTongue=request.getParameter("mother_tongue");
			String country=request.getParameter("country");
			
			String userId = manageUserService.getUUID();
			//set user type
			String userType = ApplicationConstant.USER;
			//encode password
			String enPwd = EncryptDecryptData.encryptPassword(password);

			Users users = null;

			if (manageUserService.searchUser(email) != null) {
				return "User already exist";
			} else {
				users = new Users();
				users.setUserId(userId);
				users.setFirstName(firstName);
				users.setLastName(lastName);
				users.setEmail(email);
				// users.setMarkForDelete("N");
				users.setPassword(enPwd);
				users.setUser_type(userType);
				users.setGender(gender);
    			//	users.setPhoneNumber(phoneNum);
				// users.setIsAccountLocked("N");
				// users.setFailedLoginAttempts(0);

				List<UserRoles> userRolesList = new ArrayList<UserRoles>();
				UserRoles userRoles1 = new UserRoles();
				UserRolePK pk1 = new UserRolePK();
				pk1.setUserId(userId);
				pk1.setRoleId(ApplicationConstant.ROLE_APPLICATION_USER);
				userRoles1.setId(pk1);
				userRolesList.add(userRoles1);
				
				// set religion
				ReligionMasterDtl religionDtl=new ReligionMasterDtl();
				religionDtl.setId(Integer.parseInt(religion));
				users.setReligionDtl(religionDtl);
				
				//set mothertongue dtls
				MotherTongueMasterDtl motherTongueDtl=new MotherTongueMasterDtl();
				motherTongueDtl.setId(Integer.parseInt(motherTongue));
				users.setMotherTongueDtl(motherTongueDtl);
				
				//set country
				CountryDtl countryDtl=new CountryDtl();
				countryDtl.setId(Integer.parseInt(country));
				users.setCountryDtl(countryDtl);
				
				//set dob
				users.setDateOfBirth(dateUtility.stringToDate(dob));
				
				//set profile for
				users.setProfileFor(profileFor);
				
				// set profile details added to N
				users.setIsProfileDtls_Added(ApplicationConstant.STATUS_NO);

				boolean serviceResponse = manageUserService.createUser(users, userRolesList);

				if (serviceResponse) {
					redirectAttributes.addFlashAttribute("message", "Thanks for Registering.Please login to continue");
					return "redirect:login";
				} else {
					return ApplicationConstant.ERROR_RESPONSE;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception at here " + e.getMessage());
			e.printStackTrace();
			return "Exception while create user.";
		}
	}

	@RequestMapping(value = "/downloadUserDocuments", method = RequestMethod.GET)
	public void downloadUserDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {

			String userId = request.getParameter("userId");

			Users user = manageUserService.searchUser(userId);

			/*
			 * FileOutputStream outputStream = new
			 * FileOutputStream(getFileName(userId));
			 * outputStream.write(user.getDocuments()); outputStream.close();
			 */
			InputStream inputStream = new ByteArrayInputStream(user.getDocuments());
			response.setContentType("application/excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + user.getFileName());
			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();
			inputStream.close();
			inputStream = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method for update users
	@RequestMapping(method = RequestMethod.POST, value = "/updateUser")
	public String updateUser(MultipartHttpServletRequest request) throws Exception {

		LOGGER.debug("Inside update user method");
		String userId = request.getParameter("userId");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userType = request.getParameter("userType");
		String phoneNum = request.getParameter("phoneNum");
		String status = request.getParameter("status");
		String isAccountLocked = request.getParameter("accountLock");
		String[] selectedUserRoles = request.getParameterValues("userRole");
		List<String> selecteduserRolesList = Arrays.asList(selectedUserRoles);
		List<String> existingUserRolesList = new ArrayList<>();

		List<UserRoles> userRolesToBeAdd = new ArrayList<UserRoles>();
		List<UserRoles> userRolesToBeRemoved = new ArrayList<UserRoles>();

		List<UserRoles> roles = manageUserService.getUserRoles(userId);

		for (UserRoles userRoles : roles) {
			existingUserRolesList.add(userRoles.getId().getRoleId());// Accumulate
																		// all
																		// roles
		}
		// select user_role to be delete
		for (UserRoles userRoles : roles) {
			if (!selecteduserRolesList.contains(userRoles.getId().getRoleId())) {
				if (!userRoles.getId().getRoleId().equals(ApplicationConstant.ROLE_APPLICATION_USER)) {
					userRolesToBeRemoved.add(userRoles);
				}
			}
		}

		// select user_role to be Add
		for (String userRolesFromUI : selecteduserRolesList) {
			if (!existingUserRolesList.contains(userRolesFromUI)) {
				UserRoles newUserRoles = new UserRoles();
				UserRolePK pk1 = new UserRolePK();
				pk1.setUserId(userId);
				pk1.setRoleId(userRolesFromUI);
				;
				newUserRoles.setId(pk1);
				userRolesToBeAdd.add(newUserRoles);
			}
		}

		// Deleting user roles
		if (userRolesToBeRemoved.size() > 0) {
			manageUserService.deleteUserRoles(userRolesToBeRemoved);
		}

		Users users = manageUserService.searchUser(userId);

		users.setUserId(userId);
		users.setFirstName(firstName);
		users.setMiddleName(middleName);
		users.setLastName(lastName);
		users.setEmail(email);

		users.setMarkForDelete(status);
		users.setUser_type(userType);
		users.setPhoneNumber(phoneNum);
		users.setIsAccountLocked(isAccountLocked);
		// if (isAccountLocked.equalsIgnoreCase("N"))
		// users.setFailedLoginAttempts(0);

		LOGGER.debug("status is" + status);

		UserRoles countRoles = userRolesRepository.isUserHasRoles(users.getUsername(),
				ApplicationConstant.ROLE_MASSAGER);

		if (countRoles != null) {
			users.setAdharNumber(request.getParameter("adharNumber"));
			users.setBankName(request.getParameter("bankName"));
			users.setAccountNumber(request.getParameter("accountNumber"));
			users.setIfscCode(request.getParameter("ifscCode"));
			users.setQualification(request.getParameter("qualification"));
			users.setLocalAddress(request.getParameter("localAddress"));
			users.setPermanentAddress(request.getParameter("permanentAddress"));
		}

		users.setGender(request.getParameter("gender"));
		String dob = request.getParameter("dob");
		users.setDateOfBirth(dateUtility.getDate_ddMMMyyyy(dob));

		MultipartFile file = null;
		// InputStream inputStream = null;
		file = request.getFile("uploadFile");
		if (file != null) {
			try (InputStream inputStream = new BufferedInputStream(file.getInputStream())) {

				String fileName = file.getOriginalFilename();
				System.out.println("fileName " + fileName);
				byte[] fileBytes = new byte[(int) inputStream.available()];
				inputStream.read(fileBytes);
				users.setDocuments(fileBytes); // request.getParameter("documents")
				users.setFileName(fileName);
			} finally {
			}
		}

		boolean updateUser = manageUserService.updateUser(users, userRolesToBeAdd);

		if (updateUser) {
			return ApplicationConstant.SUCCESS_RESPONSE;
		} else {
			return ApplicationConstant.ERROR_RESPONSE;
		}
	}

	/*
	 * @RequestMapping(method=RequestMethod.POST, value="/createMassager")
	 * public @ResponseBody String createUser(HttpServletRequest request) throws
	 * Exception {
	 * 
	 * boolean serviceResponse = manageUserService.updateUser(users,
	 * userRolesList); if (serviceResponse) { return
	 * ApplicationConstant.SUCCESS_RESPONSE; } else { return
	 * ApplicationConstant.ERROR_RESPONSE; } }
	 */
}
