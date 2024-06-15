package com.alkewallet.service;

import java.time.LocalDateTime;


import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.alkewallet.entity.Account;

import com.alkewallet.entity.Transaction;
import com.alkewallet.repository.AccountRepository;
import com.alkewallet.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public List<Account> getAll(){
		return accountRepository.findAll();
	}
	
	public Optional<Account> getById(Long id) {
		return accountRepository.findById(id);
	}
	
	public Account getByAccountNumber(Long accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	public Account save(Account account) {
		return accountRepository.save(account);	
	}
	
	public boolean deleteByAccountNumber(Long accountNumber) {
		boolean state = false;
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account != null) {
			accountRepository.deleteById(account.getId());
			state=true;
		}
		return state;
	}
	
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	public void depositById(Long id, Double amount) {
		Optional<Account> account = accountRepository.findById(id);
		Double balance = account.get().getBalance();
		System.out.println(balance);
		System.out.println(amount);
		balance += amount;
		account.get().setBalance(balance);
		accountRepository.save(account.get());
		
		Transaction transaction = new Transaction(LocalDateTime.now(),"Deposit",amount, null, account.get().getId());
		transactionRepository.save(transaction);
	}

	public void withdrawalById(Long id, Double amount) {
		Optional<Account> account = accountRepository.findById(id);
		Double balance = account.get().getBalance();
		System.out.println(balance);
		System.out.println(amount);
		balance -= amount;
		account.get().setBalance(balance);
		accountRepository.save(account.get());
		
		Transaction transaction = new Transaction(LocalDateTime.now(),"Withdrawal",amount, null, account.get().getId());
		transactionRepository.save(transaction);
	}

	public void transferById(Long idSource, Long idTarget, Double amount) {
		
		Optional<Account> accountSource = accountRepository.findById(idSource);
		Double balanceSource = accountSource.get().getBalance();
		System.out.println(balanceSource);
		System.out.println(amount);
		balanceSource -= amount;
		accountSource.get().setBalance(balanceSource);
		accountRepository.save(accountSource.get());
		
		
		Optional<Account> accountTarget = accountRepository.findById(idTarget);
		Double balanceTarget = accountTarget.get().getBalance();
		balanceTarget += amount;
		accountTarget.get().setBalance(balanceTarget);
		accountRepository.save(accountTarget.get());
		
		Transaction transaction = new Transaction(LocalDateTime.now(),"Transfer",amount, accountSource.get().getId(), accountTarget.get().getId());
		transactionRepository.save(transaction);	
	}

}
