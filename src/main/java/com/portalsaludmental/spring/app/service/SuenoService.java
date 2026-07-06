package com.portalsaludmental.spring.app.service;

import com.portalsaludmental.spring.app.model.Sueno;
import com.portalsaludmental.spring.app.repository.SuenoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuenoService {

    private final SuenoRepository suenoRepository;

    public SuenoService(SuenoRepository suenoRepository) {
        this.suenoRepository = suenoRepository;
    }

    public Sueno registrar(Sueno sueno) {
        return suenoRepository.save(sueno);
    }

    public List<Sueno> listarTodo() {
        return suenoRepository.findAll();
    }

    public List<Sueno> listarPorUsuario(String usuarioId) {
        return suenoRepository.findByUsuarioId(usuarioId);
    }

    public Optional<Sueno> buscarPorId(String id) {
        return suenoRepository.findById(id);
    }

    public Sueno actualizar(String id, Sueno suenoActualizado) {
        Sueno sueno = suenoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de sueño no encontrado"));

        sueno.setUsuarioId(suenoActualizado.getUsuarioId());
        sueno.setHoras(suenoActualizado.getHoras());
        sueno.setCalidad(suenoActualizado.getCalidad());
        sueno.setFecha(suenoActualizado.getFecha());

        return suenoRepository.save(sueno);
    }

    public void eliminar(String id) {
        suenoRepository.deleteById(id);
    }
}