package com.electrika.tech.entidades;

public class Vendedor extends Usuario{
    private String puestoArea;
    private String fechaIngreso;
    private String fechaSalida;
    private String usuario;
    private String password;

    public Vendedor(Integer codUsuario, String apellidoUsuario, String nombreUsuario, String usuario, String password, String puestoArea, String fechaIngreso, String fechaSalida) {
        super(codUsuario, apellidoUsuario, nombreUsuario);
        this.puestoArea = puestoArea;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.usuario = usuario;
        this.password = password;
    }

    public Vendedor() {
        super(null, null, null);
    }

    public String getPuestoArea() {
        return puestoArea;
    }

    public void setPuestoArea(String puestoArea) {
        this.puestoArea = puestoArea;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
