package com.portalsaludmental.spring.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "suenos")
public class Sueno {

    @Id
    private String id;
    private String usuarioId;
    private int horas;
    private String calidad;
    private LocalDate fecha = LocalDate.now();

    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public int getHoras() { return horas; }
    public String getCalidad() { return calidad; }
    public LocalDate getFecha() { return fecha; }

    public void setId(String id) { this.id = id; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public void setHoras(int horas) { this.horas = horas; }
    public void setCalidad(String calidad) { this.calidad = calidad; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}