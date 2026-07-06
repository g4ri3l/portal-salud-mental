package com.portalsaludmental.spring.app.repository;

import com.portalsaludmental.spring.app.model.Sesion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SesionRepository extends MongoRepository<Sesion, String> {
    List<Sesion> findByPacienteId(String pacienteId);
    List<Sesion> findByPsicologoId(String psicologoId);
}