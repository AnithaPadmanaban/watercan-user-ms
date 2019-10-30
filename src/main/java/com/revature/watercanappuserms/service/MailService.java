package com.revature.watercanappuserms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.watercanappuserms.dto.MailDTO;

public class MailService {


    @Autowired
    RestTemplate restTemplate;
    
    void sendMail(final MailDTO mailDTO)
    {
        String apiUrl = "https://charity-notification.herokuapp.com";
        ResponseEntity<Void> postForEntity = restTemplate.postForEntity(apiUrl+"/mail/registeruser", mailDTO, Void.class);
        System.out.println(postForEntity);
    }
}
