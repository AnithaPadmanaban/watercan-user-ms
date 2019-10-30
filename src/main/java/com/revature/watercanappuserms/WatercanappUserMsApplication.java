package com.revature.watercanappuserms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WatercanappUserMsApplication {
	@Bean
    public RestTemplate restTemplate()
    {
    	return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(WatercanappUserMsApplication.class, args);
	}

}
