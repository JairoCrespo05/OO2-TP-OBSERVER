package org.example.ej1.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableoSujeto {

    private List<Observador> observers;

    public ObservableoSujeto(){
        this.observers = new ArrayList<>();
    }

    public void agregarObservers(List<Observador> lista) {
        this.observers.addAll(lista);
    }

    public void notificar(String tempreatura){
        for (Observador obs: this.observers){
            obs.update(tempreatura);
        }
    }


}
