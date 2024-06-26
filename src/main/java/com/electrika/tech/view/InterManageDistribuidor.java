package com.electrika.tech.view;

public class InterManageDistribuidor extends javax.swing.JInternalFrame {

    public InterManageDistribuidor() {
        initComponents();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDistri = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDirection = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAceptarEliminar = new javax.swing.JButton();
        btnAceptarEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarAgregar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        labelBuscar = new javax.swing.JLabel();
        labelBuscarB = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelAntesResu = new javax.swing.JLabel();
        labelResultado = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        cb_queOrdenar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabelTsort = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rb_asc = new javax.swing.JRadioButton();
        rb_desc = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarB = new javax.swing.JTextField();
        btnBuscarB = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabelRuc = new javax.swing.JLabel();
        jLabelCode = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableDistri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "RUC", "Name", "Address", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDistri);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 740, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Manage distributor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        txtRuc.setBackground(new java.awt.Color(219, 243, 255));
        txtRuc.setBorder(null);
        txtRuc.setEnabled(false);
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 180, 30));

        txtCode.setBackground(new java.awt.Color(219, 243, 255));
        txtCode.setBorder(null);
        txtCode.setEnabled(false);
        jPanel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 50, 30));

        txtName.setBackground(new java.awt.Color(219, 243, 255));
        txtName.setBorder(null);
        txtName.setEnabled(false);
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 350, 30));

        txtDirection.setBackground(new java.awt.Color(219, 243, 255));
        txtDirection.setBorder(null);
        txtDirection.setEnabled(false);
        jPanel1.add(txtDirection, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 350, 30));

        txtPhone.setBackground(new java.awt.Color(219, 243, 255));
        txtPhone.setBorder(null);
        txtPhone.setEnabled(false);
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 160, 30));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar-codigo.png"))); // NOI18N
        btnEditar.setText("Edit");
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 150, 40));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/basura.png"))); // NOI18N
        btnEliminar.setText("Delete");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 150, 40));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-usuario.png"))); // NOI18N
        btnAgregar.setText("Add");
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 150, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa1.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 60, 40));

        btnAceptarEliminar.setText("Accept");
        btnAceptarEliminar.setEnabled(false);
        jPanel1.add(btnAceptarEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 80, 30));

        btnAceptarEditar.setText("Accept");
        btnAceptarEditar.setEnabled(false);
        jPanel1.add(btnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 80, 30));

        btnCancelar.setText("Cancel");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 80, 30));

        btnAceptarAgregar.setText("Accept");
        btnAceptarAgregar.setEnabled(false);
        jPanel1.add(btnAceptarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 80, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 740, 10));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Search in column");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 370, 150, 30));

        labelBuscar.setBackground(new java.awt.Color(0, 0, 102));
        labelBuscar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelBuscar.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(labelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 370, 140, 30));

        labelBuscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa1.png"))); // NOI18N
        jPanel1.add(labelBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("SEARCH");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 330, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(labelAntesResu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 200, 30));
        jPanel2.add(labelResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 50, -1));

        btnOrdenar.setText("Sort");
        jPanel2.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        cb_queOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select item>" }));
        jPanel2.add(cb_queOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 140, -1));

        jLabel6.setText("Which field would you like to sort?");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, -1));

        jLabelTsort.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTsort.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTsort.setText("SORT");
        jPanel2.add(jLabelTsort, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planificacion.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        rb_asc.setBackground(new java.awt.Color(255, 255, 255));
        botones.add(rb_asc);
        rb_asc.setText("Ascending");
        rb_asc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_asc.setEnabled(false);
        jPanel2.add(rb_asc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        rb_desc.setBackground(new java.awt.Color(255, 255, 255));
        botones.add(rb_desc);
        rb_desc.setText("Descending");
        rb_desc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_desc.setEnabled(false);
        jPanel2.add(rb_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 250, 20));

        txtBuscarB.setEnabled(false);
        txtBuscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarBActionPerformed(evt);
            }
        });
        jPanel2.add(txtBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, -1));

        btnBuscarB.setText("Search");
        btnBuscarB.setEnabled(false);
        jPanel2.add(btnBuscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 350, 490));

        btnDeshacer.setText("Undo");
        jPanel1.add(btnDeshacer, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 263, 150, 30));

        jLabelRuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelRuc.setText("RUC");
        jPanel1.add(jLabelRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 116, 80, -1));

        jLabelCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCode.setText("Code");
        jPanel1.add(jLabelCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 116, -1, -1));

        jLabelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelName.setText("Name");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 168, -1, -1));

        jLabelPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone.setText("Phone");
        jPanel1.add(jLabelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 268, -1, -1));

        jLabelAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAddress.setText("Address");
        jPanel1.add(jLabelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 218, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtBuscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup botones;
    public javax.swing.JButton btnAceptarAgregar;
    public javax.swing.JButton btnAceptarEditar;
    public javax.swing.JButton btnAceptarEliminar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnBuscarB;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnDeshacer;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnOrdenar;
    public javax.swing.JComboBox<String> cb_queOrdenar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabelAddress;
    public javax.swing.JLabel jLabelCode;
    public javax.swing.JLabel jLabelName;
    public javax.swing.JLabel jLabelPhone;
    public javax.swing.JLabel jLabelRuc;
    public javax.swing.JLabel jLabelTsort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel labelAntesResu;
    public javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelBuscarB;
    public javax.swing.JLabel labelResultado;
    public javax.swing.JRadioButton rb_asc;
    public javax.swing.JRadioButton rb_desc;
    public javax.swing.JTable tableDistri;
    public javax.swing.JTextField txtBuscarB;
    public javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtDirection;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPhone;
    public javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
