
package com.electrika.tech.view;

public class InterManageProduct extends javax.swing.JInternalFrame {
    public InterManageProduct() {             
        initComponents();        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePro = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboCat = new javax.swing.JComboBox<>();
        btnAceptarAgregar = new javax.swing.JButton();
        btnAceptarEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboDis = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePro1 = new javax.swing.JTable();
        btnEditar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtId1 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtPrecio1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtStock1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboCat1 = new javax.swing.JComboBox<>();
        btnAceptarAgregar1 = new javax.swing.JButton();
        btnAceptarEditar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        btnAceptarEliminar1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboDis1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cb_queOrdenar = new javax.swing.JComboBox<>();
        rb_asc = new javax.swing.JRadioButton();
        rb_desc = new javax.swing.JRadioButton();
        btnOrdenar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtBuscarB = new javax.swing.JTextField();
        btnBuscarB = new javax.swing.JButton();
        labelBuscarB = new javax.swing.JLabel();
        labelAntesResu = new javax.swing.JLabel();
        labelResultado = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        labelBuscar = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(780, 550));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel2.setText("Gestionar Producto");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

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
        jScrollPane1.setViewportView(tablePro);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 580, 350));

        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEditar.setText("Editar");
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 120, 40));

        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 120, 40));

        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, 120, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 289, 157, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Codigo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 52, -1));

        btnBuscar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 102, 21));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtPrecio.setEnabled(false);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 160, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Descripción");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 158, 97));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Precio");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 160, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("Stock");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        txtStock.setEnabled(false);
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 160, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Categoria");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jComboCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>" }));
        jComboCat.setEnabled(false);
        jPanel1.add(jComboCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, -1));

        btnAceptarAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/aceptar.png"))); // NOI18N
        btnAceptarAgregar.setText("Aceptar");
        btnAceptarAgregar.setEnabled(false);
        jPanel1.add(btnAceptarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        btnAceptarEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/aceptar.png"))); // NOI18N
        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.setEnabled(false);
        jPanel1.add(btnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        btnCancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 240, 40));

        btnAceptarEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/aceptar.png"))); // NOI18N
        btnAceptarEliminar.setText("Aceptar");
        btnAceptarEliminar.setEnabled(false);
        jPanel1.add(btnAceptarEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Proveedor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jComboDis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>" }));
        jComboDis.setEnabled(false);
        jPanel1.add(jComboDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 160, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 290, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/carrito-de-supermercado.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 60, 60));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 900, 10));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(780, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel4.setText("Gestionar Producto");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        tablePro1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablePro1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 580, 350));

        btnEditar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEditar1.setText("Editar");
        jPanel4.add(btnEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 120, 40));

        btnEliminar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnEliminar1.setText("Eliminar");
        jPanel4.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 120, 40));

        btnAgregar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAgregar1.setText("Agregar");
        jPanel4.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, 120, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 289, 157, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setText("Codigo");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        txtId1.setEnabled(false);
        jPanel5.add(txtId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 52, -1));

        btnBuscar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar1.setText("Buscar");
        btnBuscar1.setEnabled(false);
        jPanel5.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 102, 21));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setText("Nombre");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtPrecio1.setEnabled(false);
        jPanel5.add(txtPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 160, -1));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setText("Descripción");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtDescripcion1.setColumns(20);
        txtDescripcion1.setLineWrap(true);
        txtDescripcion1.setRows(5);
        txtDescripcion1.setEnabled(false);
        jScrollPane4.setViewportView(txtDescripcion1);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 158, 97));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel14.setText("Precio");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        txtNombre1.setEnabled(false);
        jPanel5.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 160, -1));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setText("Stock");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        txtStock1.setEnabled(false);
        jPanel5.add(txtStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 160, -1));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel16.setText("Categoria");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jComboCat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>" }));
        jComboCat1.setEnabled(false);
        jPanel5.add(jComboCat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 160, -1));

        btnAceptarAgregar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarAgregar1.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/aceptar.png"))); // NOI18N
        btnAceptarAgregar1.setText("Aceptar");
        btnAceptarAgregar1.setEnabled(false);
        jPanel5.add(btnAceptarAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        btnAceptarEditar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEditar1.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/aceptar.png"))); // NOI18N
        btnAceptarEditar1.setText("Aceptar");
        btnAceptarEditar1.setEnabled(false);
        jPanel5.add(btnAceptarEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        btnCancelar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/cancelar.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setEnabled(false);
        jPanel5.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 240, 40));

        btnAceptarEliminar1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEliminar1.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/aceptar.png"))); // NOI18N
        btnAceptarEliminar1.setText("Aceptar");
        btnAceptarEliminar1.setEnabled(false);
        jPanel5.add(btnAceptarEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 40));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel17.setText("Proveedor");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jComboDis1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>" }));
        jComboDis1.setEnabled(false);
        jPanel5.add(jComboDis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 160, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 290, 440));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/carrito-de-supermercado.png"))); // NOI18N
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 60, 60));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 900, 10));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/planificacion.png"))); // NOI18N
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 30, 30));

        jLabel20.setText("¿Qué campo desea ordenar?");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 120, 160, -1));

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

        btnBuscarB.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarB.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarB.setText("Buscar");
        btnBuscarB.setEnabled(false);
        jPanel7.add(btnBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        labelBuscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/lupa1.png"))); // NOI18N
        jPanel7.add(labelBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));
        jPanel7.add(labelAntesResu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 220, 30));
        jPanel7.add(labelResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 50, -1));
        jPanel7.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 250, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 153));
        jLabel21.setText("BUSCAR");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Buscar en la columna");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 150, 30));

        labelBuscar.setBackground(new java.awt.Color(0, 0, 102));
        labelBuscar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelBuscar.setForeground(new java.awt.Color(204, 0, 0));
        jPanel7.add(labelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 140, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 153));
        jLabel23.setText("ORDENAR");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 140, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 370, 490));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1710, 850));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptarAgregar;
    public javax.swing.JButton btnAceptarAgregar1;
    public javax.swing.JButton btnAceptarEditar;
    public javax.swing.JButton btnAceptarEditar1;
    public javax.swing.JButton btnAceptarEliminar;
    public javax.swing.JButton btnAceptarEliminar1;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAgregar1;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnBuscar1;
    public javax.swing.JButton btnBuscarB;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCancelar1;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEditar1;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEliminar1;
    public javax.swing.JButton btnOrdenar;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cb_queOrdenar;
    public javax.swing.JComboBox<String> jComboCat;
    public javax.swing.JComboBox<String> jComboCat1;
    public javax.swing.JComboBox<String> jComboDis;
    public javax.swing.JComboBox<String> jComboDis1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel labelAntesResu;
    public javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelBuscarB;
    public javax.swing.JLabel labelResultado;
    public javax.swing.JRadioButton rb_asc;
    public javax.swing.JRadioButton rb_desc;
    public javax.swing.JTable tablePro;
    public javax.swing.JTable tablePro1;
    public javax.swing.JTextField txtBuscarB;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextArea txtDescripcion1;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtId1;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombre1;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtPrecio1;
    public javax.swing.JTextField txtStock;
    public javax.swing.JTextField txtStock1;
    // End of variables declaration//GEN-END:variables
}
