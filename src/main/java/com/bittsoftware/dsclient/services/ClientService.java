package com.bittsoftware.dsclient.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bittsoftware.dsclient.dtos.ClientDTO;
import com.bittsoftware.dsclient.entities.Client;
import com.bittsoftware.dsclient.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		return repository.findAll().stream().map(entity -> new ClientDTO(entity)).collect(Collectors.toList());
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		return new ClientDTO(repository.save(new Client(dto)));
	}

}
