package org.example;

import org.example.ej1.model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Observador> listaObservers = new ArrayList<>();
        WeatherChannelService climaWeb = new WeatherChannelService("eec25324f7d66401f0d1be23c449e031");

        Medidor observable = new Medidor(climaWeb);

        var observerArch = new ObserverArchivo("src/main/resources/clima.txt");
        var observerClimatizante = new ObserverClimatizador();

        listaObservers.add(observerArch);
        listaObservers.add(observerClimatizante);

        observable.agregarObservers(listaObservers);

        System.out.println(observable.leerTemperatura());



    }
}