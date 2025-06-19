package org.example.ej2.ejercicio1.DataBase;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto implements NewParticipante{

    private List<ServicioEmail> observadores;

    public Sujeto(){
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador (ServicioEmail o){
        observadores.add(o);
    }

    public void notificar(String email){
        for (ServicioEmail obs : this.observadores){
            obs.update(email);
        }
    }

}
