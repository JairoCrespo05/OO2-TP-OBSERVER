package org.example.ej1.model;

public class ObserverClimatizador extends Observer{

    private static final String HACE_FRIO= "Hace frio, se encenderá la caldera";
    private static final String HACE_CALOR= "Hace calor, se encenderá el aire acondicionado";

    public ObserverClimatizador(){

    }


    @Override
    public void update(String temperatura) {
        double grados = Double.parseDouble(temperatura.substring(0, temperatura.length() - 3));
//        System.out.println(grados);

        if (grados < 12){
            System.out.println(HACE_FRIO);
        }
        if (grados > 17){
            System.out.println(HACE_CALOR);
        }else {
            System.out.println("Temperatura Normal");
        }
    }


    @Override
    protected void hola() {
        System.out.println("hola");
    }
}
