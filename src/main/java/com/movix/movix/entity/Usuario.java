package com.movix.movix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@lombok.Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String senha;
    private String role;

    public Usuario() {}

    public Usuario(String username, String senha, String role) {
        this.username = username;
        this.senha = senha;
        this.role = role;
    }

    public void setPassword(String senhaCriptografada) {
        this.senha = senhaCriptografada;
    }
}
