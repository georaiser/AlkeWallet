package com.alkewallet.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkewallet.repository.AccountRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AccountNumberGeneratorService {

    private AtomicLong accountNumberCounter;
    
    @Autowired
    private AccountRepository accountRepository; 

    @PostConstruct
    public void init() {
        Long maxAccountNumber = accountRepository.findMaxAccountNumber();
        if (maxAccountNumber == null) {
            // If there are no existing accounts, start from 10000
            maxAccountNumber = 78000L;
        } else {
            // Start from the next number
            maxAccountNumber += 1;
        }
        accountNumberCounter = new AtomicLong(maxAccountNumber);
    }

    public Long generateAccountNumber() {
        // Increment and return the next account number
        return accountNumberCounter.getAndIncrement();
    }
    

}