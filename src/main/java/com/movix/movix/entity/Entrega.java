package com.movix.movix.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEntrega status = StatusEntrega.CRIADO;

    @NotNull(message = "A entrega deve estar associada a um pedido")
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private LocalDateTime criadoEm = LocalDateTime.now();

    @NotBlank(message = "O motorista não pode estar em branco")
    private String motorista;

    @NotBlank(message = "A placa do veículo não pode estar em branco")
    private String veiculoPlaca;

    @NotNull(message = "A data prevista não pode ser nula")
    private LocalDate dataPrevista;

}
