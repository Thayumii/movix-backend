package com.movix.movix.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "O telefone não pode estar em branco")
    private String telefone;

    @NotBlank(message = "O e-mail não pode estar em branco")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "O CEP não pode estar em branco")
    private String cep;

    @NotBlank(message = "O logradouro não pode estar em branco")
    private String logradouro;

    private String numero;

    @NotBlank(message = "O complemento não pode estar em branco")
    private String complemento;

    @NotBlank(message = "O ponto de referência não pode estar em branco")
    private String pontoReferencia;

    @NotBlank(message = "O bairro não pode estar em branco")
    private String bairro;

    @NotBlank(message = "A cidade não pode estar em branco")
    private String cidade;

    @NotBlank(message = "O estado não pode estar em branco")
    private String estado;

}
