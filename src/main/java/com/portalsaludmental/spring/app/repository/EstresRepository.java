package com.portalsaludmental.spring.app.repository;

import com.portalsaludmental.spring.app.model.Estres;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EstresRepository extends MongoRepository<Estres, String> {
    List<Estres> findByUsuarioId(String usuarioId);
}