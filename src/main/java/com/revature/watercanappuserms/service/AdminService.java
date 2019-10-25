package com.revature.watercanappuserms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.watercanappuserms.dto.AdminLoginInfo;
import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.model.Admin;
import com.revature.watercanappuserms.repository.AdminRepository;

public class AdminService {
	@Autowired
	AdminRepository adminRepository;

	public Admin adminLoginProcess(AdminLoginInfo adminLoginInfo) throws ServiceException {
		Admin admin = null;
		String email = adminLoginInfo.getEmail();
		String password = adminLoginInfo.getPassword();
		admin = adminRepository.adminLogin(email, password);
		if (admin == null) {
			throw new ServiceException("Invalid Email or Password");
		}
		return admin;
	}
}
