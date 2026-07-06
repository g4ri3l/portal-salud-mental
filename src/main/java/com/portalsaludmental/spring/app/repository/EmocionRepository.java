package com.portalsaludmental.spring.app.repository;

import com.portalsaludmental.spring.app.model.Emocion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmocionRepository extends MongoRepository<Emocion, String> {
    List<Emocion> findByUsuarioId(String usuarioId);
}