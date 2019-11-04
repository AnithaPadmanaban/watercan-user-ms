package com.revature.watercanappuserms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.watercanappuserms.dto.MailDTO;
import com.revature.watercanappuserms.dto.RegisterInfo;
import com.revature.watercanappuserms.dto.UserLoginInfo;
import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.model.User;
import com.revature.watercanappuserms.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailService mailservice;

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
			MailDTO mail = new MailDTO();
			mail.setName(registerInfo.getName());
			mail.setEmail(registerInfo.getEmail());
			userRepository.save(user);
			mailservice.sendMail(mail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to register");
		}
		return user;
	}

	public User loginProcess(UserLoginInfo userLoginInfo) throws ServiceException {
		User user = null;
		String email = userLoginInfo.getEmail();
		String password = userLoginInfo.getPassword();

		user = userRepository.login(email, password);
		if (user == null) {
			throw new ServiceException("Invalid Email or Password");
		}
		return user;
	}

	public List<User> listAllUsers() throws ServiceException {
		List<User> user;
		user = userRepository.findAll();
		if (user == null) {
			throw new ServiceException("Sorry!!!, something went to wrong");
		}
		return user;
	}

}
