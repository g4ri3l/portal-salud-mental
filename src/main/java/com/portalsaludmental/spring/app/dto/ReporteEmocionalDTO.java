package com.portalsaludmental.spring.app.dto;

public class ReporteEmocionalDTO {

    private String nombrePaciente;
    private String emocion;
    private int nivelEstres;
    private int horasSueno;
    private String nota;
    private String bienestar;

    private ReporteEmocionalDTO() {}

    public String getNombrePaciente() { return nombrePaciente; }
    public String getEmocion() { return emocion; }
    public int getNivelEstres() { return nivelEstres; }
    public int getHorasSueno() { return horasSueno; }
    public String getNota() { return nota; }
    public String getBienestar() { return bienestar; }

    public static class Builder {
        private final ReporteEmocionalDTO reporte = new ReporteEmocionalDTO();

        public Builder nombrePaciente(String nombrePaciente) {
            reporte.nombrePaciente = nombrePaciente;
            return this;
        }

        public Builder emocion(String emocion) {
            reporte.emocion = emocion;
            return this;
        }

        public Builder nivelEstres(int nivelEstres) {
            reporte.nivelEstres = nivelEstres;
            return this;
        }

        public Builder horasSueno(int horasSueno) {
            reporte.horasSueno = horasSueno;
            return this;
        }

        public Builder nota(String nota) {
            reporte.nota = nota;
            return this;
        }

        public Builder bienestar(String bienestar) {
            reporte.bienestar = bienestar;
            return this;
        }

        public ReporteEmocionalDTO build() {
            return reporte;
        }
    }
}