package com.electrika.tech.entidades;

import javax.swing.*;
import java.util.Date;

public class Distribuidor {
    private Integer idDistribuidor;
    private String ruc;
    private String nombre;
    private String direccion;
    private String telefono;

    public Distribuidor(Integer idDistribuidor, String ruc, String nombre, String direccion, String telefono) {
        this.idDistribuidor = idDistribuidor;
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Distribuidor() {
    }

    public Integer getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Integer idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre ;
    }

}
