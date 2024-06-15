package com.alkewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkewallet.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	boolean existsByUsername(String username);
	
}
