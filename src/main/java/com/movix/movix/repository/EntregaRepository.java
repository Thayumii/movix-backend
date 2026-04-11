package com.movix.movix.repository;

import com.movix.movix.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    Optional<Entrega> findByCodigoRastreio(String codigoRastreio);
}