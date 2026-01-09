package com.movix.movix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.movix.movix.entity.Usuario;
import com.movix.movix.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev, test"})
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String ... args) throws Exception {
        String usernameTeste = "usuario_teste";

        if (!usuarioRepository.existsByUsername(usernameTeste)) {
            String senhaPura = "senha123";

            String senhaCriptografada = passwordEncoder.encode(senhaPura);

            Usuario novUsuario = new Usuario();
            novUsuario.setUsername(usernameTeste);
            novUsuario.setPassword(senhaCriptografada);

            usuarioRepository.save(novUsuario);
            
        }
    }

}
