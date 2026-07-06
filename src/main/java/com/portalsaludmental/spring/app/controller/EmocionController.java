package com.portalsaludmental.spring.app.controller;

import com.portalsaludmental.spring.app.model.Emocion;
import com.portalsaludmental.spring.app.service.EmocionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emociones")
@CrossOrigin(origins = "*")
public class EmocionController {

    private final EmocionService emocionService;

    public EmocionController(EmocionService emocionService) {
        this.emocionService = emocionService;
    }

    @PostMapping
    public Emocion registrar(@RequestBody Emocion emocion) {
        return emocionService.registrar(emocion);
    }

    @GetMapping
    public List<Emocion> listarTodo() {
        return emocionService.listarTodo();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Emocion> listarPorUsuario(@PathVariable String usuarioId) {
        return emocionService.listarPorUsuario(usuarioId);
    }
}