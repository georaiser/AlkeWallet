package com.alkewallet.controller;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alkewallet.entity.Account;
import com.alkewallet.entity.Client;
import com.alkewallet.entity.Transaction;
import com.alkewallet.service.AccountNumberGeneratorService;
import com.alkewallet.service.AccountService;
import com.alkewallet.service.ClientService;
import com.alkewallet.service.TransactionService;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	public AccountService accountService;
	
	@Autowired
	public ClientService clientService;
	
	@Autowired
	public TransactionService transactionService;
	
	@Autowired
	public AccountNumberGeneratorService accountNumberGeneratorService;
	
	
	@GetMapping("/new")
	public String newAccountForm(Model model) {
		
		// Create a new account object and generate an account number
        Account account = new Account();
        account.setAccountNumber(accountNumberGeneratorService.generateAccountNumber());
        model.addAttribute("message", "Account created successfully!");
        model.addAttribute("account", account);
		
        // Add account types to the model
		List<String> accountTypes = Arrays.asList("CHECKING", "SAVING");
	    model.addAttribute("accountTypes", accountTypes);
	    
	    //
		List<Client> clients = clientService.getAll();
		model.addAttribute("clients", clients);

		return "account/newAccount";
	}
	
	@PostMapping("/save")
	public String createAccount(@ModelAttribute("account") Account account) {
		accountService.save(account);
		return "redirect:/accounts/new";
	} 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteAccountId(@PathVariable Long id, Model model) {
		accountService.deleteById(id);
		return "redirect:/accounts/all";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String deleteAccountForm(Model model) {
		model.addAttribute("account", new Account());
		List<Account> accounts = accountService.getAll();
		model.addAttribute("accounts", accounts);
		return "account/deleteAccount";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/deleteAction")
	public String deleteAccount(@RequestParam Long accountNumber) {
		accountService.deleteByAccountNumber(accountNumber);
		return "redirect:/accounts/delete";
	} 
	
	@GetMapping("/all")
	public String allAccountsForm(Model model) {
		List<Account> accounts = accountService.getAll();
		model.addAttribute("accounts", accounts);
		return "account/allAccounts";
	}
	
	@GetMapping("/show/{id}")
	public String showAccountId(@PathVariable Long id, Model model) {
		Optional<Account> account = accountService.getById(id);
		model.addAttribute("account", account.get());
		
		List<Transaction> transactionsAccount = transactionService.findByAccountId(id);
		model.addAttribute("transactionsAccount", transactionsAccount);
		return "account/showAccount";
	}
	
	@GetMapping("/deposit/{id}")
	public String depositAccountId(@PathVariable Long id, Model model) {
		Optional<Account> account = accountService.getById(id);
		model.addAttribute("account", account.get());
		return "account/deposit";
	}
	
	@PostMapping("/depositAction")
	public String deposit(@RequestParam Long id, @RequestParam Double amount) {
		accountService.depositById(id, amount);
		return "redirect:/accounts/show/" + id;
	}
	
	@GetMapping("/withdrawal/{id}")
	public String withdrawalAccountId(@PathVariable Long id, Model model) {
		Optional<Account> account = accountService.getById(id);
		model.addAttribute("account", account.get());
		return "account/withdrawal";
	}
	
	@PostMapping("/withdrawalAction")
	public String withdrawal(@RequestParam Long id, @RequestParam Double amount) {
		accountService.withdrawalById(id, amount);
		return "redirect:/accounts/show/" + id;
	}
	
	@GetMapping("/transfer/{id}")
	public String transferAccountId(@PathVariable Long id, Model model) {
		
		Optional<Account> accountSource = accountService.getById(id);
		model.addAttribute("accountSource", accountSource.get());
		
		List<Account> accountTargets = accountService.getAll();
		model.addAttribute("accountTargets", accountTargets);
		
		return "account/transfer";
	}
	
	@PostMapping("/transferAction")
	public String transfer(@RequestParam Long id, @RequestParam Long idTarget, @RequestParam Double amount) {
		accountService.transferById(id, idTarget, amount);
		return "redirect:/accounts/show/" + id;
	}
	
	@GetMapping("/edit/{id}")
	public String editAccountId(@PathVariable Long id, Model model) {
		Optional<Account> account = accountService.getById(id);
		model.addAttribute("account", account.get());
		return "account/edit";
	}
	
	@PostMapping("/editAction")
	public String edit(@RequestParam Long id, @RequestParam Double amount) {
		accountService.depositById(id, amount);
		return "redirect:/accounts/all";
	}
	
	@GetMapping("/showAccount")
	public String showAccountsForm(Model model) {
		List<Account> accounts = accountService.getAll();
		model.addAttribute("accounts", accounts);
		return "account/searchAccount";
	}
	
	@GetMapping("/showAction")
	public String showAction(@RequestParam Long id, Model model) {
	    Optional<Account> account = accountService.getById(id);
	    if (account.isPresent()) {
	        model.addAttribute("account", account.get());
	        
	        List<Transaction> transactionsAccount = transactionService.findByAccountId(id);
	        model.addAttribute("transactionsAccount", transactionsAccount);
	        return "account/showAccount";
	    } else {
	        // Handle the case where the account is not found
	        return "redirect:/accounts/showAccount";
	    }
	}
		
}
