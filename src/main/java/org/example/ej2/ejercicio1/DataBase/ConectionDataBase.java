package org.example.ej2.ejercicio1.DataBase;



import org.example.ej2.ejercicio1.Model.Participante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectionDataBase {

    private Connection dbConn;
    public static String url = "jdbc:mysql://localhost:3306/oo2_tp_observer";
    public static String user = "root";
    public static String password = "";
    public static String INSERT_PARTICIPANTE = " INSERT INTO participante (nombre, telefono, region, email) VALUES (?,?,?,?) ";


    public ConectionDataBase() throws SQLException {
        this.dbConn = DriverManager.getConnection(url, user, password);
    }


    public void insertarNuevoParticipante(Participante participante) throws SQLException {

        try(PreparedStatement st = dbConn.prepareStatement(INSERT_PARTICIPANTE)){

            st.setString(1, participante.miNombreEs());
            st.setString(2, participante.miTelefonoEs());
            st.setString(3, participante.miRegionEs());
            st.setString(4, participante.miEmailEs());
            st.executeUpdate();
        }
    }


}