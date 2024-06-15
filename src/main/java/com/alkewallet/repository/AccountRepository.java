package com.alkewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alkewallet.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT MAX(account.accountNumber) FROM Account account")
    Long findMaxAccountNumber();

	Account findByAccountNumber(Long accountNumber);

}
