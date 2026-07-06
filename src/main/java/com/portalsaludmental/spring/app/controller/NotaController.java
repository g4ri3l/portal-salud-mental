package com.portalsaludmental.spring.app.controller;

import com.portalsaludmental.spring.app.model.Nota;
import com.portalsaludmental.spring.app.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public Nota registrar(@RequestBody Nota nota) {
        return notaService.registrar(nota);
    }

    @GetMapping
    public List<Nota> listarTodo() {
        return notaService.listarTodo();
    }

    @GetMapping("/{id}")
    public Nota buscarPorId(@PathVariable String id) {
        return notaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Nota> listarPorUsuario(@PathVariable String usuarioId) {
        return notaService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Nota actualizar(@PathVariable String id, @RequestBody Nota nota) {
        return notaService.actualizar(id, nota);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id) {
        notaService.eliminar(id);
        return "Nota eliminada correctamente";
    }
}