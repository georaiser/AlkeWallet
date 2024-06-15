package com.alkewallet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alkewallet.entity.Client;
import com.alkewallet.entity.Transaction;
import com.alkewallet.service.ClientService;
import com.alkewallet.service.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	public TransactionService transactionService;
	
	@Autowired
	public ClientService clientService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public String allTransactionsForm(Model model) {
		List<Transaction> transactions = transactionService.getAll();
		model.addAttribute("transactions", transactions);
		return "transaction/allTransactions";
	}
	
	@GetMapping("/selectClient")
	public String selectClientForm(Model model) {
		
		List<Client> clients = clientService.getAll();
		model.addAttribute("clients", clients);

		return "transaction/selectClient";
	}
	
	@GetMapping("/transactionsClient")
	public String transactionsClientForm(@RequestParam Long id, Model model) {
		Client client = clientService.getById(id).get();
		model.addAttribute("client", client);
		
		List<Transaction> transactions = transactionService.findByAccountId(id);
		model.addAttribute("transactions", transactions);

		return "transaction/transactionsByClient";
	}

}
