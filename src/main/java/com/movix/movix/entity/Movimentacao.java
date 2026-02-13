package com.movix.movix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entrega_id")
    @JsonIgnore
    private Entrega entrega;

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusAtual;

    private String descricao;
    private String localizacaoOrigem;
    private String localizacaoDestino;
    private LocalDateTime dataHora;
}
