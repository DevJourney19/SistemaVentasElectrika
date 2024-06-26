package com.electrika.tech.entidades;
//

public class Producto{
   //atributos
    private Integer codProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Integer stock;
    private Double precioUnidad;
    private Categoria categoria;
    private Distribuidor distribuidor;

    public Producto() {
    }

    public Producto(Integer codProducto, String nombreProducto, String descripcionProducto, Integer stock, Double precioUnidad, Categoria categoria, Distribuidor distribuidor) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.stock = stock;
        this.precioUnidad = precioUnidad;
        this.categoria = categoria;
        this.distribuidor = distribuidor;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }
    
    

    @Override
    public String toString() {
        return codProducto.toString();
    }

    
    
    


    

}

