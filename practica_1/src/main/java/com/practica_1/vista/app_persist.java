package com.practica_1.vista;

import com.practica_1.modelo.Departamento;
import com.practica_1.modelo.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class app_persist {


    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("practica1");
    
    public static void main(String[] args) {
        
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Departamento sistemas = new Departamento(1, "area de sistemas");
        Empleado andres = new Empleado(12, "andres", "ingeniero", "tiempo completo", sistemas);
        
        sistemas.addE(andres);
        
        em.persist(sistemas);
        
        em.getTransaction().commit();
        em.close();
        
        System.out.println("Exito!!!");
    }

    
}
