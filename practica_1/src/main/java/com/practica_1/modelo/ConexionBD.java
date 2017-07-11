package com.practica_1.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionBD {


    private static EntityManagerFactory emf = null;
    
    private ConexionBD(){
        
    }
    
    public static EntityManagerFactory getInstancia(){
        
        if(emf == null){
            
            emf = Persistence.createEntityManagerFactory("practica1");
            
        }
        
        return emf;
        
    }

    
}
