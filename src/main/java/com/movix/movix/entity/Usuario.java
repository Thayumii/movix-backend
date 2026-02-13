package com.movix.movix.entity;

import jakarta.persistence.*;

@Entity
@lombok.Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String senha;
    private String role;

    public Usuario() {
    }

    public Usuario(String email, String senha, String role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public void setPassword(String senhaCriptografada) {
        this.senha = senhaCriptografada;
    }
}
