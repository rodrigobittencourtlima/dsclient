package com.bittsoftware.dsclient.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.bittsoftware.dsclient.dtos.ClientDTO;
import com.bittsoftware.dsclient.entities.Client;
import com.bittsoftware.dsclient.repositories.ClientRepository;
import com.bittsoftware.dsclient.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(PageRequest pageRequest) {
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(entity -> new ClientDTO(entity));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		return new ClientDTO(repository.save(new Client(dto)));
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return entity.toDTO();
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

}
