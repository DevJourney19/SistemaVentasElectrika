package com.electrika.tech.controller;

import com.electrika.tech.dao.DaoCliente;
import com.electrika.tech.dao.impl.*;
import com.electrika.tech.entidades.Cliente;
import com.electrika.tech.util.Busqueda;
import com.electrika.tech.util.Ordenamiento;
import com.electrika.tech.view.InterManageClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteController implements ActionListener {

    DaoCliente dao;
    DefaultTableModel tabla;
    private InterManageClient view;

    public ClienteController(InterManageClient view) {
        this.view = view;
        dao = new DaoClienteImpl();
        view.setTitle("Gestionar clientes");
        tabla = (DefaultTableModel) view.tableClients.getModel();
        view.tableClients.setModel(tabla);
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
        view.btnOrdenar.addActionListener(this);
        view.btnBuscarData.addActionListener(this);

        view.jComboValores1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.jComboValores1.getSelectedIndex() != 0) {
                    view.btnAscendente.setEnabled(true);
                    view.btnDescendente.setEnabled(true);
                    view.btnOrdenar.setEnabled(true);
                } else {
                    view.txtData.setEnabled(false);
                    view.btnBuscarData.setEnabled(false);
                    view.btnAscendente.setEnabled(false);
                    view.btnDescendente.setEnabled(false);
                    view.btnOrdenar.setEnabled(false);

                }
            }
        });

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

        view.txtDni.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;
                String currentText = view.txtDni.getText();
                boolean longitudPermitida = currentText.length() < 8;
                if (!numeros || !longitudPermitida) {
                    e.consume();
                }
            }
        });

        view.txtTelefono.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;
                String currentText = view.txtTelefono.getText();
                boolean longitudPermitida = currentText.length() < 9;
                if (!numeros || !longitudPermitida) {
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

    private void listado() {
        tabla.setNumRows(0);
        //TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<>(tabla);
        //view.tableClients.setRowSorter(sorter);
        view.tableClients.clearSelection();
        view.txtId.setText(null);
        view.txtDni.setText(null);
        view.txtNombre.setText(null);
        view.txtApellido.setText(null);
        view.txtTelefono.setText(null);
        view.txtCorreo.setText(null);
        Object[] obj = new Object[6];
        for (Cliente cli : dao.select()) {
            obj[0] = cli.getCodUsuario();
            obj[1] = cli.getDni();
            obj[2] = cli.getNombreUsuario();
            obj[3] = cli.getApellidoUsuario();
            obj[4] = cli.getTelefono();
            obj[5] = cli.getCorreo();
            tabla.addRow(obj);
        }
    }

    private void habilitar(boolean opc) {
        view.txtNombre.setEnabled(opc);
        view.txtApellido.setEnabled(opc);
        view.txtDni.setEnabled(opc);
        view.txtTelefono.setEnabled(opc);
        view.txtCorreo.setEnabled(opc);
        view.btnAceptarAgregar.setEnabled(opc);
        view.btnAceptarEditar.setEnabled(opc);
        view.btnAceptarEliminar.setEnabled(opc);
        view.btnCancelar.setEnabled(opc);
        view.btnAgregar.setEnabled(!opc);
        view.btnEditar.setEnabled(!opc);
        view.btnEliminar.setEnabled(!opc);
    }

    private void aceptarAgregar() {
        boolean bool = view.txtNombre.getText().isEmpty() || view.txtApellido.getText().isEmpty() || view.txtDni.getText().isEmpty() || view.txtTelefono.getText().isEmpty() || view.txtCorreo.getText().isEmpty();
        if (bool) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String apellido = capitalizeFirstLetter(view.txtApellido.getText());
            String dni = view.txtDni.getText();
            String telefono = view.txtTelefono.getText();
            String correo = capitalizeFirstLetter(view.txtCorreo.getText());

            JOptionPane.showMessageDialog(null,
                    dao.insert(new Cliente(null, apellido, nombre, dni, telefono, correo)));
            listado();
            habilitar(false);
        }
    }

    private void aceptarEditar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        boolean bool1 = view.txtId.getText().isEmpty() || view.txtNombre.getText().isEmpty() || view.txtApellido.getText().isEmpty() || view.txtDni.getText().isEmpty() || view.txtTelefono.getText().isEmpty() || view.txtCorreo.getText().isEmpty();
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un id");
        } else if (bool1) {
            JOptionPane.showMessageDialog(null, "No puedes guardar clientes vacios");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String apellido = capitalizeFirstLetter(view.txtApellido.getText());
            String dni = view.txtDni.getText();
            String telefono = view.txtTelefono.getText();
            String correo = capitalizeFirstLetter(view.txtCorreo.getText());
            JOptionPane.showMessageDialog(null,
                    dao.update(new Cliente(id, apellido, nombre, dni, telefono, correo)));
            listado();
            view.txtId.setEnabled(false);
            view.btnBuscar.setEnabled(false);
            habilitar(false);
        }
    }

    private void aceptarEliminar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        dao.delete(id);
        listado();
        habilitar(false);
    }

    private void cancelar() {
        habilitar(false);
        view.txtId.setText(null);
        view.txtDni.setText(null);
        view.txtNombre.setText(null);
        view.txtApellido.setText(null);
        view.txtTelefono.setText(null);
        view.txtCorreo.setText(null);
        view.txtId.setEnabled(false);
        view.btnBuscar.setEnabled(false);
        listado();
    }

    private void agregar() {
        habilitar(true);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarAgregar.setVisible(true);
        view.btnAceptarEliminar.setVisible(false);
    }

    private void buscar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        habilitar(true);
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un Id");
        } else if (dao.get(id) != null) {
            Cliente cli = dao.get(id);
            view.txtDni.setText(cli.getDni());
            view.txtNombre.setText(cli.getNombreUsuario());
            view.txtApellido.setText(cli.getApellidoUsuario());
            view.txtTelefono.setText(cli.getTelefono());
            view.txtCorreo.setText(cli.getCorreo());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el id");
        }
    }

    private void editar() {
        view.txtId.setEnabled(true);
        view.btnBuscar.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Ya puedes ingresar un id");
        view.btnAceptarEditar.setVisible(true);
        view.btnAceptarAgregar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        view.txtId.setEnabled(true);
        view.btnBuscar.setEnabled(true);
    }

    private void eliminar() {
        Integer fila = view.tableClients.getSelectedRow();
        if (view.tableClients.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            view.btnAceptarEditar.setVisible(false);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(true);
            view.txtId.setText(view.tableClients.getValueAt(fila, 0).toString());
            view.txtDni.setText(view.tableClients.getValueAt(fila, 1).toString());
            view.txtNombre.setText(view.tableClients.getValueAt(fila, 2).toString());
            view.txtApellido.setText(view.tableClients.getValueAt(fila, 3).toString());
            view.txtTelefono.setText(view.tableClients.getValueAt(fila, 4).toString());
            view.txtCorreo.setText(view.tableClients.getValueAt(fila, 5).toString());
            view.btnAceptarEliminar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }
    }

    private void ordenarTabla() {
        if (view.jComboValores1.getSelectedItem().equals("Elegir valor")) {
            JOptionPane.showMessageDialog(null, "Debes elegir un valor a ordenar");
            return;
        } else {
            int columnIndex = view.jComboValores1.getSelectedIndex();
            if (view.btnAscendente.isSelected()) {
                ordenarAscendente(columnIndex);
            } else if (view.btnDescendente.isSelected()) {
                ordenarDescendente(columnIndex);
            }

            view.labelColumna.setText(tabla.getColumnName(columnIndex));
        }
        view.txtData.setText("");
        view.btnAscendente.setSelected(true);
        view.btnDescendente.setSelected(false);
        view.btnBuscarData.setEnabled(true);
        view.txtData.setEnabled(true);
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

    private void buscarData() {
        if (view.txtData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cadena de caracteres para buscar");
        } else {
            int columnBusqueda = view.jComboValores1.getSelectedIndex();
            List<String> data = new ArrayList<>();
            for (int i = 0; i < tabla.getRowCount(); i++) {
                Object value = tabla.getValueAt(i, columnBusqueda);
                if (value != null) {
                    data.add(value.toString());
                }
            }
            String valor = view.txtData.getText();
            Integer index = Busqueda.busquedaBinaria(data, valor);
            if (index != null && index >= 0 && index < data.size()) {
                StringBuilder rowDataString = new StringBuilder();
                rowDataString.append("Se encuentra en el indice: ")
                        .append(index)
                        .append("\nValor buscado: ")
                        .append(valor)
                        .append(" - ")
                        .append(view.labelColumna.getText());
                view.areaData.setText(rowDataString.toString());
                view.jComboValores1.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "El valor que ingresaste no existe");
            }

            view.txtData.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAceptarAgregar) {
            aceptarAgregar();
        } else if (e.getSource() == view.btnAceptarEditar) {
            aceptarEditar();
        } else if (e.getSource() == view.btnAceptarEliminar) {
            aceptarEliminar();
        } else if (e.getSource() == view.btnAgregar) {
            agregar();
        } else if (e.getSource() == view.btnBuscar) {
            buscar();
        } else if (e.getSource() == view.btnCancelar) {
            cancelar();
        } else if (e.getSource() == view.btnEditar) {
            editar();
        } else if (e.getSource() == view.btnEliminar) {
            eliminar();
        } else if (e.getSource() == view.btnOrdenar) {
            ordenarTabla();
        } else if (e.getSource() == view.btnBuscarData) {
            buscarData();
        }
    }

}
