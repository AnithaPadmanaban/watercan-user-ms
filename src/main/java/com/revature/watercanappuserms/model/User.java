package com.revature.watercanappuserms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_address")
	private String address;

}
