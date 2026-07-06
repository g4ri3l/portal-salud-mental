package com.portalsaludmental.spring.app.service;

import com.portalsaludmental.spring.app.model.Nota;
import com.portalsaludmental.spring.app.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Nota registrar(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<Nota> listarTodo() {
        return notaRepository.findAll();
    }

    public List<Nota> listarPorUsuario(String usuarioId) {
        return notaRepository.findByUsuarioId(usuarioId);
    }

    public Optional<Nota> buscarPorId(String id) {
        return notaRepository.findById(id);
    }

    public Nota actualizar(String id, Nota notaActualizada) {

        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));

        nota.setUsuarioId(notaActualizada.getUsuarioId());
        nota.setContenido(notaActualizada.getContenido());
        nota.setFecha(notaActualizada.getFecha());

        return notaRepository.save(nota);
    }

    public void eliminar(String id) {
        notaRepository.deleteById(id);
    }
}