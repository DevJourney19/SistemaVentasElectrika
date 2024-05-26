package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.DaoDetallePedido;
import com.electrika.tech.dao.DaoPedido;
import com.electrika.tech.dao.DaoProducto;
import static com.electrika.tech.dao.impl.DaoPedidoImpl.idPed;

import com.electrika.tech.entidades.DetallePedido;
import com.electrika.tech.entidades.Producto;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.electrika.tech.util.ConectaBD;
import java.util.Stack;

public class DaoDetallePedImpl implements DaoDetallePedido {

    private ConectaBD con;
    private String mensaje;
    private DaoProducto pro;
    private DaoPedido ped;
    private List<DetallePedido> detallePedidos;
    public static Integer idDet;

    public DaoDetallePedImpl() {
        con = new ConectaBD();
        pro = new DaoProductoImpl();
        ped = new DaoPedidoImpl();
        detallePedidos = new ArrayList<>();
    }

    @Override
    public String getMessage() {
        return mensaje;

    }

    @Override
    public List<DetallePedido> select() {
        List<DetallePedido> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("cantidadProducto,")
                .append("subtotal,")
                .append("idDetallePedido,")
                .append("idPedido,")
                .append("idProducto")
                .append(" FROM DetallePedido");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setCantidadProducto(rs.getInt(1));
                detallePedido.setPagar(rs.getDouble(2));
                detallePedido.setIdDetallePedi(rs.getInt(3));
                Integer idProd = rs.getInt(5);
                detallePedido.setIdPedi(rs.getInt(4));
                detallePedido.setProducto(pro.get(idProd));

                lista.add(detallePedido);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String insert(DetallePedido categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO DetallePedido(")
                .append("cantidadProducto,")
                .append("subtotal,")
                .append("idPedido,")
                .append("idProducto")
                .append(") VALUES (?,?,?,?)");

        try (Connection c = con.getConexion()) {

            PreparedStatement ps = c.prepareStatement(sql.toString(), java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, (categoria.getCantidadProducto()));
            ps.setDouble(2, categoria.getPagar());
            ps.setInt(3, categoria.getIdPedi());
            ps.setInt(4, categoria.getProducto().getCodProducto());
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idDet = generatedKeys.getInt(1);
                        mensaje = "Se insertó correctamente con ID: " + idDet;
                        categoria.setIdDetallePedi(idDet);
                        detallePedidos.add(categoria);
                    }
                }
            } else {
                mensaje = "No se insertó";
            }
//            mensaje = (ps.executeUpdate() == 0) ? "No se inserto" : "Se inserto correctamente";

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public void obtenerId(Integer idGenerado) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT ")
//                .append("idDetallePedido")
//                .append(" FROM DetallePedido")
//                .append(" WHERE idDetallePedido = ?");
//        try (Connection c = con.getConexion()) {
//            PreparedStatement ps = c.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
//            // Resto del código de inserción
//            ps.executeUpdate();
//
//            // Obtener el ID generado automáticamente
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                ped.setIdPedido(rs.getInt(1));
//            }
//
//            // Resto del código
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
    }

    @Override
    public String update(DetallePedido categoria
    ) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE DetallePedido SET ")
                .append("cantidadProducto = ?,")
                .append("subtotal = ?,")
                .append("idPedido = ?,")
                .append("idProducto = ?")
                .append(" WHERE idDetallePedido = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, categoria.getCantidadProducto());
            ps.setDouble(2, categoria.getPagar());
            ps.setInt(3, categoria.getIdDetallePedi());
            ps.setInt(4, categoria.getProducto().getCodProducto());
            ps.setInt(5, categoria.getIdDetallePedi());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(Integer id
    ) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM DetallePedido ")
                .append("WHERE idDetallePedido = ?");
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
    public DetallePedido get(Integer id
    ) {
        DetallePedido det = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idDetallePedido,")
                .append("idPedido,")
                .append("idProducto,")
                .append("cantidadProducto,")
                .append("subtotal")
                .append(" FROM DetallePedido");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                det = new DetallePedido();
                det.setIdDetallePedi(rs.getInt(1));
                det.setIdPedi(rs.getInt(2));
                Integer idProdu = rs.getInt(3);
                det.setProducto(pro.get(idProdu));
                det.setCantidadProducto(4);
                det.setPagar(rs.getDouble(5));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return det;
    }

    @Override
    public List<Object[]> verData() {
        List<Object[]> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idDetallePedido,")
                .append("idProducto,")
                .append("nombreProducto,")
                .append("nombreCategoria,")
                .append("cantidad,")
                .append("precioUnidad,")
                .append("subtotal")
                .append(" FROM detallePedidoview");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();

            while (rs.next()) {
                Object[] obj = new Object[7];
                obj[0] = rs.getInt(1);
                obj[1] = rs.getInt(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getInt(5);
                obj[5] = rs.getDouble(6);
                obj[6] = rs.getDouble(7);
                lista.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String actualizarPedido(Integer idDet) {
        StringBuilder sql = new StringBuilder();
        Integer idPedido = idPed;
        sql.append("UPDATE DetallePedido SET ")
                .append("idPedido = ? ")
                .append("WHERE idDetallePedido = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, idPedido);
            ps.setInt(2, idDet);

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : "Se actualizo el id";
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public List<DetallePedido> seleccionarMemoria() {
        return detallePedidos;
    }

    @Override
    public void eliminarMemoria() {
        detallePedidos.clear();
        detallePedidos = new ArrayList<>();
    }

    @Override
    public List<Object[]> obtenerProductos(Integer idPed) {
        List<Object[]> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("cantidadProducto,")
                .append("nombreProducto,")
                .append("precioUnidad,")
                .append("subtotal")
                .append(" FROM DetallePedido")
                .append(" INNER JOIN Producto ON Producto.idProducto = DetallePedido.idProducto")
                .append(" WHERE idPedido = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, idPed);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Object[] obj = new Object[4];
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getDouble(3);
                obj[3] = rs.getDouble(4);
                lista.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
