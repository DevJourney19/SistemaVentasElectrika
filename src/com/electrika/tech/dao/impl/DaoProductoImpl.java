package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.DaoCategoria;
import com.electrika.tech.dao.DaoDistribuidor;
import com.electrika.tech.dao.DaoProducto;

import com.electrika.tech.entidades.Producto;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.electrika.tech.util.ConectaBD;

public class DaoProductoImpl implements DaoProducto {

    private ConectaBD con;
    private String mensaje;
    private DaoCategoria cat;
    private DaoDistribuidor dis;

    public DaoProductoImpl() {
        con = new ConectaBD();
        cat= new DaoCategoriaImpl();
        dis= new DaoDistribuidorImpl();
    }
    
    @Override
    public String getMessage() {
        return mensaje;
    }

    @Override
    public List<Producto> select() {
        List<Producto> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idProducto,")
                .append("nombreProducto,")
                .append("descripcionProducto,")
                .append("stock,")
                .append("precioUnidad,")
                .append("idCate,")
                .append("idDistribuidor")
                .append(" FROM Producto");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodProducto(rs.getInt(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setStock(rs.getInt(4));
                producto.setPrecioUnidad(rs.getDouble(5));
                Integer idCat= rs.getInt(6);
                Integer idDis= rs.getInt(7);
                producto.setCategoria(cat.get(idCat));
                producto.setDistribuidor(dis.get(idDis));
                
                lista.add(producto);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String insert(Producto categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Producto(")
                .append("nombreProducto,")
                .append("descripcionProducto,")
                .append("stock,")
                .append("precioUnidad,")
                .append("idCate,")
                .append("idDistribuidor")
                .append(") VALUES (?,?,?,?,?,?)");

        try (Connection c = con.getConexion()) {

            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNombreProducto());
            ps.setString(2, categoria.getDescripcionProducto());
            ps.setInt(3, categoria.getStock());
            ps.setDouble(4, categoria.getPrecioUnidad());
            ps.setInt(5, categoria.getCategoria().getIdCate());
            ps.setInt(6, categoria.getDistribuidor().getIdDistribuidor());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizo" : null;

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Producto categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Producto SET ")
                .append("nombreProducto = ?,")
                .append("descripcionProducto = ?,")
                .append("stock = ?,")
                .append("precioUnidad = ?,")
                .append("idCate = ?,")
                .append("idDistribuidor = ?")
                .append(" WHERE idProducto = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNombreProducto());
            ps.setString(2, categoria.getDescripcionProducto());
            ps.setInt(3, categoria.getStock());
            ps.setDouble(4, categoria.getPrecioUnidad());
            ps.setInt(5, categoria.getCategoria().getIdCate());
            ps.setInt(6, categoria.getDistribuidor().getIdDistribuidor());
            ps.setInt(7, categoria.getCodProducto());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : "Se actualizo";
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(Integer id) {
         StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Producto ")
                .append("WHERE idProducto = ?");
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
    public Producto get(Integer id) {
        Producto pro = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idProducto,")
                .append("nombreProducto,")
                .append("descripcionProducto,")
                .append("stock,")
                .append("precioUnidad,")
                .append("idCate,")
                .append("idDistribuidor")
                .append(" FROM Producto")
                .append(" WHERE idProducto =?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro= new Producto();
                pro.setCodProducto(rs.getInt(1));
                pro.setNombreProducto(rs.getString(2));
                pro.setDescripcionProducto(rs.getString(3));
                pro.setStock(rs.getInt(4));
                pro.setPrecioUnidad(rs.getDouble(5));
                Integer idCat= rs.getInt(6);
                Integer idDis= rs.getInt(7);
                pro.setCategoria(cat.get(idCat));
                pro.setDistribuidor(dis.get(idDis));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pro;
    }
    
    @Override
    public List<Object[]> verData() {
        List<Object[]> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("Codigo,")
                .append("Nombre,")
                .append("Descripcion,")
                .append("Stock,")
                .append("Precio,")
                .append("Categoria,")
                .append("Distribuidor")
                .append(" FROM productoView");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Object[] obj= new Object [7];
                obj[0]=rs.getInt(1);
                obj[1]=rs.getString(2);
                obj[2]=rs.getString(3);
                obj[3]=rs.getInt(4);
                obj[4]=rs.getDouble(5);
                obj[5]=rs.getString(6);
                obj[6]=rs.getString(7);
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
