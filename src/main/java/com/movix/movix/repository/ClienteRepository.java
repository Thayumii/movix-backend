package com.movix.movix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movix.movix.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
