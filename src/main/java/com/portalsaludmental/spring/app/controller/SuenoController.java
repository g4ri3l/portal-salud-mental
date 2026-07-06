package com.portalsaludmental.spring.app.controller;

import com.portalsaludmental.spring.app.model.Sueno;
import com.portalsaludmental.spring.app.service.SuenoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suenos")
@CrossOrigin(origins = "*")
public class SuenoController {

    private final SuenoService suenoService;

    public SuenoController(SuenoService suenoService) {
        this.suenoService = suenoService;
    }

    @PostMapping
    public Sueno registrar(@RequestBody Sueno sueno) {
        return suenoService.registrar(sueno);
    }

    @GetMapping
    public List<Sueno> listarTodo() {
        return suenoService.listarTodo();
    }

    @GetMapping("/{id}")
    public Sueno buscarPorId(@PathVariable String id) {
        return suenoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Registro de sueño no encontrado"));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Sueno> listarPorUsuario(@PathVariable String usuarioId) {
        return suenoService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Sueno actualizar(@PathVariable String id, @RequestBody Sueno sueno) {
        return suenoService.actualizar(id, sueno);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id) {
        suenoService.eliminar(id);
        return "Registro de sueño eliminado correctamente";
    }
}