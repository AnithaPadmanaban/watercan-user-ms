package com.revature.watercanappuserms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "admin_info")
public class Admin {
	@Id
	@Column(name = "admin_id")
	private String adminId;
	@Column(name = "admin_name")
	private String name;
	@Column(name = "admin_email_id")
	private String email;
	@Column(name = "admin_password")
	private String password;
}
