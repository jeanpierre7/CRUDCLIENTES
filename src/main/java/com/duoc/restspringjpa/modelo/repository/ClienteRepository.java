package com.duoc.restspringjpa.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.restspringjpa.modelo.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
