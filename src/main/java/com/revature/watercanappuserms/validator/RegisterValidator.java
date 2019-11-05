package com.revature.watercanappuserms.validator;

import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.model.User;

public class RegisterValidator {
	public void validateRegistration(User user) throws ServiceException { /// Validate register details

		String name = user.getName();
		String password = user.getPassword();
		String email = user.getEmail();
		String address = user.getAddress();
		if ("".equals(name.trim()) || name == null) {
			throw new ServiceException("Invalid name");
		}

		if ("".equals(password.trim()) || password == null) {
			throw new ServiceException("Invalid password");
		}
		if ("".equals(address.trim()) || address == null) {
			throw new ServiceException("Invald address");
		}
		if ("".equals(email.trim()) || email == null) {
			throw new ServiceException("Invalid email");
		}
	}
}
