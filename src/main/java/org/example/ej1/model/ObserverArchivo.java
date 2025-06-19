package org.example.ej1.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class ObserverArchivo extends Observer{

    static final String FALLO_EN_ESCRITURA = "Fallo en la escritura en Archivo";
    private String path;

    public ObserverArchivo(String path){
        this.path = path;
    }

    @Override
    public void update(String temperatura) {
        System.out.println("Escribiendo en archivo la temperatura: " + temperatura);

        String contenido= "Temperatura: " + temperatura + ", Fecha: " + LocalDate.now();

        try {
            Files.write( Path.of(this.path),
                    contenido.getBytes(),
                    Files.exists(Path.of(this.path)) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

        } catch (IOException e) {
            throw new RuntimeException(FALLO_EN_ESCRITURA);
        }
    }



}
