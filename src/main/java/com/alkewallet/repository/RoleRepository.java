package com.alkewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkewallet.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	

}
