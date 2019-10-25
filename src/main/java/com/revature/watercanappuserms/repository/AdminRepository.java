package com.revature.watercanappuserms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.revature.watercanappuserms.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	@Query("from Admin where email = :email and password = :password")
	Admin adminLogin(@Param("email") String email, @Param("password") String password);
}
