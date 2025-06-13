package org.example.ej1.model;

import java.util.ArrayList;
import java.util.List;

public class Medidor extends ObservableoSujeto {

    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
        //leo la temperatura del servicio web
        this.temperatura = clima.temperatura();
        notificar(this.temperatura);

        return this.temperatura;
    }

}
