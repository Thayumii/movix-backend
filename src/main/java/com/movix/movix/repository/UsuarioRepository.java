package com.movix.movix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movix.movix.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);

}
