package com.portalsaludmental.spring.app.repository;

import com.portalsaludmental.spring.app.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByCorreo(String correo);
}