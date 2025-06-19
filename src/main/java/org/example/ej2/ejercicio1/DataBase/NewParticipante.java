package org.example.ej2.ejercicio1.DataBase;

import java.sql.SQLException;

public interface NewParticipante {

    void crearNuevoParticipante(String nombre, String telefono, String region, String email) throws SQLException;
}
