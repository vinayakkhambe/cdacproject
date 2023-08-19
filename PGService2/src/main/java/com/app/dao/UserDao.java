package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.User;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByEmailAndPassword(String email,String password);
	
	
}
