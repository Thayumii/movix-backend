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

    @NotBlank(message = "O endereço não pode estar em branco")
    private String endereco;

}
