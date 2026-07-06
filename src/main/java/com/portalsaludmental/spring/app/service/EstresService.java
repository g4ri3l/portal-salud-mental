package com.portalsaludmental.spring.app.service;

import com.portalsaludmental.spring.app.model.Estres;
import com.portalsaludmental.spring.app.repository.EstresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstresService {

    private final EstresRepository estresRepository;

    public EstresService(EstresRepository estresRepository) {
        this.estresRepository = estresRepository;
    }

    public Estres registrar(Estres estres) {
        return estresRepository.save(estres);
    }

    public List<Estres> listarTodo() {
        return estresRepository.findAll();
    }

    public List<Estres> listarPorUsuario(String usuarioId) {
        return estresRepository.findByUsuarioId(usuarioId);
    }

    public Optional<Estres> buscarPorId(String id) {
        return estresRepository.findById(id);
    }

    public Estres actualizar(String id, Estres estresActualizado) {
        Estres estres = estresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de estrés no encontrado"));

        estres.setUsuarioId(estresActualizado.getUsuarioId());
        estres.setNivel(estresActualizado.getNivel());
        estres.setCausa(estresActualizado.getCausa());
        estres.setSintomas(estresActualizado.getSintomas());
        estres.setFecha(estresActualizado.getFecha());

        return estresRepository.save(estres);
    }

    public void eliminar(String id) {
        estresRepository.deleteById(id);
    }
}