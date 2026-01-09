package com.movix.movix.repository;

import com.movix.movix.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findByCodigoRastreio(String codigoRastreio);
}
