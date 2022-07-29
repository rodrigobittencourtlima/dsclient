package com.bittsoftware.dsclient.repositories;

import com.bittsoftware.dsclient.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
