package com.alkewallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkewallet.entity.Client;
import com.alkewallet.repository.AccountRepository;
import com.alkewallet.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	public Optional<Client> getById(Long id) {
		return clientRepository.findById(id);
	}
	
	public Client save(Client Customer) {
		return clientRepository.save(Customer);	
	}
	
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}

}
