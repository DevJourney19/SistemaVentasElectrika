package com.electrika.tech.entidades;


public class DetallePedido {

    //Atributos del detalle del pedido
    private Integer idDetallePedi;
    private Integer idPedi;
    private Producto producto;
    private Integer cantidadProducto;
    private Double pagar;
    //método constructor sin parámetros
    public DetallePedido() {
    }

    //método constructor con parámetros

    public DetallePedido(Integer idDetallePedi, Integer idPedi, Producto producto, Integer cantidadProducto, Double pagar) {
        this.idDetallePedi = idDetallePedi;
        this.idPedi = idPedi;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.pagar = pagar;
    }

    public Integer getIdDetallePedi() {
        return idDetallePedi;
    }

    public void setIdDetallePedi(Integer idDetallePedi) {
        this.idDetallePedi = idDetallePedi;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getPagar() {
        return pagar;
    }

    public void setPagar(Double pagar) {
        this.pagar = pagar;
    }

    public Integer getIdPedi() {
        return idPedi;
    }

    public void setIdPedi(Integer idPedi) {
        this.idPedi = idPedi;
    }
    
}
