package com.alkewallet.controller;

import java.util.List;

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
import com.alkewallet.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	public ClientService clientService;
	
	@GetMapping("/new")
	public String newClientForm(Model model) {
		model.addAttribute("client", new Client());
		return "client/newClient";
	}
	
	@PostMapping("/save")
	public String createClient(@ModelAttribute("client") Client client ) {
		clientService.save(client);
		return "redirect:/clients/new";
	}
	
	@GetMapping("/all")
	public String allClientsForm(Model model) {
		List<Client> clients = clientService.getAll();
		model.addAttribute("clients", clients);
		return "client/allClients";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteAccountId(@PathVariable Long id, Model model) {
		clientService.deleteById(id);
		return "redirect:/accounts/all";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String deleteClientForm(Model model) {
		model.addAttribute("client", new Client());
		List<Client> clients = clientService.getAll();
		model.addAttribute("clients", clients);
		return "client/deleteClient";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/deleteAction")
	public String deleteAccount(@RequestParam Long id) {
		clientService.deleteById(id);
		return "redirect:/clients/delete";
	} 
	
}
