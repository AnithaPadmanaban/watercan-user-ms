package com.revature.watercanappuserms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.revature.watercanappuserms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where email = :email and password = :password")
	User login(@Param("email") String email, @Param("password") String password);

	User findByEmail(String email);
}
