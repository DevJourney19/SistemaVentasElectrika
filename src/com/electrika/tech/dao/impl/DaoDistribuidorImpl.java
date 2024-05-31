package com.electrika.tech.dao.impl;

import com.electrika.tech.dao.DaoDistribuidor;
import com.electrika.tech.entidades.Distribuidor;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.electrika.tech.util.ConectaBD;
import com.electrika.tech.view.InterManageDistribuidor;

public class DaoDistribuidorImpl implements DaoDistribuidor {

    Integer valorzaso = null;
    String ruc = "";
    String nom = "";
    String dir = "";
    String tel = "";
    private ConectaBD con;
    private String mensaje;

    public DaoDistribuidorImpl() {
        con = ConectaBD.getInstance();
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
//    Integer valorzaso = null;

    @Override
    public List<Distribuidor> select() {
        List<Distribuidor> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idDistribuidor,")
                .append("ruc,")
                .append("nombre,")
                .append("direccion,")
                .append("telefono")
                .append(" FROM Distribuidor");
        //try con recursos para no usar el finally
        //lo va a cerrar funcione o falle
        try (Connection c = con.getConexion()) {
            //PreparedStatement limpia de inyecciones a la secuencia sql
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            //mientras exista un registro resultSet continúa

            while (rs.next()) {
                //Genera la ejecucion de cada distribuidor
                Distribuidor distribuidor = new Distribuidor();
                /*De la base de datos, se cambia el campo de idDistribuidor de la tabla*/
                distribuidor.setIdDistribuidor(rs.getInt(1));
                distribuidor.setRuc(rs.getString(2));
                distribuidor.setNombre(rs.getString(3));
                distribuidor.setDireccion(rs.getString(4));
                distribuidor.setTelefono(rs.getString(5));
                lista.add(distribuidor);
//                valorzaso = distribuidor.getIdDistribuidor();
//                JOptionPane.showMessageDialog(null, valorzaso);
            }
            //Obtengo el ultimo id
//            Integer seguimos = valorzaso;

//            System.out.println(seguimos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    /**
     * Lo que quiero hacer, es poder eliminar un elemento de la base de datos
     * pero cuando quiera volver a aparecer ese elemento aparezca con su id que
     * fue eliminado.
     *
     * @return
     */
    public Integer ultimoValor() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idDistribuidor")
                .append(" FROM Distribuidor");
        try (Connection c = con.getConexion()) {
            //PreparedStatement limpia de inyecciones a la secuencia sql
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();

            //mientras exista un registro resultSet continúa
            while (rs.next()) {
                //Genera la ejecucion de cada distribuidor
                Distribuidor distribuidor = new Distribuidor();
                /*De la base de datos, se cambia el campo de idDistribuidor de la tabla*/
                distribuidor.setIdDistribuidor(rs.getInt(1));
                valorzaso = distribuidor.getIdDistribuidor();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Obtengo el ultimo id
        return valorzaso;
    }

    @Override
    public String insert(Distribuidor distribuidor) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Distribuidor(")
                .append("ruc,")
                .append("nombre,")
                .append("direccion,")
                .append("telefono")
                .append(") VALUES (?,?,?,?)");

        try (Connection c = con.getConexion()) {

            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, distribuidor.getRuc());
            ps.setString(2, distribuidor.getNombre());
            ps.setString(3, distribuidor.getDireccion());
            ps.setString(4, distribuidor.getTelefono());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String update(Distribuidor distribuidor) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Distribuidor SET ")
                .append("ruc = ?,")
                .append("nombre = ?,")
                .append("direccion = ?,")
                .append("telefono = ?")
                .append(" WHERE idDistribuidor=?");

        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, distribuidor.getRuc());
            ps.setString(2, distribuidor.getNombre());
            ps.setString(3, distribuidor.getDireccion());
            ps.setString(4, distribuidor.getTelefono());
            ps.setInt(5, distribuidor.getIdDistribuidor());

            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Necesito hacer una función que detecte si la busqueda está vacía o si hay
     * un elemento. Entonces si necesito los valores nuevos
     */
    public Distribuidor recuperarDistribuidor(Integer id) {

        InterManageDistribuidor d = new InterManageDistribuidor();
        d.txtCode.getText();
        d.txtRuc.getText();
        d.txtName.getText();
        d.txtDirection.getText();
        d.txtPhone.getText();
        //----
        //Hola

        Distribuidor distribuidor = new Distribuidor(id, ruc, nom, dir, tel);

        return distribuidor;
    }

    @Override
    public String delete(Integer id) {
//        elementoEliminado = false;
//        Distribuidor distri = recuperarDistribuidor(id);

        StringBuilder sql = new StringBuilder();
//        elementoEliminado = true;
        sql.append("DELETE FROM Distribuidor ")
                .append("WHERE idDistribuidor = ?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            //Asignar al primer parametro los valores tipo int
            ps.setInt(1, id);

            mensaje = (ps.executeUpdate() == 0) ? "No se eliminó" : null;

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public Distribuidor get(Integer id) {
        Distribuidor distri = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idDistribuidor,")
                .append("ruc,")
                .append("nombre,")
                .append("direccion,")
                .append("telefono")
                .append(" FROM Distribuidor")
                .append(" WHERE idDistribuidor =?");
        try (Connection c = con.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                distri = new Distribuidor();
                distri.setIdDistribuidor(rs.getInt(1));
                distri.setRuc(rs.getString(2));
                distri.setNombre(rs.getString(3));
                distri.setDireccion(rs.getString(4));
                distri.setTelefono(rs.getString(5));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return distri;
    }
}
//    public void deshacer() {
//        System.out.println("");
//    }
//
//    //Llamadas a deshacer
//    public interface Accion {
//
//        void undo();
//    }
//
//    public String DeshacerUpdate(Distribuidor distribuidor) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("UPDATE Distribuidor SET ")
//                .append("ruc = ?,")
//                .append("nombre = ?,")
//                .append("direccion = ?,")
//                .append("telefono = ?")
//                .append(" WHERE idDistribuidor=?");
//
//        try (Connection c = con.getConexion()) {
//            PreparedStatement ps = c.prepareStatement(sql.toString());
//            ps.setString(1, distribuidor.getRuc());
//            ps.setString(2, distribuidor.getNombre());
//            ps.setString(3, distribuidor.getDireccion());
//            ps.setString(4, distribuidor.getTelefono());
//            ps.setInt(5, distribuidor.getIdDistribuidor());
//
//            mensaje = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return mensaje;
//    }
//
//    public String DeshacerDelete(Integer id) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("DELETE FROM Distribuidor ")
//                .append("WHERE idDistribuidor = ?");
//        try (Connection c = con.getConexion()) {
//            PreparedStatement ps = c.prepareStatement(sql.toString());
//            ps.setInt(1, id);
//            mensaje = (ps.executeUpdate() == 0) ? "No se eliminó" : null;
//        } catch (Exception e) {
//            mensaje = e.getMessage();
//        }
//        return mensaje;
//    }
//
//}

//    public Integer obtenerUltimoValor() {
//        Distribuidor di = new Distribuidor();
//        DaoDistribuidorImpl a = new DaoDistribuidorImpl();
//
//        return a.select().get(valorzaso).getIdDistribuidor();
//    }
//recuperarDistribuidor
//        StringBuilder recuperado = new StringBuilder();
////        recuperado.append("Select * from Distribuidor where idDistribuidor = ?");
//        recuperado.append("SELECT ")
//                .append("idDistribuidor,")
//                .append("ruc,")
//                .append("nombre,")
//                .append("direccion,")
//                .append("telefono")
//                .append(" FROM Distribuidor WHERE idDistribuidor = ?");
//
//        try (Connection c = con.getConexion()) {
//            //PreparedStatement limpia de inyecciones a la secuencia sql
//            PreparedStatement ps = c.prepareStatement(recuperado.toString());
//            ps.setInt(1, id);
//            //agarrar la consulta
//            ResultSet rs = ps.executeQuery();
//            //Si hubo una consulta entonces se ejecutará
//            if (elementoEliminado == false) {
//                if (rs.next()) {
//                    distribuidor = new Distribuidor();
//                    /*Estoy asignando ese valor desde la base de datos, ya que se 
//                cambia el campo de idDistribuidor de la tabla*/
//                    distribuidor.setIdDistribuidor(rs.getInt(1));
//                    distribuidor.setRuc(rs.getString(2));
//                    distribuidor.setNombre(rs.getString(3));
//                    distribuidor.setDireccion(rs.getString(4));
//                    distribuidor.setTelefono(rs.getString(5));
//
//                    valorzaso = distribuidor.getIdDistribuidor();
//                    ruc = distribuidor.getRuc();
//                    nom = distribuidor.getNombre();
//                    dir = distribuidor.getDireccion();
//                    tel = distribuidor.getTelefono();
//
//                } else {
//                    //Si no hay consultas
//                    JOptionPane.showMessageDialog(null, "NO HAY ELEMENTOS");
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Distribuidor distriDistri = new Distribuidor(id, ruc, nom, dir, tel);

