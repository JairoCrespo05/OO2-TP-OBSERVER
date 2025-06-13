package org.example.ej1.model;

public class ObserverArchivo extends Observer{

    private String path;

    public ObserverArchivo(String path){
        this.path = path;
    }

    @Override
    public void update(String temperatura) {

        System.out.println("Escribiendo en archivo la temperatura: " + temperatura);

    }


    @Override
    protected void hola() {
        
    }
}
