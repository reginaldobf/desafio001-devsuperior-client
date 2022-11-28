package com.devsuperior.d001dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.d001dsclient.entities.Client;

@Repository      															// the objects are now managed by spring
public interface ClientRepository extends JpaRepository<Client, Long>{

}
