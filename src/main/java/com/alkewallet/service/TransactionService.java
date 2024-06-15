package com.alkewallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkewallet.entity.Transaction;
import com.alkewallet.repository.TransactionRepository;

@Transactional
@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public List<Transaction> getAll(){
		return transactionRepository.findAll();
	}
	
	public Optional<Transaction> getById(Long id) {
		return transactionRepository.findById(id);
	}
	
	public Transaction getByType(String type) {
		return transactionRepository.findByType(type);
	}
	
	public List<Transaction> findByAccountId(Long accountId){
		return transactionRepository.findByAccountId(accountId);

	}
	
}
