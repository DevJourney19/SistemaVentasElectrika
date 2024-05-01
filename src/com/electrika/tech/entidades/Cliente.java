package com.electrika.tech.entidades;


public class Cliente extends Usuario{
    private String telefono;
    private String correo;
    private String dni;

    public Cliente() {
        super(null, null, null);
    }

    public Cliente(Integer codUsuario, String apellidoUsuario, String nombreUsuario, String dni, String telefono, String correo) {
        super(codUsuario, apellidoUsuario, nombreUsuario);
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
    }

    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}