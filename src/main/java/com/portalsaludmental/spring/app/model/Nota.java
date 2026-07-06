package com.portalsaludmental.spring.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "notas")
public class Nota {

    @Id
    private String id;
    private String usuarioId;
    private String contenido;
    private LocalDate fecha = LocalDate.now();

    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public String getContenido() { return contenido; }
    public LocalDate getFecha() { return fecha; }

    public void setId(String id) { this.id = id; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}