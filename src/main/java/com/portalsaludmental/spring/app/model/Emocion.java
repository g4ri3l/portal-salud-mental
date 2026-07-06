package com.portalsaludmental.spring.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "emociones")
public class Emocion {

    @Id
    private String id;
    private String usuarioId;
    private String estado;
    private String comentario;
    private LocalDate fecha = LocalDate.now();

    public String getId() {
        return id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getEstado() {
        return estado;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}