package com.bittsoftware.dsclient.resources;

import java.util.List;

import com.bittsoftware.dsclient.dtos.ClientDTO;
import com.bittsoftware.dsclient.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

}
