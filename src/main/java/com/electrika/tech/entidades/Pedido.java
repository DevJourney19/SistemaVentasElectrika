package com.electrika.tech.entidades;

import java.util.List;


public class Pedido {

    //Atributos del pedido
    private Integer idPedido;   
    private String descripcionPedido;
    private String fechaPedido;  
    private Cliente cliente;
    private String MetodoPago;
    private List<DetallePedido> detallePedido;
    private Double precioTotal;
    private Vendedor vendedor;

    public Pedido() {
    }

    public Pedido(Integer idPedido, String descripcionPedido, String fechaPedido, Cliente cliente, String MetodoPago, List<DetallePedido> detallePedido, Double precioTotal, Vendedor vendedor) {
        this.idPedido = idPedido;
        this.descripcionPedido = descripcionPedido;
        this.fechaPedido = fechaPedido;
        this.cliente = cliente;
        this.MetodoPago = MetodoPago;
        this.detallePedido = detallePedido;
        this.precioTotal = precioTotal;
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

   

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", descripcionPedido=" + descripcionPedido + ", fechaPedido=" + fechaPedido + ", precioTotal=" + precioTotal + ", MetodoPago=" + MetodoPago + ", detallePedido=" + detallePedido + '}';
    }

    
    
}
