package com.practica_1.vista;

import com.practica_1.modelo.Departamento;
import com.practica_1.modelo.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class app_find {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("practica1");
        em = emf.createEntityManager();

        agregar();
        
        em.getTransaction().begin();
        
        Empleado busqueda = em.find(Empleado.class, 91);
        System.out.println("empleado encontrado: " + busqueda.getNombre_empleado() + ", cargo: " + busqueda.getCargo());
        
        em.getTransaction().commit();
        em.close();
        
    }

    public static void agregar() {

        em.getTransaction().begin();
        
        Departamento sistemas = new Departamento(1, "area de sistemas");
        Departamento auditoria = new Departamento(2, "Auditoria");
        
        Empleado isabella = new Empleado(90, "isabella", "ingeriera", "tiempo completo", sistemas);
        Empleado liliana = new Empleado(91, "liliana", "auditora", "tiempo completo", auditoria);
        
        sistemas.addE(isabella);
        auditoria.addE(liliana);
        
        em.persist(sistemas);
        em.persist(auditoria);
        
        em.getTransaction().commit();
        

    }

}
