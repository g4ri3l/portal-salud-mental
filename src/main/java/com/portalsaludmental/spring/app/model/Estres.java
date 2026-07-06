package com.portalsaludmental.spring.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "estres")
public class Estres {

    @Id
    private String id;
    private String usuarioId;
    private int nivel;
    private String causa;
    private String sintomas;
    private LocalDate fecha = LocalDate.now();

    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public int getNivel() { return nivel; }
    public String getCausa() { return causa; }
    public String getSintomas() { return sintomas; }
    public LocalDate getFecha() { return fecha; }

    public void setId(String id) { this.id = id; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setCausa(String causa) { this.causa = causa; }
    public void setSintomas(String sintomas) { this.sintomas = sintomas; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}