package com.movix.movix.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigoRastreio;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Column(length = 500)
    private String descricao;

    @NotBlank(message = "A origem não pode estar em branco")
    private String origem;

    @NotBlank(message = "O destino não pode estar em branco")
    private String destino;

    @NotNull(message = "O peso não pode ser nulo")
    @Positive(message = "O peso deve ser maior que zero")
    private Double peso;
    private BigDecimal valorFrete;

    private LocalDate criadoEm = LocalDate.now();

    @ManyToOne
    private Cliente cliente;

}
