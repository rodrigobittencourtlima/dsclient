package com.bittsoftware.dsclient.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bittsoftware.dsclient.dtos.ClientDTO;
import com.bittsoftware.dsclient.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@GetMapping
	public List<ClientDTO> findAll() {
		return repository.findAll().stream().map(entity -> new ClientDTO(entity)).collect(Collectors.toList());
	}

}
