package com.revature.watercanappuserms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.watercanappuserms.dto.RegisterInfo;
import com.revature.watercanappuserms.dto.UserLoginInfo;
import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.model.User;
import com.revature.watercanappuserms.repository.UserRepository;

public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User registerProcess(RegisterInfo registerInfo) throws ServiceException {
		
		User findUser = userRepository.findByEmail(registerInfo.getEmail());
		if (findUser != null) {
			throw new ServiceException("Email Id is already exist");
		}
		User user = new User(); 
		user.setName(registerInfo.getName());	
		user.setEmail(registerInfo.getEmail());
		user.setPassword(registerInfo.getPassword());
		user.setAddress(registerInfo.getAddress());
		
		try {
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to register user");
		}
		return user;
	}

	public User loginProcess(UserLoginInfo userLoginInfo) throws ServiceException {
		User user = null;
		String email=userLoginInfo.getEmail();
		String password=userLoginInfo.getPassword();
		
		user = userRepository.login(email, password);
		if (user == null) {
			throw new ServiceException("Invalid Email or Password");
		}
		return user;
	}
}
