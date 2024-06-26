package com.electrika.tech.entidades;

public abstract class Usuario {
    private Integer codUsuario;
    private String apellidoUsuario;
    private String nombreUsuario;

    public Usuario(Integer codUsuario, String apellidoUsuario, String nombreUsuario) {
        this.codUsuario = codUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}

