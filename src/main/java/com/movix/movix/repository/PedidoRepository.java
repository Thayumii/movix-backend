package com.movix.movix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movix.movix.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
