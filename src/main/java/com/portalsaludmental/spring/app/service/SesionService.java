package com.portalsaludmental.spring.app.service;

import com.portalsaludmental.spring.app.model.Sesion;
import com.portalsaludmental.spring.app.repository.SesionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    private final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    public Sesion registrar(Sesion sesion) {

        sesion.setEstado("PROGRAMADA");

        return sesionRepository.save(sesion);
    }

    public List<Sesion> listarTodo() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> buscarPorId(String id) {
        return sesionRepository.findById(id);
    }

    public List<Sesion> listarPorPaciente(String pacienteId) {
        return sesionRepository.findByPacienteId(pacienteId);
    }

    public List<Sesion> listarPorPsicologo(String psicologoId) {
        return sesionRepository.findByPsicologoId(psicologoId);
    }

    public Sesion actualizar(String id, Sesion nuevaSesion) {

        Sesion sesion = sesionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sesión no encontrada"));

        sesion.setPacienteId(nuevaSesion.getPacienteId());
        sesion.setPsicologoId(nuevaSesion.getPsicologoId());
        sesion.setFechaHora(nuevaSesion.getFechaHora());
        sesion.setEstado(nuevaSesion.getEstado());

        return sesionRepository.save(sesion);
    }

    public void eliminar(String id) {
        sesionRepository.deleteById(id);
    }
}