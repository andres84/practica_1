package com.practica_1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    @Id
    private int codigo_departamento;

    @Column(name = "nombre_departamento")
    private String nombre_departamento;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)//orphanRemoval: indica que cuando se borre algun departamento debe ser borrado el empleado de este
    List<Empleado> empleados = new ArrayList<>();

    //se añaden empleados a departamento
    public void addE(Empleado e){
        
        empleados.add(e);
        e.setDepartamento(this);
        
    }
    
    //eliminar departamentos y empleados
    public void removeED(Empleado e){
        
        empleados.remove(e);
        e.setDepartamento(null);
        
    }
    
    public Departamento() {
    }

    public Departamento(int codigo_departamento, String nombre_departamento) {
        this.codigo_departamento = codigo_departamento;
        this.nombre_departamento = nombre_departamento;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo_departamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (this.codigo_departamento != other.codigo_departamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo_departamento=" + codigo_departamento + ", nombre_departamento=" + nombre_departamento + ", empleados=" + empleados + '}';
    }

}
