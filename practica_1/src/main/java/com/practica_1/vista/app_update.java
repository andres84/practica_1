package com.practica_1.vista;

import com.practica_1.modelo.Departamento;
import com.practica_1.modelo.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class app_update {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("practica1");

    ;
    
    
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Departamento logistica = new Departamento(1, "area de logistica");
        Empleado sara = new Empleado(30, "sara", "jefe de logistica", "tiempo completo", logistica);
        Empleado andres = new Empleado(31, "andres", "auxiliar de logistica", "tiempo completo", logistica);

        logistica.addE(sara);
        logistica.addE(andres);

        em.persist(logistica);

        em.getTransaction().commit();
        em.close();

        contador();

        System.out.println("****** ACTUALIZACION********");
        //SEGUNDA TRANSACCION
        em = emf.createEntityManager();
        em.getTransaction().begin();

        sara.setNombre_empleado("candida");
        em.merge(logistica);

        em.getTransaction().commit();
        em.close();

        contador();

    }

    public static void contador() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Empleado> consultaEmpleado = (TypedQuery<Empleado>) em.createQuery("FROM Empleado", Empleado.class);
        
        for(Empleado empleado : consultaEmpleado.getResultList()){
            
            System.out.println("Empleado: " + empleado.getNombre_empleado() + ", cargo: " + empleado.getCargo());
            
        }

    }

}
