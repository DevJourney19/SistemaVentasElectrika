package com.electrika.tech.controller;

import com.electrika.tech.dao.DaoCategoria;
import com.electrika.tech.dao.impl.DaoCategoriaImpl;
import com.electrika.tech.entidades.Categoria;
import com.electrika.tech.view.InterCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class CategoriaController implements ActionListener {

    DaoCategoria dao;
    DefaultTableModel table;

    private InterCategoria view;

    public CategoriaController(InterCategoria view) {
        this.view = view;
        dao = new DaoCategoriaImpl();
        table = (DefaultTableModel) view.tableCat.getModel();
        view.tableCat.setModel(table);
        view.setTitle("Agregar Categoria");
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        listado();
        agregarEventos();
    }
    
    private void agregarEventos() {
        view.btnAceptarAgregar.addActionListener(this);
        view.btnAceptarEditar.addActionListener(this);
        view.btnAceptarEliminar.addActionListener(this);
        view.btnAgregar.addActionListener(this);
        view.btnBuscar.addActionListener(this);
        view.btnCancelar.addActionListener(this);
        view.btnEditar.addActionListener(this);
        view.btnEliminar.addActionListener(this);

        view.txtNombre.addKeyListener(new KeyAdapter() {
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

    private void listado() {
        table.setNumRows(0);
        view.tableCat.clearSelection();
        view.txtId.setText(null);
        view.txtNombre.setText(null);
        view.txtDescripcion.setText(null);

        Object[] obj = new Object[3];
        for (Categoria cat : dao.select()) {
            obj[0] = cat.getIdCate();
            obj[1] = cat.getNombre();
            obj[2] = cat.getDescripcion();
            table.addRow(obj);
        }
    }
    
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Devolver el mismo texto si es nulo o vacío
        }

        // Convertir la primera letra a mayúscula y concatenar el resto del texto.
        return String.format("%s%s", input.substring(0, 1).toUpperCase(), input.substring(1).toLowerCase());

    }
    
    private void habilitar(boolean opc) {
        view.txtNombre.setEnabled(opc);
        view.txtDescripcion.setEnabled(opc);
        view.btnAceptarAgregar.setEnabled(opc);
        view.btnAceptarEditar.setEnabled(opc);
        view.btnAceptarEliminar.setEnabled(opc);
        view.btnCancelar.setEnabled(opc);
        view.btnAgregar.setEnabled(!opc);
        view.btnEditar.setEnabled(!opc);
        view.btnEliminar.setEnabled(!opc);
    }

    private void eliminar() {
        Integer fila = view.tableCat.getSelectedRow();
        if (view.tableCat.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {
            view.btnAceptarEditar.setVisible(false);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(true);
            view.txtId.setText(view.tableCat.getValueAt(fila, 0).toString());
            view.txtNombre.setText(view.tableCat.getValueAt(fila, 1).toString());
            view.txtDescripcion.setText(view.tableCat.getValueAt(fila, 2).toString());
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
        dao.delete(id);
        listado();
        habilitar(false);
    }

    private void aceptarAgregar() {
        boolean bool = view.txtNombre.getText().isEmpty() || view.txtDescripcion.getText().isEmpty();
        if (bool) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String descripcion = capitalizeFirstLetter(view.txtDescripcion.getText());
            JOptionPane.showMessageDialog(null,
                    dao.insert(new Categoria(null, nombre, descripcion)));
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
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un id");
        } else if (view.txtId.getText().isEmpty() || view.txtNombre.getText().isEmpty() || view.txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes guardar categorias vacias");
        } else {
            String nombre = capitalizeFirstLetter(view.txtNombre.getText());
            String decripcion = capitalizeFirstLetter(view.txtDescripcion.getText());
            JOptionPane.showMessageDialog(null,
                    dao.update(new Categoria(id, nombre, decripcion)));
            listado();
            view.txtId.setEnabled(false);
            view.btnBuscar.setEnabled(false);
            habilitar(false);
        }
    }

    private void cancelar() {
        habilitar(false);
        view.txtId.setText(null);
        view.txtNombre.setText(null);
        view.txtDescripcion.setText(null);
        view.txtId.setEnabled(false);
        view.btnBuscar.setEnabled(false);
        listado();
    }

    private void buscar() {
        Integer id = Integer.valueOf(view.txtId.getText());
        if (view.txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un Id");
        } else if (dao.get(id) != null) {
            habilitar(true);
            Categoria cat = dao.get(id);
            view.txtNombre.setText(cat.getNombre());
            view.txtDescripcion.setText(cat.getDescripcion());
            view.btnAceptarEditar.setVisible(true);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(false);
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
        }
    }

}
