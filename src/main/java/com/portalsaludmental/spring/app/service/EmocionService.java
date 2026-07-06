package com.portalsaludmental.spring.app.service;

import com.portalsaludmental.spring.app.model.Emocion;
import com.portalsaludmental.spring.app.repository.EmocionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmocionService {

    private final EmocionRepository emocionRepository;

    public EmocionService(EmocionRepository emocionRepository) {
        this.emocionRepository = emocionRepository;
    }

    public Emocion registrar(Emocion emocion) {
        return emocionRepository.save(emocion);
    }

    public List<Emocion> listarPorUsuario(String usuarioId) {
        return emocionRepository.findByUsuarioId(usuarioId);
    }

    public List<Emocion> listarTodo() {
        return emocionRepository.findAll();
    }
}