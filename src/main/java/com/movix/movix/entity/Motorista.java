package com.movix.movix.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "motoristas")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cnh;

    @Column(unique = true)
    private String placaVeiculo;

    private boolean disponivel = true;

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;
}
