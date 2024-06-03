package com.electrika.tech.controller;

import java.util.Stack;
import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.dao.impl.DaoVendedorImpl;
import com.electrika.tech.entidades.Vendedor;
import java.util.Date;
import com.electrika.tech.util.Ordenamiento;
import com.electrika.tech.view.InterManageUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendedorController implements ActionListener {

    private InterManageUser view;
    DaoVendedor dao;
    DefaultTableModel tabla;
    //declaracion de stack
    private Stack<Object[]> historial = new Stack<>();

    public VendedorController(InterManageUser view) {
        this.view = view;
        dao = new DaoVendedorImpl();
        tabla = new DefaultTableModel();
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Usuario");
        tabla.addColumn("Cargo");
        view.setTitle("Gestionar usuarios");
        view.txtFecha.setText(fechaActual());
        //tabla = (DefaultTableModel) view.tableUsers.getModel();
        view.tableUsers.setModel(tabla);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);

        listado();

        agregarEventos();
    }

    private void agregarEventos() {
        for (int i = 1; i < tabla.getColumnCount(); i++) {
            view.jComboValores1.addItem(tabla.getColumnName(i));
        }
        view.btnAceptarAgregar.addActionListener(this);
        view.btnAceptarEditar.addActionListener(this);
        view.btnAceptarEliminar.addActionListener(this);
        view.btnAgregar.addActionListener(this);
        view.btnBuscar.addActionListener(this);
        view.btnCancelar.addActionListener(this);
        view.btnEditar.addActionListener(this);
        view.btnEliminar.addActionListener(this);
        view.registerEntryExit.addActionListener(this);
        view.btnGuardarEntryExit.addActionListener(this);
        view.btnOrdenar.addActionListener(this);

        view.txtNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean numeros = (key >= 65 && key <= 90) || (key >= 97 && key <= 122) && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtApellido.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean numeros = (key >= 65 && key <= 90) || (key >= 97 && key <= 122) && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtId.addKeyListener(new KeyAdapter() {
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
        return String.format("%s%s", input.substring(0, 1).toUpperCase(), input.substring(1));
    }

    private void listado() {
        tabla.setRowCount(0);

        view.tableUsers.clearSelection();
        view.txtId.setText(null);
        view.txtNombre.setText(null);
        view.txtApellido.setText(null);
        view.txtUsuario.setText(null);
        view.txtContra.setText(null);
        view.jComboCargo.setSelectedIndex(0);

        for (Vendedor ven : dao.select()) {
            Object[] obj = new Object[5];
            obj[0] = ven.getCodUsuario();
            obj[1] = ven.getNombreUsuario();
            obj[2] = ven.getApellidoUsuario();
            obj[3] = ven.getUsuario();
            obj[4] = ven.getPuestoArea();
            tabla.addRow(obj);
        }
    }

    private void habilitar(boolean opc) {
        view.txtNombre.setEnabled(opc);
        view.txtApellido.setEnabled(opc);
        view.txtUsuario.setEnabled(opc);
        view.txtContra.setEnabled(opc);
        view.jComboCargo.setEnabled(opc);
        view.btnAceptarAgregar.setEnabled(opc);
        view.btnAceptarEditar.setEnabled(opc);
        view.btnAceptarEliminar.setEnabled(opc);
        view.btnCancelar.setEnabled(opc);
        view.btnAgregar.setEnabled(!opc);
        view.btnEditar.setEnabled(!opc);
        view.btnEliminar.setEnabled(!opc);
        //---------------------------------------------------------------------------------------------//
        view.informe.setEnabled(opc);
        //----------------------------------------------------------------------------------------------//

    }

    private String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    private void eliminar() {
        Integer fila = view.tableUsers.getSelectedRow();
        if (view.tableUsers.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            //---------------------------------------------------------------------------------------------------------------------//
            //Si hay errores eliminar esto
            Integer id = Integer.valueOf(view.tableUsers.getValueAt(fila, 0).toString());
//            Vendedor eliminado = dao.get(id);
//            historial.push(eliminado); // Guardar en el historial
//            dao.delete(id);
            listado();
            habilitar(false);
//            mostrarUltimoEditadoEnHistorial();

            //-----------------------------------------------------------------------------------------------------------------------------//
            view.btnAceptarEditar.setVisible(false);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(true);
            view.txtId.setText(view.tableUsers.getValueAt(fila, 0).toString());
            view.txtNombre.setText(view.tableUsers.getValueAt(fila, 1).toString());
            view.txtApellido.setText(view.tableUsers.getValueAt(fila, 2).toString());
            view.txtUsuario.setText(view.tableUsers.getValueAt(fila, 3).toString());
            view.jComboCargo.setSelectedItem(view.tableUsers.getValueAt(fila, 4).toString());
            view.txtContra.setText("");
            view.btnAceptarEliminar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }
    }

    private void agregar() {
        habilitar(true);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarAgregar.setVisible(true);
        view.btnAceptarEliminar.setVisible(false);
    }

    private void aceptarEliminar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        //dao.delete(id);//
        //---------------------------------------- eliminar si es necesario
        Vendedor eliminado = dao.get(id);
        historial.push(new Object[]{"eliminar", eliminado});
        dao.delete(id);
        //----------------------------------
        listado();
        habilitar(false);
        //Mostrar el último eliminado en el informe
        mostrarUltimoEnHistorial();
    }

    private void aceptarAgregar() {
        boolean bool = view.txtNombre.getText().isEmpty() || view.txtApellido.getText().isEmpty() || view.txtUsuario.getText().isEmpty() || view.txtContra.getText().isEmpty();
        if (bool) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String apellido = capitalizeFirstLetter(view.txtApellido.getText());
            String usuario = capitalizeFirstLetter(view.txtUsuario.getText());
            String contra = view.txtContra.getText();
            String cargo = view.jComboCargo.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null,
                    dao.insert(new Vendedor(null, apellido, nombre, usuario, contra, cargo, "2020-03-25", "2020-03-25")));
            listado();
            habilitar(false);
        }
    }

    private void editar() {
        view.btnAgregar.setEnabled(false);
        view.btnEditar.setEnabled(false);
        view.btnEliminar.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Ya puedes ingresar un id");
        view.btnAceptarEditar.setVisible(true);
        view.btnAceptarAgregar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        view.txtId.setEnabled(true);
        view.btnBuscar.setEnabled(true);
    }

    private void aceptarEditar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        boolean bool = view.txtId.getText().isEmpty() || view.txtNombre.getText().isEmpty() || view.txtApellido.getText().isEmpty() || view.txtUsuario.getText().isEmpty() || view.txtContra.getText().isEmpty();
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un id");
        } else if (bool) {
            JOptionPane.showMessageDialog(null, "No puedes registrar un vendedor sin datos");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String apellido = capitalizeFirstLetter(view.txtApellido.getText());
            String usuario = capitalizeFirstLetter(view.txtUsuario.getText());
            String contra = view.txtContra.getText();
            String cargo = view.jComboCargo.getSelectedItem().toString();
            //--------------------------------------------------------------------------------------------------------------
            Vendedor editado = dao.get(id);
            historial.push(new Object[]{"editar", editado});
            //--------------------------------------------------------------------------------------------------------------
            JOptionPane.showMessageDialog(null,
                    dao.update(new Vendedor(id, apellido, nombre, usuario, contra, cargo, "2020-03-25", "2020-03-25")));
            listado();
            view.txtId.setEnabled(false);
            view.btnBuscar.setEnabled(false);
            habilitar(false);
            // Mostrar el último editado en el informe
            mostrarUltimoEnHistorial();
        }
    }

    private void cancelar() {
        habilitar(false);
        view.txtId.setText(null);
        view.txtNombre.setText(null);
        view.txtApellido.setText(null);
        view.txtUsuario.setText(null);
        view.txtContra.setText(null);
        view.txtId.setEnabled(false);
        view.btnBuscar.setEnabled(false);
        listado();
    }

    private void buscar() {
        habilitar(true);
        Integer id = Integer.valueOf(view.txtId.getText());
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un Id");
        } else if (dao.get(id) != null) {
            Vendedor ven = dao.get(id);
            view.txtNombre.setText(ven.getNombreUsuario());
            view.txtApellido.setText(ven.getApellidoUsuario());
            view.txtUsuario.setText(ven.getUsuario());
            view.jComboCargo.setSelectedItem(ven.getPuestoArea());
            view.txtContra.setText(ven.getPassword());
        }
    }

    private void registerEntryExit() {
        Integer fila = view.tableUsers.getSelectedRow();
        if (view.tableUsers.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            Integer id = Integer.valueOf(view.tableUsers.getValueAt(fila, 0).toString());
            String nombre = view.tableUsers.getValueAt(fila, 1).toString();
            String apellido = view.tableUsers.getValueAt(fila, 2).toString();
            String usuario = view.tableUsers.getValueAt(fila, 3).toString();
            String cargo = view.tableUsers.getValueAt(fila, 4).toString();
            view.txtId.setText(id.toString());
            view.txtNombre.setText(nombre);
            view.txtApellido.setText(apellido);
            view.txtUsuario.setText(usuario);
            view.jComboCargo.setSelectedItem(cargo);
            habilitarDatosIngresoSalida(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }
    }

    private void habilitarDatosIngresoSalida(boolean opc) {
        view.jFechaIngreso.setEnabled(opc);
        view.jFechaSalida.setEnabled(opc);
        view.btnGuardarEntryExit.setEnabled(opc);
        view.btnCancelar.setEnabled(opc);
    }

    private void guardarIngresoSalida() {
        Integer id = Integer.valueOf(view.txtId.getText());
        String nombre = capitalizeFirstLetter(view.txtNombre.getText());
        String apellido = capitalizeFirstLetter(view.txtApellido.getText());
        String user = capitalizeFirstLetter(view.txtUsuario.getText());
        String cargo = view.jComboCargo.getSelectedItem().toString();
        String fechaIngreso = view.jFechaIngreso.getValue().toString();
        String fechaSalida = view.jFechaSalida.getValue().toString();
        Vendedor ven = dao.get(id);
        JOptionPane.showMessageDialog(null,
                dao.update(
                        new Vendedor(ven.getCodUsuario(), apellido, nombre, user, ven.getPassword(), cargo, fechaIngreso, fechaSalida)));
        habilitarDatosIngresoSalida(false);
        listado();
    }

    private void ordenarTabla() {
        if (view.jComboValores1.getSelectedItem().equals("Elegir valor")) {
            JOptionPane.showMessageDialog(null, "Debes elegir un valor a ordenar");
        } else if (view.btnAscendente.isSelected()) {
            ordenarAscendente(view.jComboValores1.getSelectedIndex());
        } else if (view.btnDescendente.isSelected()) {
            ordenarDescendente(view.jComboValores1.getSelectedIndex());
        }

        view.jComboValores1.setSelectedIndex(0);
        view.btnAscendente.setSelected(true);
        view.btnDescendente.setSelected(false);
    }

    private void ordenarAscendente(int columnIndex) {
        int rowCount = tabla.getRowCount();
        Object[] rows = new Object[rowCount];

        // Copiar los datos de la tabla en un arreglo
        for (int i = 0; i < rowCount; i++) {
            //se obtiene una fila completa especifica y lo pasa a un array de objetos
            rows[i] = tabla.getDataVector().get(i).toArray();
        }

        // Ordenar el arreglo utilizando QuickSort
        Ordenamiento.quickSort(rows, 0, rowCount - 1, columnIndex, "ascendente");

        // Actualizar la tabla con los datos ordenados
        tabla.setRowCount(0); // Limpiar la tabla
        for (Object row : rows) {
            tabla.addRow((Object[]) row);
        }
    }

    private void ordenarDescendente(int columnIndex) {
        int rowCount = tabla.getRowCount();
        Object[] rows = new Object[rowCount];

        // Copiar los datos de la tabla en un arreglo
        for (int i = 0; i < rowCount; i++) {
            //se obtiene una fila completa especifica y lo pasa a un array de objetos
            rows[i] = tabla.getDataVector().get(i).toArray();
        }

        // Ordenar el arreglo utilizando QuickSort
        Ordenamiento.quickSort(rows, 0, rowCount - 1, columnIndex, "descendente");

        // Actualizar la tabla con los datos ordenados
        tabla.setRowCount(0); // Limpiar la tabla
        for (Object row : rows) {
            tabla.addRow((Object[]) row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnEliminar) {
            eliminar();
        } else if (e.getSource() == view.btnAceptarEliminar) {
            aceptarEliminar();
        } else if (e.getSource() == view.btnAgregar) {
            agregar();
        } else if (e.getSource() == view.btnAceptarAgregar) {
            aceptarAgregar();
        } else if (e.getSource() == view.btnEditar) {
            editar();
        } else if (e.getSource() == view.btnAceptarEditar) {
            aceptarEditar();
        } else if (e.getSource() == view.btnCancelar) {
            cancelar();
        } else if (e.getSource() == view.btnBuscar) {
            buscar();
        } else if (e.getSource() == view.registerEntryExit) {
            registerEntryExit();
        } else if (e.getSource() == view.btnGuardarEntryExit) {
            guardarIngresoSalida();
        } else if (e.getSource() == view.btnOrdenar) {
            ordenarTabla();
        }
      
    }

    public void mostrarUltimoEnHistorial() {
        StringBuilder texto = new StringBuilder();
        for (Object[] accionVendedor : historial) {
            String accion = (String) accionVendedor[0];
            Vendedor vendedor = (Vendedor) accionVendedor[1];
            if ("editar".equals(accion)) {
                texto.append("Vendedor Editado: ").append(vendedor.getCodUsuario()).append(" ").append(vendedor.getNombreUsuario()).append("\n");
            } else if ("eliminar".equals(accion)) {
                texto.append("Vendedor Eliminado: ").append(vendedor.getCodUsuario()).append(" ").append(vendedor.getNombreUsuario()).append("\n");
            }
        }
        view.informe.setText(texto.toString());
    }


}
