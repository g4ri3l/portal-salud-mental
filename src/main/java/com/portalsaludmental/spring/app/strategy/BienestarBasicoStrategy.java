package com.portalsaludmental.spring.app.strategy;

public class BienestarBasicoStrategy implements BienestarStrategy {

    @Override
    public String calcularBienestar(int nivelEstres, int horasSueno) {
        if (nivelEstres <= 3 && horasSueno >= 7) {
            return "Bienestar alto";
        } else if (nivelEstres <= 6 && horasSueno >= 5) {
            return "Bienestar moderado";
        } else {
            return "Bienestar bajo";
        }
    }
}