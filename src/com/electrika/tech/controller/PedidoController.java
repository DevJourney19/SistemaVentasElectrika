package com.electrika.tech.controller;

import com.electrika.tech.dao.*;
import com.electrika.tech.dao.impl.*;
import com.electrika.tech.entidades.*;
import com.electrika.tech.view.InterPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PedidoController implements ActionListener {

    Double resulPagar;
    DaoPedido pedi;
    DaoCliente clie;
    DaoDetallePedido detaPedi;
    DaoProducto pro;
    DefaultTableModel modelo;
    DefaultTableModel modelaso;
    private InterPedido view;

    public PedidoController(InterPedido view) {
        this.view = view;
        pedi = new DaoPedidoImpl();
        detaPedi = new DaoDetallePedImpl();
        clie = new DaoClienteImpl();
        pro = new DaoProductoImpl();
        modelo = (DefaultTableModel) view.tablaDP.getModel();
        modelaso = (DefaultTableModel) view.tablita.getModel();

        //Pedido
        modelaso.addColumn("IdPedido");
        modelaso.addColumn("Vendedor");
        modelaso.addColumn("Cliente");
        modelaso.addColumn("descripcionPedido");
        modelaso.addColumn("metodoPago");
        modelaso.addColumn("fechaPedido");
        modelaso.addColumn("precioTotal");

        //Detalle de Pedido
        modelo.addColumn("idDetalle");
        modelo.addColumn("codigoProducto");
        modelo.addColumn("Producto");
        modelo.addColumn("Categoria");
        modelo.addColumn("cantidadProducto");
        modelo.addColumn("precioUnidad");
        modelo.addColumn("subTotal");

        view.setTitle("Pedido");
        view.tablaDP.setModel(modelo); //DP
        view.tablita.setModel(modelaso); //P

        view.txtFecha.setText(fechaActual());
        view.txtNombreVendedor.setText(HomeViewController.vendedor.getNombreUsuario());

        for (Cliente cliente : clie.select()) {
            view.cbCliente.addItem(cliente.getNombreUsuario());
        }
        for (Producto prod : pro.select()) {
            view.cbProducto.addItem(prod.getNombreProducto());
        }
        listado();
        agregarEventos();
    }

    //============================//
    private void agregarEventos() {
        view.btnAgregar.addActionListener(this);
        view.btnAgregar1.addActionListener(this);
        view.btnBuscar1.addActionListener(this);
        view.btnEditar.addActionListener(this);
        view.btnEliminar.addActionListener(this);
        view.btnEliminar1.addActionListener(this);
        view.btnRegistrar.addActionListener(this);
        view.cbProducto.addActionListener(this);
        view.btnGuardar.addActionListener(this);

        view.txtIdDetallePedi.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Devolver el mismo texto si es nulo o vacío
        }

        // Convertir la primera letra a mayúscula y concatenar el resto del texto
        return String.format("%s%s", input.substring(0, 1).toUpperCase(), input.substring(1).toLowerCase());

    }

    public void listado() {
        modelaso.setNumRows(0);
        view.tablita.clearSelection();
        view.txtDescripcion.setText(null);
        view.cbMetodoPago.setSelectedItem("<Seleccionar>");
        view.cbCliente.setSelectedItem("<Seleccionar>");
        view.txtTotal.setText("");
        for (Object[] fila : pedi.verData()) {
            modelaso.addRow(fila);
        }
    }

    public void listado2() {
        modelo.setNumRows(0);
        view.tablaDP.clearSelection();
        view.txtIdDetallePedi.setText("");
        view.cbProducto.setSelectedIndex(0);
        view.txtStock.setText("");
        view.txtPrecio.setText("");
        view.cbMetodoPago.setSelectedItem("<Escoger Producto>");
        for (DetallePedido fila : detaPedi.seleccionarMemoria()) {
            Object[] obj = new Object[7];
            obj[0] = fila.getIdDetallePedi();
            obj[1] = fila.getProducto().getCodProducto();
            obj[2] = fila.getProducto().getNombreProducto();
            obj[3] = fila.getProducto().getCategoria().getNombre();
            obj[4] = fila.getCantidadProducto();
            obj[5] = fila.getProducto().getPrecioUnidad();
            obj[6] = fila.getPagar();
            modelo.addRow(obj);
        }
    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

        return formatoFecha.format(fecha);
    }

    private void habilitar(boolean opc) {
        view.txtDescripcion.setEnabled(opc);
        view.cbMetodoPago.setEnabled(opc);
        view.cbCliente.setEnabled(opc);
    }

    private void habilitar2(boolean opc) {
        view.cbProducto.setEnabled(opc);
        view.spinCantidad.setEnabled(opc);
    }

    private void eliminar() {
        Integer fila = view.tablita.getSelectedRow();
        if (view.tablita.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            view.btnAgregar.setEnabled(false);

            view.txtDescripcion.setText(view.tablita.getValueAt(fila, 3).toString());
            view.cbCliente.setSelectedItem(view.tablita.getValueAt(fila, 2).toString());
            view.cbMetodoPago.setSelectedItem(view.tablita.getValueAt(fila, 4).toString());
            view.txtFecha.setText(view.tablita.getValueAt(fila, 5).toString());

            Integer op = JOptionPane.showConfirmDialog(null, "Deseas eliminar este pedido?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {

                if (!(view.tablita.getRowCount() > 0)) {
                    view.btnAgregar.setEnabled(true);
                    view.btnEliminar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null,
                            pedi.delete(Integer.valueOf(view.tablita.getValueAt(fila, 0).toString())));
                    listado();
                }
            } else {
                view.txtDescripcion.setText(null);
                view.cbMetodoPago.setSelectedIndex(0);
                view.txtFecha.setText(fechaActual());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }
    }

    private void agregar() {
        habilitar(true);
        view.btnEliminar.setEnabled(false);
        view.btnAgregar1.setEnabled(true);
        view.btnRegistrar.setEnabled(true);
    }

    private void guardar() {
        if (!(view.txtDescripcion.getText().equals("")) && !(view.cbMetodoPago.getSelectedItem().toString().equals("")) && view.txtTotal.getText().equals("") && !(view.cbCliente.getSelectedItem().toString().equals(""))) {
            JOptionPane.showMessageDialog(null, "Registre sus detalles de pedidos");
            listado();
        } else {
            boolean bool = view.txtDescripcion.getText().equals("") || view.cbMetodoPago.getSelectedItem().equals("<Seleccionar>") || view.txtTotal.getText().equals("");
            if (bool) {
                JOptionPane.showMessageDialog(null, "Ingrese los campos de pedido");
                listado();
            } else {
                Cliente cliSeleccionado = null;
                for (Cliente cl : clie.select()) {
                    if (cl.getNombreUsuario().equals(view.cbCliente.getSelectedItem().toString())) {
                        cliSeleccionado = cl;
                        break;
                    }
                }
                String descri = view.txtDescripcion.getText();
                String meto = view.cbMetodoPago.getSelectedItem().toString();
                String fechita = view.txtFecha.getText();
                Pedido ped;
                JOptionPane.showMessageDialog(null,
                        pedi.insert(ped = new Pedido(null, descri, fechita, cliSeleccionado, meto, detaPedi.select(), Double.valueOf(view.txtTotal.getText()), HomeViewController.vendedor)));
                listado();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    Integer idDeta = Integer.valueOf(view.tablaDP.getValueAt(i, 0).toString());
                    detaPedi.actualizarPedido(idDeta);
                }
                view.btnEliminar.setEnabled(true);
                view.btnRegistrar.setEnabled(false);
                view.btnAgregar1.setEnabled(false);
                view.btnEliminar.setEnabled(true);
                habilitar(false);
                modelo.setNumRows(0);
                detaPedi.eliminarMemoria();
                listado2();
                view.btnAgregar.setEnabled(true);
                view.btnGuardar.setEnabled(false);
            }
        }
    }

    private void eliminar1() {
        Integer fila = view.tablaDP.getSelectedRow();
        if (view.tablaDP.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.txtIdDetallePedi.setText(view.tablaDP.getValueAt(fila, 0).toString());
            view.cbProducto.setSelectedItem(view.tablaDP.getValueAt(fila, 2).toString());
            view.txtCategoria.setText(view.tablaDP.getValueAt(fila, 3).toString());

            Integer op = JOptionPane.showConfirmDialog(null, "Deseas eliminar este pedido?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                //Creamos el objeto
                Producto p = pro.get(Integer.valueOf(view.tablaDP.getValueAt(fila, 1).toString()));

                //AUMENTO DEL STOCK DEL PRODUCTO
                Integer cantidadStock = Integer.valueOf(view.txtStock.getText());
                Integer cantidad = Integer.valueOf(view.tablaDP.getValueAt(fila, 4).toString());
                cantidadStock += cantidad;
                pro.update(new Producto(p.getCodProducto(), p.getNombreProducto(), p.getDescripcionProducto(), cantidadStock, p.getPrecioUnidad(), p.getCategoria(), null));

                Integer id = Integer.valueOf(view.txtIdDetallePedi.getText());
                detaPedi.delete(id);
                listado2();
                habilitar2(false);
                view.btnAgregar.setEnabled(true);
                view.btnEditar.setEnabled(true);
            } else {
                habilitar2(false);
                view.txtIdDetallePedi.setText(null);
                view.cbProducto.setSelectedIndex(0);
                view.txtCategoria.setText(null);
                view.btnAgregar.setEnabled(true);
                view.btnEditar.setEnabled(true);
                listado2();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
            listado2();
        }
    }

    private void editar() {
        view.txtIdDetallePedi.setEnabled(true);
        view.btnBuscar1.setEnabled(true);
        view.btnAgregar1.setEnabled(false);
        view.btnEliminar1.setEnabled(false);

        if (view.txtIdDetallePedi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un id y buscarlo");
            listado2();
        } else {

            habilitar2(true);
            Integer cantidad = Integer.valueOf(view.spinCantidad.getValue().toString());
            Integer stock = Integer.valueOf(view.txtStock.getText());
            if (stock == 0) {
                JOptionPane.showMessageDialog(null, "Stock vacío");
            } else if (cantidad > stock) { //2 > 10= total =12
                JOptionPane.showMessageDialog(null, "Stock insuficiente");
            } else {
                Integer id = Integer.valueOf(view.txtIdDetallePedi.getText());
                Producto productoSeleccionado = null;
                for (Producto producto : pro.select()) {
                    if (producto.getNombreProducto().equals(view.cbProducto.getSelectedItem())) {
                        productoSeleccionado = producto;
                        break;
                    }
                }
                Double precioProdu = productoSeleccionado.getPrecioUnidad(); //info del producto
                stock = stock - cantidad;
                resulPagar = cantidad * precioProdu;
                JOptionPane.showMessageDialog(null,
                        detaPedi.update(new DetallePedido(id, null, productoSeleccionado, cantidad, resulPagar)));
                listado2();
                resulPagar = 0.0;
                habilitar2(false);
                view.txtIdDetallePedi.setEnabled(false);
                view.btnAgregar1.setEnabled(true);
                view.btnEliminar1.setEnabled(true);
            }
        }
    }

    private void agregar1() {
        habilitar2(true);
        view.btnEliminar.setEnabled(false);
        view.btnEditar.setEnabled(false);
        view.cbProducto.setEnabled(true);
        view.spinCantidad.setEnabled(true);
        view.btnAgregar.setEnabled(false);

        boolean bool = view.cbProducto.getSelectedItem().equals("<Elegir producto>") || view.txtStock.getText().equals("") || view.txtPrecio.getText().equals("");
        if (bool) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto", "CÓDIGO EN BLANCO", HEIGHT);
        } else {
            Integer canti = Integer.valueOf(view.spinCantidad.getValue().toString());
            Double precioProdu = Double.valueOf(view.txtPrecio.getText());
            String producto = view.cbProducto.getSelectedItem().toString();

            //Creamos el objeto
            Producto p = null;
            for (Producto prod : pro.select()) {
                if (prod.getNombreProducto().equals(producto)) {
                    p = prod;
                    break;
                }
            }
            Integer cantidadStock = Integer.valueOf(view.txtStock.getText());
            if (cantidadStock > 0) {
                if (cantidadStock >= canti) {
                    cantidadStock = cantidadStock - canti;
                    String textoCantidad = String.valueOf(cantidadStock);
                    view.txtStock.setText(textoCantidad);
                    //==========================================================
                    //UPDATE EL PRODUCTO CON TAL CODIGO
                    JOptionPane.showMessageDialog(null,
                            pro.update(new Producto(p.getCodProducto(), p.getNombreProducto(), p.getDescripcionProducto(), cantidadStock, p.getPrecioUnidad(), p.getCategoria(), p.getDistribuidor())));
                    resulPagar = canti * precioProdu;
                    //suma += resulPagar; //Y esta suma va para PedidoFrame
                    JOptionPane.showMessageDialog(null,
                            detaPedi.insert(new DetallePedido(null, 0, p, canti, resulPagar)));
                    habilitar2(false);
                    view.btnEditar.setEnabled(true);
                    view.btnEliminar1.setEnabled(true);
                    listado2();
                    view.btnRegistrar.setEnabled(true);
                    resulPagar = 0.0;

                } else {
                    JOptionPane.showMessageDialog(null, "Stock insuficiente");
                }
            } else if (cantidadStock == 0) {
                JOptionPane.showMessageDialog(null, "No hay suficiente Stock");
                view.cbProducto.setSelectedItem("<Elegir Producto>");
                view.txtIdDetallePedi.setText(null);
                view.btnEditar.setEnabled(true);
                view.btnEliminar.setEnabled(true);
            }
        }
    }

    private void cbProducto() {
        if (view.cbProducto.getSelectedItem().equals("<Elegir Producto>")) {
            view.txtStock.setText("");
            view.txtCategoria.setText("");
            view.txtPrecio.setText("");
            view.spinCantidad.setValue(1);
            view.spinCantidad.setEnabled(false);
        } else {
            view.spinCantidad.setEnabled(true);
            Producto p2 = null;
            for (Producto p : pro.select()) {
                if (p.getNombreProducto().equals(view.cbProducto.getSelectedItem().toString())) {
                    p2 = p;
                    break;
                }
            }
            view.txtCategoria.setText(p2.getCategoria().getNombre());
            view.txtPrecio.setText(p2.getPrecioUnidad().toString());
            view.txtStock.setText(p2.getStock().toString());
        }
    }

    private void buscar1() {
        Integer id = Integer.valueOf(view.txtIdDetallePedi.getText());
        if (view.txtIdDetallePedi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresa un Id");
            //Si el id de la clase detalle, está en la tabla
        } else if (detaPedi.get(id) != null) {
            habilitar2(true);
            //Lo que está en la línea de esa tabla, nos guiamos por medio del id de detalle de pedido que está mostrada en la tabla
            DetallePedido det = detaPedi.get(id);
            //Por medio de ese codigo, ejem: nuestro codigo 1 va a ir a la tabla
            view.cbProducto.setSelectedItem(det.getProducto().getNombreProducto());
            view.txtCategoria.setText(det.getProducto().getCategoria().getNombre());
            view.txtPrecio.setText(det.getProducto().getPrecioUnidad().toString());
            view.txtStock.setText(det.getProducto().getStock().toString());
            view.spinCantidad.setValue(det.getCantidadProducto());

        } else {
            JOptionPane.showMessageDialog(null, "No existe el Id");
            view.txtIdDetallePedi.setText(null);
            view.txtIdDetallePedi.setEnabled(false);
            view.btnBuscar1.setEnabled(false);
            view.btnAgregar.setEnabled(true);
            view.btnEliminar.setEnabled(true);
        }
    }

    public Double totalPagar() {
        double acumulacion = 0;
        double valor = 0;
        for (int i = 0; i < view.tablaDP.getRowCount(); i++) {
            int fila = i; // Reemplaza 0 con el número de fila que deseas
            int columna = 6; // Reemplaza 1 con el número de columna que deseas

            valor = Double.parseDouble(modelo.getValueAt(fila, columna).toString());
            acumulacion += valor;
        }
        return acumulacion;
    }

    public void registrar() {
        Integer op = JOptionPane.showConfirmDialog(null, "¿Deseas registrar este pedido?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            habilitar2(false);
            view.btnAgregar1.setEnabled(false);
            view.btnEliminar1.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnAgregar.setEnabled(true);
            view.txtIdDetallePedi.setText("");
            view.cbProducto.setSelectedItem("");
            view.txtTotal.setText(totalPagar().toString());
            view.btnGuardar.setEnabled(true);
            view.btnAgregar.setEnabled(false);
            view.btnRegistrar.setEnabled(false);
        }
    }
//===============================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAgregar) {
            agregar();
        } else if (e.getSource() == view.btnAgregar1) {
            agregar1();
        } else if (e.getSource() == view.btnBuscar1) {
            buscar1();
        } else if (e.getSource() == view.btnEditar) {
            editar();
        } else if (e.getSource() == view.btnEliminar) {
            eliminar();
        } else if (e.getSource() == view.btnEliminar1) {
            eliminar1();
        } else if (e.getSource() == view.btnRegistrar) {
            registrar();
        } else if (e.getSource() == view.cbProducto) {
            cbProducto();
        } else if (e.getSource() == view.btnGuardar) {
            guardar();
        }
    }
}
