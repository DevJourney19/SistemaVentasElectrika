
package com.electrika.tech.entidades;


public class Categoria {
   
    private Integer idCate;
    private String nombre;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(Integer idCate, String nombre, String descripcion) {
        this.idCate = idCate;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdCate() {
        return idCate;
    }

    public void setId(Integer idCate) {
        this.idCate = idCate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
