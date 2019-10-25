package com.revature.watercanappuserms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.revature.watercanappuserms.service.AdminService;
import com.revature.watercanappuserms.service.UserService;

@Configuration
public class AppConfig {
	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public AdminService adminService() {
		return new AdminService();
	}
}
