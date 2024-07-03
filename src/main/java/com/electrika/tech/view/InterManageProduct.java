
package com.electrika.tech.view;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class InterManageProduct extends javax.swing.JInternalFrame {
    public InterManageProduct() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
//            IntelliJTheme.setup( NewJFrame.class.getResourceAsStream("/com/formdev/flatlaf/intellijthemes/themes/Carbon.theme.json" ));
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, "Failed to initialize LaF", ex);
        }
        //</editor-fold>
        initComponents();        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabelTitlePro = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePro = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabelQuestSort = new javax.swing.JLabel();
        cb_queOrdenar = new javax.swing.JComboBox<>();
        rb_asc = new javax.swing.JRadioButton();
        rb_desc = new javax.swing.JRadioButton();
        btnOrdenar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtBuscarB = new javax.swing.JTextField();
        btnBinarySearch = new javax.swing.JButton();
        labelBuscarB = new javax.swing.JLabel();
        labelAntesResu = new javax.swing.JLabel();
        labelResultado = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelBinarySearch = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jLabelBuscarCol = new javax.swing.JLabel();
        jLabelTitleSort = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCode = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabelDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabelPrice = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabelCategory = new javax.swing.JLabel();
        jComboCat = new javax.swing.JComboBox<>();
        btnAceptarAgregar = new javax.swing.JButton();
        btnAceptarEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarEliminar = new javax.swing.JButton();
        jLabelSupplier = new javax.swing.JLabel();
        jComboDis = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(780, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitlePro.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabelTitlePro.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitlePro.setText("Gestionar Producto");
        jPanel4.add(jLabelTitlePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        tablePro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripción", "Stock", "Precio", "Categoria", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePro);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 580, 350));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrito-de-supermercado.png"))); // NOI18N
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 60, 60));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 900, 10));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planificacion.png"))); // NOI18N
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 30, 30));

        jLabelQuestSort.setForeground(new java.awt.Color(0, 0, 0));
        jLabelQuestSort.setText("¿Qué campo desea ordenar?");
        jPanel4.add(jLabelQuestSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 120, 160, -1));

        cb_queOrdenar.setBackground(new java.awt.Color(255, 255, 255));
        cb_queOrdenar.setForeground(new java.awt.Color(0, 0, 0));
        cb_queOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar item>" }));
        jPanel4.add(cb_queOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 140, 140, -1));

        rb_asc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb_asc);
        rb_asc.setForeground(new java.awt.Color(0, 0, 0));
        rb_asc.setText("Ascendente");
        rb_asc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_asc.setEnabled(false);
        jPanel4.add(rb_asc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 190, -1, -1));

        rb_desc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb_desc);
        rb_desc.setForeground(new java.awt.Color(0, 0, 0));
        rb_desc.setText("Descendente");
        rb_desc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_desc.setEnabled(false);
        jPanel4.add(rb_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 190, -1, -1));

        btnOrdenar.setBackground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setForeground(new java.awt.Color(0, 0, 0));
        btnOrdenar.setText("Ordenar");
        jPanel4.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 230, -1, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscarB.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarB.setEnabled(false);
        jPanel7.add(txtBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 150, -1));

        btnBinarySearch.setBackground(new java.awt.Color(255, 255, 255));
        btnBinarySearch.setForeground(new java.awt.Color(0, 0, 0));
        btnBinarySearch.setText("Buscar");
        btnBinarySearch.setEnabled(false);
        jPanel7.add(btnBinarySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        labelBuscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa1.png"))); // NOI18N
        jPanel7.add(labelBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));
        jPanel7.add(labelAntesResu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 220, 30));
        jPanel7.add(labelResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 50, -1));
        jPanel7.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 250, 20));

        jLabelBinarySearch.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelBinarySearch.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBinarySearch.setText("BUSCAR");
        jPanel7.add(jLabelBinarySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabelSearch.setBackground(new java.awt.Color(0, 0, 0));
        jLabelSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSearch.setText("Buscar en la columna");
        jPanel7.add(jLabelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 150, 30));

        jLabelBuscarCol.setBackground(new java.awt.Color(0, 0, 102));
        jLabelBuscarCol.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabelBuscarCol.setForeground(new java.awt.Color(204, 0, 0));
        jPanel7.add(jLabelBuscarCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 140, 30));

        jLabelTitleSort.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitleSort.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleSort.setText("ORDENAR");
        jPanel7.add(jLabelTitleSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 140, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 370, 490));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 289, 157, -1));

        jLabelCode.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelCode.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCode.setText("Codigo");
        jPanel1.add(jLabelCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 52, -1));

        btnBuscar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 102, 21));

        jLabelName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName.setText("Nombre");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtPrecio.setEnabled(false);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 160, -1));

        jLabelDescription.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelDescription.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDescription.setText("Descripción");
        jPanel1.add(jLabelDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 158, 97));

        jLabelPrice.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelPrice.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice.setText("Precio");
        jPanel1.add(jLabelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 160, -1));

        jLabelStock.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelStock.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStock.setText("Stock");
        jPanel1.add(jLabelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        txtStock.setEnabled(false);
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 160, -1));

        jLabelCategory.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelCategory.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCategory.setText("Categoria");
        jPanel1.add(jLabelCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jComboCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>" }));
        jComboCat.setEnabled(false);
        jPanel1.add(jComboCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, -1));

        btnAceptarAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aceptar.png"))); // NOI18N
        btnAceptarAgregar.setText("Aceptar");
        btnAceptarAgregar.setEnabled(false);
        jPanel1.add(btnAceptarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        btnAceptarEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aceptar.png"))); // NOI18N
        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.setEnabled(false);
        jPanel1.add(btnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        btnCancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 240, 40));

        btnAceptarEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aceptar.png"))); // NOI18N
        btnAceptarEliminar.setText("Aceptar");
        btnAceptarEliminar.setEnabled(false);
        jPanel1.add(btnAceptarEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        jLabelSupplier.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelSupplier.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSupplier.setText("Proveedor");
        jPanel1.add(jLabelSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jComboDis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>" }));
        jComboDis.setEnabled(false);
        jPanel1.add(jComboDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 160, -1));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 290, 440));

        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 120, 40));

        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, 120, 40));

        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEditar.setText("Editar");
        jPanel4.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 120, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1940, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptarAgregar;
    public javax.swing.JButton btnAceptarEditar;
    public javax.swing.JButton btnAceptarEliminar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBinarySearch;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnOrdenar;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cb_queOrdenar;
    public javax.swing.JComboBox<String> jComboCat;
    public javax.swing.JComboBox<String> jComboDis;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabelBinarySearch;
    public javax.swing.JLabel jLabelBuscarCol;
    public javax.swing.JLabel jLabelCategory;
    public javax.swing.JLabel jLabelCode;
    public javax.swing.JLabel jLabelDescription;
    public javax.swing.JLabel jLabelName;
    public javax.swing.JLabel jLabelPrice;
    public javax.swing.JLabel jLabelQuestSort;
    public javax.swing.JLabel jLabelSearch;
    public javax.swing.JLabel jLabelStock;
    public javax.swing.JLabel jLabelSupplier;
    public javax.swing.JLabel jLabelTitlePro;
    public javax.swing.JLabel jLabelTitleSort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel labelAntesResu;
    private javax.swing.JLabel labelBuscarB;
    public javax.swing.JLabel labelResultado;
    public javax.swing.JRadioButton rb_asc;
    public javax.swing.JRadioButton rb_desc;
    public javax.swing.JTable tablePro;
    public javax.swing.JTextField txtBuscarB;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
