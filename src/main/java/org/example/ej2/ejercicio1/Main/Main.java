package org.example.ej2.ejercicio1.Main;



import org.example.ej2.ejercicio1.DataBase.AgregarParticipante;
import org.example.ej2.ejercicio1.DataBase.NewParticipante;
import org.example.ej2.ejercicio1.mensajeria.MailMessenger;
import org.example.ej2.ejercicio1.ui.VentanaAgregarParticipante;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    NewParticipante api = new AgregarParticipante(new MailMessenger());
                    VentanaAgregarParticipante frame = new VentanaAgregarParticipante(api);

                    frame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}