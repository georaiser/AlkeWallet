package com.alkewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alkewallet.entity.Account;
import com.alkewallet.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public Transaction findByType(String type);
		
    @Query("SELECT t FROM Transaction t WHERE t.sourceAccount = :accountId OR t.targetAccount = :accountId")
    List<Transaction> findByAccountId(@Param("accountId") Long accountId);
    
}
