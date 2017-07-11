package com.practica_1.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Id
    private int codigo_empleado;

    @Column(name = "nombre_empleado")
    private String nombre_empleado;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "dedicacion")
    private String dedicacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_codigo_departamento")
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(int codigo_empleado, String nombre_empleado, String cargo, String dedicacion, Departamento departamento) {
        this.codigo_empleado = codigo_empleado;
        this.nombre_empleado = nombre_empleado;
        this.cargo = cargo;
        this.dedicacion = dedicacion;
        this.departamento = departamento;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codigo_empleado;
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
        final Empleado other = (Empleado) obj;
        if (this.codigo_empleado != other.codigo_empleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo_empleado=" + codigo_empleado + ", nombre_empleado=" + nombre_empleado + ", cargo=" + cargo + ", dedicacion=" + dedicacion + ", departamento=" + departamento + '}';
    }

}
