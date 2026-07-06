package com.portalsaludmental.spring.app.controller;

import com.portalsaludmental.spring.app.model.Estres;
import com.portalsaludmental.spring.app.service.EstresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estres")
@CrossOrigin(origins = "*")
public class EstresController {

    private final EstresService estresService;

    public EstresController(EstresService estresService) {
        this.estresService = estresService;
    }

    @PostMapping
    public Estres registrar(@RequestBody Estres estres) {
        return estresService.registrar(estres);
    }

    @GetMapping
    public List<Estres> listarTodo() {
        return estresService.listarTodo();
    }

    @GetMapping("/{id}")
    public Estres buscarPorId(@PathVariable String id) {
        return estresService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Registro de estrés no encontrado"));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Estres> listarPorUsuario(@PathVariable String usuarioId) {
        return estresService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Estres actualizar(@PathVariable String id, @RequestBody Estres estres) {
        return estresService.actualizar(id, estres);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id) {
        estresService.eliminar(id);
        return "Registro de estrés eliminado correctamente";
    }
}