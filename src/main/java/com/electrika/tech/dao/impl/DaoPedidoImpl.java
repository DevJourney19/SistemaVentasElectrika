package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.*;
import com.electrika.tech.entidades.Cliente;
import com.electrika.tech.entidades.Pedido;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.electrika.tech.util.ConectaBD;

public class DaoPedidoImpl implements DaoPedido {

    private ConectaBD con;
    private String mensaje;
    private DaoCliente cli;
    private DaoVendedor ve;
    public static Integer idPed;

    public DaoPedidoImpl() {
        con = new ConectaBD();
        cli = new DaoClienteImpl();
        ve = new DaoVendedorImpl();
    }

    @Override
    public String getMessage() {
        return mensaje;

    }

    @Override
    public List<Pedido> select() {
        List<Pedido> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idPedido,")
                .append("descripcionPedido,")
                .append("fechaPedido,")
                .append("metodoPago,")
                .append("precioTotal")
                .append("idCliente,")
                .append("idVendedor")
                .append(" FROM Pedido");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setDescripcionPedido(rs.getString(2));
                pedido.setFechaPedido(rs.getString(3));
                pedido.setMetodoPago(rs.getString(4));
                pedido.setPrecioTotal(rs.getDouble(5));
                Integer idCli = rs.getInt(6);
                Integer idVen = rs.getInt(7);
                pedido.setCliente(cli.get(idCli));
                pedido.setVendedor(ve.get(idVen));

                /*nose se agregatambien las llabves foraneas?*/
                lista.add(pedido);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public String insert(Pedido categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Pedido(")
                .append("descripcionPedido,")
                .append("fechaPedido,")
                .append("metodoPago,")
                .append("precioTotal,")
                .append("idCliente,")
                .append("idVendedor")
                .append(") VALUES (?,?,?,?,?,?)");

        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString(), java.sql.Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, categoria.getDescripcionPedido());
            ps.setString(2, categoria.getFechaPedido());
            ps.setString(3, categoria.getMetodoPago());
            ps.setDouble(4, categoria.getPrecioTotal());
            ps.setDouble(5, categoria.getCliente().getCodUsuario());
            ps.setDouble(6, categoria.getVendedor().getCodUsuario());

            // Ejecutar la inserción y obtener las claves generadas automáticamente
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idPed = generatedKeys.getInt(1);
                    }
                }
            }
            mensaje = "Se insertó correctamente con ID: " + idPed;
        } catch (Exception e) {
            mensaje = "Error al insertar: " + e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Pedido categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Pedido SET ")
                .append("descripcionPedido = ?,")
                .append("fechaPedido = ?,")
                .append("metodoPago = ?,")
                .append("precioTotal = ?,")
                .append("idCliente = ?,")
                .append("idVendedor = ?")
                .append(" WHERE idPedido = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, categoria.getDescripcionPedido());
            ps.setString(2, categoria.getFechaPedido());
            ps.setString(3, categoria.getMetodoPago());
            ps.setDouble(4, categoria.getPrecioTotal());
            ps.setInt(5, categoria.getCliente().getCodUsuario());
            ps.setInt(6, categoria.getVendedor().getCodUsuario());
            ps.setInt(7, categoria.getIdPedido());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Pedido ")
                .append("WHERE idPedido = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            mensaje = (ps.executeUpdate() == 0) ? "No se eliminó" : "Se elimino correctamente";
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public Pedido get(Integer id) {
        Pedido ped = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idPedido,")
                .append("descripcionPedido,")
                .append("fechaPedido,")
                .append("metodoPago,")
                .append("precioTotal,")
                .append("idCliente,")
                .append("idVendedor")
                .append(" FROM Pedido")
                .append(" WHERE idPedido = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ped = new Pedido();
                    ped.setIdPedido(rs.getInt(1));
                    ped.setDescripcionPedido(rs.getString(2));
                    ped.setFechaPedido(rs.getString(3));
                    ped.setMetodoPago(rs.getString(4));
                    ped.setPrecioTotal(rs.getDouble(5));
                    Integer idCli = rs.getInt(6);
                    Integer idVen = rs.getInt(7);
                    ped.setCliente(cli.get(idCli));
                    ped.setVendedor(ve.get(idVen));
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return ped;
    }

    @Override
    public List<Object[]> verData() {
        List<Object[]> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idPedido,")
                .append("Vendedor,")
                .append("Cliente,")
                .append("descripcionPedido,")
                .append("metodoPago,")
                .append("fechaPedido,")
                .append("precioTotal")
                .append(" FROM pedidoView");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();

            while (rs.next()) {
                Object[] obj = new Object[7];
                obj[0] = rs.getInt(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getString(5);
                obj[5] = rs.getString(6);
                obj[6] = rs.getDouble(7);
                lista.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente dataCliente(Integer idPed) {
        Cliente cli = new Cliente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("apellido,")
                .append("nombre,")
                .append("telefono,")
                .append("correo,")
                .append("dni")
                .append(" FROM Pedido")
                .append(" INNER JOIN Cliente ON Pedido.idCliente = Cliente.idCliente")
                .append(" WHERE idPedido = ?");
        try (Connection c = con.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, idPed);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cli.setApellidoUsuario(rs.getString(1));
                    cli.setNombreUsuario(rs.getString(2));
                    cli.setTelefono(rs.getString(3));
                    cli.setCorreo(rs.getString(4));
                    cli.setDni(rs.getString(5));
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cli;
    }

}
