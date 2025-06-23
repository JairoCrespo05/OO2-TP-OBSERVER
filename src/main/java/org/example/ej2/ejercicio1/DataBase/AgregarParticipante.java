package org.example.ej2.ejercicio1.DataBase;



import org.example.ej2.ejercicio1.Model.Participante;

import java.sql.SQLException;

public class AgregarParticipante extends Sujeto {

    private ConectionDataBase DB;


    public AgregarParticipante() throws SQLException {

        this.DB = new ConectionDataBase();
    }


    @Override
    public void crearNuevoParticipante(String nombre, String telefono, String region, String email) throws SQLException {

        Participante participante = new Participante(nombre, telefono, region, email);
        this.DB.insertarNuevoParticipante(participante);
        notificar(email);

    }

}
