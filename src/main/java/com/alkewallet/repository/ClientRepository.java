package com.alkewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkewallet.entity.Client;
import com.alkewallet.entity.Transaction;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Transaction> findAllById(Long id);
	
	
}