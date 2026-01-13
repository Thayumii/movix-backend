package com.movix.movix.controller;

import com.movix.movix.DTO.LoginRequest;
import com.movix.movix.DTO.LoginResponse;
import com.movix.movix.DTO.RegisterRequest;
import com.movix.movix.entity.Usuario;
import com.movix.movix.repository.UsuarioRepository;
import com.movix.movix.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest data) {
        if (repository.findByUsername(data.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Erro: Usuário já existe!");
        }
        String encryptedPassword = passwordEncoder.encode(data.password());

        Usuario newUser = new Usuario();
        newUser.setUsername(data.username());
        newUser.setSenha(encryptedPassword);
        newUser.setRole(data.role());

        repository.save(newUser);

        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String token = jwtUtil.gerarToken(userDetails.getUsername());

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Credenciais inválidas" + e);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno" + e.getMessage());
        }
    }

}
