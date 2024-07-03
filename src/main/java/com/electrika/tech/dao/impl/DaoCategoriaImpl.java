package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.DaoCategoria;
import com.electrika.tech.entidades.Categoria;
import com.electrika.tech.entidades.Distribuidor;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.electrika.tech.util.ConectaBD;

public class DaoCategoriaImpl implements DaoCategoria {

    private ConectaBD con;
    private String mensaje;

    public DaoCategoriaImpl() {
        con = new ConectaBD();
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

    @Override
    public List<Categoria> select() {
        List<Categoria> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idCate,")
                .append("nombre,")
                .append("descripcion")
                .append(" FROM Categoria");
        //try con recursos para no usar el finally
        //lo va a cerrar funcione o falle
        //PreparedStatement limpia de inyecciones a la secuencia sql
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            //mientras exista un registro resultSet continúa
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
                lista.add(categoria);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String insert(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Categoria(")
                .append("nombre,")
                .append("descripcion")
                .append(") VALUES (?,?)");

        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            mensaje = (ps.executeUpdate() == 0) ? "No se actualizo" : null;

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Categoria SET ")
                .append("nombre = ?,")
                .append("descripcion = ?")
                .append(" WHERE idCate = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdCate());
            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

//    Recursos c y ps
    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Categoria ")
                .append("WHERE idCate = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            mensaje = (ps.executeUpdate() == 0) ? "No se eliminó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public Categoria get(Integer id) {
        Categoria cat = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idCate,")
                .append("nombre,")
                .append("descripcion")
                .append(" FROM Categoria")
                .append(" WHERE idCate =?");
        try (Connection c = con.getConexion();
            PreparedStatement ps = c.prepareStatement(sql.toString()); ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cat = new Categoria();
                    cat.setId(rs.getInt(1));
                    cat.setNombre(rs.getString(2));
                    cat.setDescripcion(rs.getString(3));
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cat;
    }

}
