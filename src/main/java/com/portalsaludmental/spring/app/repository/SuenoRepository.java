package com.portalsaludmental.spring.app.repository;

import com.portalsaludmental.spring.app.model.Sueno;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SuenoRepository extends MongoRepository<Sueno, String> {
    List<Sueno> findByUsuarioId(String usuarioId);
}