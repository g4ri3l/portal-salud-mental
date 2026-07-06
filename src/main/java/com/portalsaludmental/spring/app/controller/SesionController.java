package com.portalsaludmental.spring.app.controller;

import com.portalsaludmental.spring.app.model.Sesion;
import com.portalsaludmental.spring.app.service.SesionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
@CrossOrigin(origins = "*")
public class SesionController {

    private final SesionService sesionService;

    public SesionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }

    @PostMapping
    public Sesion registrar(@RequestBody Sesion sesion) {
        return sesionService.registrar(sesion);
    }

    @GetMapping
    public List<Sesion> listarTodo() {
        return sesionService.listarTodo();
    }

    @GetMapping("/{id}")
    public Sesion buscarPorId(@PathVariable String id) {
        return sesionService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Sesión no encontrada"));
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Sesion> listarPorPaciente(@PathVariable String pacienteId) {
        return sesionService.listarPorPaciente(pacienteId);
    }

    @GetMapping("/psicologo/{psicologoId}")
    public List<Sesion> listarPorPsicologo(@PathVariable String psicologoId) {
        return sesionService.listarPorPsicologo(psicologoId);
    }

    @PutMapping("/{id}")
    public Sesion actualizar(@PathVariable String id,
                             @RequestBody Sesion sesion) {
        return sesionService.actualizar(id, sesion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id) {
        sesionService.eliminar(id);
        return "Sesión eliminada correctamente";
    }
}