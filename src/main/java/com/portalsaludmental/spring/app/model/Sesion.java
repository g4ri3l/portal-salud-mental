package com.portalsaludmental.spring.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "sesiones")
public class Sesion {

    @Id
    private String id;
    private String pacienteId;
    private String psicologoId;
    private LocalDateTime fechaHora;
    private String estado;

    public String getId() { return id; }
    public String getPacienteId() { return pacienteId; }
    public String getPsicologoId() { return psicologoId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }

    public void setId(String id) { this.id = id; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }
    public void setPsicologoId(String psicologoId) { this.psicologoId = psicologoId; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public void setEstado(String estado) { this.estado = estado; }
}