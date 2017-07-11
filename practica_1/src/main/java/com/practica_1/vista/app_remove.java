package com.practica_1.vista;

import com.practica_1.modelo.Departamento;
import com.practica_1.modelo.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class app_remove {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("practica1");
    
    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Departamento contabilidad = new Departamento(2, "Contabilidad");
        Departamento RRHH = new Departamento(3, "Recursos Humanos");
        Empleado sara = new Empleado(23, "Sara", "contadora", "tiempo completo", contabilidad);
        Empleado lucia = new Empleado(24, "Lucia", "Jefe RRHH", "tiempo completo", RRHH);
        
        contabilidad.addE(sara);
        RRHH.addE(lucia);
        
        em.persist(sara);
        em.persist(lucia);
        
        contabilidad.removeED(sara);
        
        em.getTransaction().commit();
        em.close();
        
        System.out.println("Exito!!!");
        
    }
    
}
