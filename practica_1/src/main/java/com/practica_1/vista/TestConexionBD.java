package com.practica_1.vista;

import com.practica_1.modelo.ConexionBD;
import javax.persistence.EntityManagerFactory;

public class TestConexionBD {

    public static void main(String[] args) {

        try {

            EntityManagerFactory emf = ConexionBD.getInstancia();
            //emf.close();
            System.out.println("Conexion: " + emf.isOpen());

        } catch (Exception e) {
        }

    }

}
