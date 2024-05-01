package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.DaoCliente;
import com.electrika.tech.entidades.Cliente;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.electrika.tech.util.ConectaBD;

public class DaoClienteImpl implements DaoCliente {

    private ConectaBD con;
    private String mensaje;

    public DaoClienteImpl() {
        con = new ConectaBD();
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

    @Override
    public List<Cliente> select() {
        List<Cliente> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idCliente,")
                .append("apellido,")
                .append("nombre,")
                .append("telefono,")
                .append("correo,")
                .append("dni")
                .append(" FROM Cliente");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodUsuario(rs.getInt(1));
                cliente.setApellidoUsuario(rs.getString(2));
                cliente.setNombreUsuario(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setCorreo(rs.getString(5));
                cliente.setDni(rs.getString(6));
                lista.add(cliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String insert(Cliente categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Cliente(")
                .append("apellido,")
                .append("nombre,")
                .append("telefono,")
                .append("correo,")
                .append("dni")
                .append(") VALUES (?,?,?,?,?)");

        try (Connection c = con.getConexion()) {

            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, categoria.getApellidoUsuario());
            ps.setString(2, categoria.getNombreUsuario());
            ps.setString(3, categoria.getTelefono());
            ps.setString(4, categoria.getCorreo());
            ps.setString(5, categoria.getDni());
            mensaje = (ps.executeUpdate() == 0) ? "No se actualizo" : null;

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Cliente categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Cliente SET ")
                .append("apellido = ?,")
                .append("nombre = ?,")
                .append("telefono = ?,")
                .append("correo = ?,")
                .append("dni = ?")
                .append(" WHERE idCliente = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNombreUsuario());
            ps.setString(2, categoria.getApellidoUsuario());
            ps.setString(3, categoria.getTelefono());
            ps.setString(4, categoria.getCorreo());
            ps.setString(5, categoria.getDni());
            ps.setInt(6, categoria.getCodUsuario());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Cliente ")
                .append("WHERE idCliente = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            mensaje = (ps.executeUpdate() == 0) ? "No se eliminó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public Cliente get(Integer id) {
        Cliente cli = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idCliente,")
                .append("apellido,")
                .append("nombre,")
                .append("telefono,")
                .append("correo,")
                .append("dni")
                .append(" FROM Cliente")
                .append(" WHERE idDistribuidor =?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                cli.setCodUsuario(rs.getInt(1));
                cli.setApellidoUsuario(rs.getString(2));
                cli.setNombreUsuario(rs.getString(3));
                cli.setTelefono(rs.getString(4));
                cli.setCorreo(rs.getString(5));
                cli.setDni(rs.getString(6));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cli;
    }
}
