package com.electrika.tech.controller;

import com.electrika.tech.dao.DaoDistribuidor;
import com.electrika.tech.dao.impl.DaoDistribuidorImpl;
import com.electrika.tech.entidades.Distribuidor;
import com.electrika.tech.util.Busqueda;
import com.electrika.tech.util.Ordenamiento;
import com.electrika.tech.view.InterManageDistribuidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DistribuidorController implements ActionListener {

    DaoDistribuidor dao;
    DefaultTableModel tabla;
    private InterManageDistribuidor view;
    Stack<String> pila;
    Distribuidor distro = null;
    Distribuidor distriAntiguo = null;
    Integer indic = -1;
    public DistribuidorController(InterManageDistribuidor view) {
        this.view = view;
        pila = new Stack<>();
        //establece una conexión con la base de datos
        dao = new DaoDistribuidorImpl();
        tabla = new DefaultTableModel();
        view.setTitle("Gestionar Distribuidor");
        tabla = (DefaultTableModel) view.tableDistri.getModel();
        view.tableDistri.setModel(tabla);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarEliminar.setVisible(false);
        view.labelAntesResu.setVisible(false);
        view.labelResultado.setVisible(false);
        listado();
        agregarEventos();
    }

    private void agregarEventos() {
        for (int i = 1; i < tabla.getColumnCount(); i++) {
            view.cb_queOrdenar.addItem(tabla.getColumnName(i));
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
        view.btnBuscarB.addActionListener(this);
        view.btnDeshacer.addActionListener(this);
        view.cb_queOrdenar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.cb_queOrdenar.getSelectedIndex() != 0) {
                    view.rb_asc.setEnabled(true);
                    view.rb_desc.setEnabled(true);
                } else {
                    view.txtBuscarB.setEnabled(false);
                    view.btnBuscarB.setEnabled(false);
                    view.botones.clearSelection();
                    view.rb_asc.setEnabled(false);
                    view.rb_desc.setEnabled(false);
                    view.btnOrdenar.setEnabled(false);

                }
            }
        });
        view.rb_asc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.rb_asc.isSelected()) {
                    view.btnOrdenar.setEnabled(true);
                } else if (view.rb_desc.isSelected()) {
                    view.btnOrdenar.setEnabled(true);
                }
            }

        });

        view.txtRuc.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;
                String currentText = view.txtRuc.getText();
                boolean longitudPermitida = currentText.length() < 11;

                if (!numeros || !longitudPermitida) {
                    e.consume();
                }
            }
        });

        view.txtCode.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;

                if (!numeros) {
                    e.consume();
                }
            }
        });

        view.txtPhone.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo numeros con codigo ASCII

                boolean numeros = key >= 48 && key <= 57 && key != 32;
                String currentText = view.txtPhone.getText();
                boolean longitudPermitida = currentText.length() < 9;
                if (!numeros || !longitudPermitida) {
                    e.consume();
                }
            }
        });

        view.txtName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar(); // solo letras y espacio

                boolean letras = (key >= 65 && key <= 90) || (key >= 97 && key <= 122);
                boolean espacio = key == 32;
                if (!(letras || espacio)) {
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
        view.tableDistri.clearSelection();
        view.txtRuc.setText(null);
        view.txtCode.setText(null);
        view.txtName.setText(null);
        view.txtDirection.setText(null);
        view.txtPhone.setText(null);

        for (Distribuidor dis : dao.select()) {
            Object[] objs = new Object[5];
            objs[0] = dis.getIdDistribuidor();
            objs[1] = dis.getRuc();
            objs[2] = dis.getNombre();
            objs[3] = dis.getDireccion();
            objs[4] = dis.getTelefono();
            tabla.addRow(objs);
        }
    }

    private void habilitar(boolean opc) {
        view.txtName.setEnabled(opc);
        view.txtDirection.setEnabled(opc);
        view.txtRuc.setEnabled(opc);
        view.txtPhone.setEnabled(opc);

        view.btnAceptarAgregar.setEnabled(opc);
        view.btnAceptarEditar.setEnabled(opc);
        view.btnAceptarEliminar.setEnabled(opc);

        view.btnCancelar.setEnabled(opc);
        view.btnAgregar.setEnabled(!opc);
        view.btnEditar.setEnabled(!opc);
        view.btnEliminar.setEnabled(!opc);

    }

    private void aceptarAgregar() {
        // TODO add your handling ide here:
        DaoDistribuidorImpl deo = new DaoDistribuidorImpl();
        boolean bool = view.txtName.getText().isEmpty() || view.txtDirection.getText().isEmpty() || view.txtRuc.getText().isEmpty() || view.txtPhone.getText().isEmpty();
        if (bool) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los datos");
        } else {
            String nombreDistribuidor = capitalizeFirstLetter(view.txtName.getText());
            String direccionDistribuidor = capitalizeFirstLetter(view.txtDirection.getText());
            String ruc = view.txtRuc.getText();
            String telefonoDistribuidor = view.txtPhone.getText();

            //Se crea un nuevo distribuidor
            Distribuidor distri = new Distribuidor(null, ruc, nombreDistribuidor, direccionDistribuidor, telefonoDistribuidor);
//            dao.insert(distri);

            /*No es recomendable trabajar directamente con el dao.insert(distri);
            especificamente en la parte del objeto distribuidor, ya que no podremos obtener
            su id, ya que, es un objeto nulo en la clase Distribuidor, por el 
            simple hecho de que su id se encuentra creado como auto-incrementable
            en la base de datos*/
 /*Se agrego a la pila la accion de la insercion*/
            dao.insert(distri);
            pila.push("deshacerAgregado");
            JOptionPane.showMessageDialog(null, deo.ultimoValor());

            JOptionPane.showMessageDialog(null, distri);
//            pila.add();
            //La referencia me esta diciendo que ahora debo eliminar
//            referencia = "eliminar";
            JOptionPane.showMessageDialog(null, "Se insertó un nuevo distribuidor");
            listado();
            habilitar(false);
        }
    }

    private void aceptarEditar() {
        Integer ide = Integer.valueOf(view.txtCode.getText());

        boolean bool1 = view.txtCode.getText().isEmpty() || view.txtName.getText().isEmpty() || view.txtDirection.getText().isEmpty() || view.txtRuc.getText().isEmpty() || view.txtPhone.getText().isEmpty();
        if (view.txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un codigo");
        } else if (bool1) {
            JOptionPane.showMessageDialog(null, "No puedes guardar clientes vacios");
        } else {
            String nombreDistribuidor = capitalizeFirstLetter(view.txtName.getText());
            String direccionDistribuidor = capitalizeFirstLetter(view.txtDirection.getText());
            String ruc = view.txtRuc.getText();
            String telefonoDistribuidor = view.txtPhone.getText();

            Distribuidor distri = new Distribuidor(ide, ruc, nombreDistribuidor, direccionDistribuidor, telefonoDistribuidor);
            dao.update(distri);
            pila.push("deshacerActualizado");
            JOptionPane.showMessageDialog(null, "Se acualizó el registro de un distribuidor");
            System.out.println("Se actualizo " + distriAntiguo + "a: " + distri);
            listado();
            view.txtCode.setEnabled(false);
            view.btnBuscar.setEnabled(false);
            habilitar(false);
        }
    }

    private void aceptarEliminar() {

        List elementosEliminados = new ArrayList();

        /**
         * Quiero obtener todos los valores, lo cual al hacer multiples
         * eliminaciones, tambien pueda hacer multiples agregaciones. No solo
         * basta tener el ultimo valor, sino de cada uno integramente.
         */
        /**
         * Primero, obtengo los valores que se encuentran en los TextField.
         * Segundo, creo un objeto de tipo Distribuidor, para posteriormente agregarlo a la tabla.
         * Tercero, agrego ese objeto creado a una lista
         * Cuarto, lo que me falta hacer es identificar a cadad inserción por medio de su id. (o algo asi).
         */
        
        Integer ide = Integer.valueOf(view.txtCode.getText());
        String ruc = view.txtRuc.getText();
        String nom = view.txtName.getText();
        String dir = view.txtDirection.getText();
        String tel = view.txtPhone.getText();
        distro = new Distribuidor(ide, ruc, nom, dir, tel);
        indic++; //0
        //Seria eliminar indic? Seria implementar un for?
        elementosEliminados.add(indic, distro);
        System.out.println("Tamanio de la lista: "+elementosEliminados.size()); //1
        System.out.println("*********************");
        System.out.println(elementosEliminados);
        
        JOptionPane.showMessageDialog(null, "El indice es: "+indic);
        
        JOptionPane.showMessageDialog(null, "La variable guardada es: " + distro);
        dao.delete(ide);
        pila.push("deshacerEliminado");
        listado();
        JOptionPane.showMessageDialog(null, "Eliminación exitosa");

        habilitar(false);
    }

    private void cancelar() {
        habilitar(false);
        view.txtCode.setText(null);
        view.txtRuc.setText(null);
        view.txtName.setText(null);
        view.txtDirection.setText(null);
        view.txtPhone.setText(null);
        view.txtCode.setEnabled(false);
        view.btnBuscar.setEnabled(false);
        listado();
    }

    private void agregar() {
        habilitar(true);
        view.btnAceptarEditar.setVisible(false);
        view.btnAceptarAgregar.setVisible(true);
        view.btnAceptarEliminar.setVisible(false);
    }

    private void editar() {

        Integer fila = view.tableDistri.getSelectedRow();
        String rucAntiguo = view.txtRuc.getText();
        String nomAntiguo = view.txtName.getText();
        String dirAntiguo = view.txtDirection.getText();
        String telAntiguo = view.txtPhone.getText();

        //Creamos el distribuidor anterior
        if (view.tableDistri.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para actualizar");
        } else if (fila >= 0) {
            view.btnAceptarEditar.setVisible(true);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(false);

            view.txtCode.setText(view.tableDistri.getValueAt(fila, 0).toString());
            view.txtRuc.setText(view.tableDistri.getValueAt(fila, 1).toString());
            view.txtName.setText(view.tableDistri.getValueAt(fila, 2).toString());
            view.txtDirection.setText(view.tableDistri.getValueAt(fila, 3).toString());
            view.txtPhone.setText(view.tableDistri.getValueAt(fila, 4).toString());
            //Obtiene el ultimo
            distriAntiguo = new Distribuidor(Integer.valueOf(view.txtCode.getText()), view.txtRuc.getText(), view.txtName.getText(), view.txtDirection.getText(), view.txtPhone.getText());
            JOptionPane.showMessageDialog(null, "El distribuidor antes de actualizar es: " + distriAntiguo);

            view.btnAceptarEditar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            habilitar(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }

    }

    private void eliminar() {
        Integer fila = view.tableDistri.getSelectedRow();
        if (view.tableDistri.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar");
        } else if (fila >= 0) {

            //Se sabe que botón me lleva a que, entre los 3, mediante su visibilidad
            view.btnAceptarEditar.setVisible(false);
            view.btnAceptarAgregar.setVisible(false);
            view.btnAceptarEliminar.setVisible(true);

            view.txtCode.setText(view.tableDistri.getValueAt(fila, 0).toString());
            view.txtRuc.setText(view.tableDistri.getValueAt(fila, 1).toString());
            view.txtName.setText(view.tableDistri.getValueAt(fila, 2).toString());
            view.txtDirection.setText(view.tableDistri.getValueAt(fila, 3).toString());
            view.txtPhone.setText(view.tableDistri.getValueAt(fila, 4).toString());

            view.btnAceptarEliminar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.btnAgregar.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir una fila");
        }
    }

    private void buscar() {
        /**
         * Primero deberia ingresarse, porque sino se ingresa entonces lo toma
         * como un string y al tener un string no es un entero por lo cual
         * botaria un error
         */

        view.txtCode.setEnabled(true);

        if (!view.txtCode.getText().isEmpty()) {
            Integer cod = Integer.valueOf(view.txtCode.getText());
            if (view.txtCode.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa un Codigo");
            } else if (dao.get(cod) != null) {
                habilitar(true);
                Distribuidor dis = dao.get(cod);
                view.txtRuc.setText(dis.getRuc());
                view.txtName.setText(dis.getNombre());
                view.txtDirection.setText(dis.getDireccion());
                view.txtPhone.setText(dis.getTelefono());
            }
        }
    }

    public void ordenarTabla() {

        if (view.cb_queOrdenar.getSelectedItem().equals("<Seleccionar item>")) {
            JOptionPane.showMessageDialog(null, "Seleccione un campo válido");
        } else if (view.rb_asc.isSelected()) {
            int columnIndex = view.cb_queOrdenar.getSelectedIndex();
            /*Al dar en seleccionar item me vuelve todo a la normalidad porque en si lee al codigo y parece como si regresase a la normalidad*/
            ordenarAscendentemente(columnIndex);
            labelBuscar(tabla.getColumnName(columnIndex));

        } else if (view.rb_desc.isSelected()) {
            int columnIndex = view.cb_queOrdenar.getSelectedIndex();
            ordenarDescendentemente(columnIndex);
            labelBuscar(tabla.getColumnName(columnIndex));
        }
        view.txtBuscarB.setEnabled(true);
        view.btnBuscarB.setEnabled(true);
    }

    /*Alfabeticamente*/
    //ascendente
    public void ordenarAscendentemente(int columnIndex) {
        Integer filas = tabla.getRowCount(); //la cantidad de filas de la tabla
        Object[] filasV = new Object[filas];

        for (int i = 0; i < filasV.length; i++) {
            /* Los valores extraidos de la tabla lo agregamos a un vector para 
            poder guardarlo en la variable filasV*/
            filasV[i] = tabla.getDataVector().get(i).toArray();
        }

        Ordenamiento.quickSort(filasV, 0, filasV.length - 1, columnIndex, "ascendente");

        tabla.setRowCount(0);
        for (Object o : filasV) {
            tabla.addRow((Object[]) o);
        }

    }

    public void ordenarDescendentemente(int columnIndex) {
        Integer filas = tabla.getRowCount(); //la cantidad de filas de la tabla
        Object[] filasV = new Object[filas];

        for (int i = 0; i < filasV.length; i++) {
            /* Los valores extraidos de la tabla lo agregamos a un vector para 
            poder guardarlo en la variable filasV*/
            filasV[i] = tabla.getDataVector().get(i).toArray();
        }

        Ordenamiento.quickSort(filasV, 0, filasV.length - 1, columnIndex, "descendente");

        tabla.setRowCount(0);
        for (Object o : filasV) {
            tabla.addRow((Object[]) o);
        }
    }

    public void binario() {

        if (view.txtBuscarB.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un elemento a buscar");
        } else {
            //aca me debes de traer el vector filasV
            int columnIndex = view.cb_queOrdenar.getSelectedIndex();
            busquedaBinaria(columnIndex);

        }
    }

    public void busquedaBinaria(Integer columnIndex) {

        Integer filas = tabla.getRowCount(); //la cantidad de filas de la tabla
        List<String> columnValues = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            columnValues.add(String.valueOf(tabla.getValueAt(i, columnIndex)));
        }

        Integer resultado = Busqueda.busquedaBinaria(columnValues, view.txtBuscarB.getText());

        if (resultado != null) {

            view.labelAntesResu.setText(String.format("%s se encuentra en la fila:", view.txtBuscarB.getText()));
            view.labelResultado.setText(String.valueOf((resultado + 1)));
            view.labelAntesResu.setVisible(true);
            view.labelResultado.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró su búsqueda");
        }
        view.txtBuscarB.setText("");

    }

    public void labelBuscar(String nombre) {
        view.labelBuscar.setText(nombre);
    }

    public void deshacer() {
        /*Si se realizaron acciones*/

 /*Por el momento 19:30 la pila esta vacia porque en el agregar no he
        realizado la insercion del elemento a la pila*/
        JOptionPane.showMessageDialog(null, pila);
        System.out.println(pila);
        if (!pila.isEmpty()) {
            /*Se elimina la ultima accion*/

            switch (pila.peek()) {
                case "deshacerAgregado":

                    /*¿Cómo puedo obtener el código de lo insertado a la pila,
                    si lo que se inserta, se hace sin el código?*/
                    DaoDistribuidorImpl deo = new DaoDistribuidorImpl();
                    Integer tope = deo.ultimoValor();
                    dao.delete(tope);
                    /**
                     * Al realizar un pop estamos reduciendo la cantidad de la
                     * pila con respecto a las actividades realizadas en la
                     * tabla.
                     */
                    pila.pop();
                    listado();
                    JOptionPane.showMessageDialog(null, "Se elimino la ultima accion");
                    break;
                case "deshacerEliminado":
                    /*Necesito tener el id del elemento eliminado*/
                    JOptionPane.showMessageDialog(null, "El elemento guardadaso: " + distro);
                    /**
                     * Necesito un contador que decremente el indice de la lista dependiendo de la cantidad de valores se hayan eliminado.
                     */
                    dao.insert(distro);
                    indic--;
                    pila.pop();
                    listado();
                    break;
                case "deshacerActualizado":
                    JOptionPane.showMessageDialog(null, distriAntiguo);
                    dao.update(distriAntiguo);
                    pila.pop();
                    listado();
                    System.out.println("Se deshizo la actualizacion");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
            }

            listado();
        } else {
            JOptionPane.showMessageDialog(null, "No se puede realizar mas cambios");
//            System.out.println("No se puede realizar mas cambios");
        }
    } //Fin del metodo deshacer

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
        } else if (e.getSource() == view.btnBuscarB) {
            binario();
        } else if (e.getSource() == view.btnDeshacer) {
            deshacer();
        }
    }
}
