package com.electrika.tech.view;

public class InterManageClient extends javax.swing.JInternalFrame {

    public InterManageClient() {      
        initComponents();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        btnAceptarAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarEditar = new javax.swing.JButton();
        btnAceptarEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        btnAscendente = new javax.swing.JRadioButton();
        btnDescendente = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnBuscarData = new javax.swing.JButton();
        txtData = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaData = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jComboValores1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        labelColumna = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMinimumSize(new java.awt.Dimension(1800, 760));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1800, 759));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableClients.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dni", "Nombre", "Apellido", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableClients);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 880, 220));

        txtId.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 110, 30));

        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setPreferredSize(new java.awt.Dimension(80, 30));
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 130, 40));

        txtNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 170, 30));

        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/editar-codigo.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusPainted(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(72, 30));
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 130, 40));

        txtApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtApellido.setEnabled(false);
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 170, 30));

        txtCorreo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtCorreo.setEnabled(false);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 370, 30));

        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/informacion.png"))); // NOI18N
        btnBuscar.setEnabled(false);
        btnBuscar.setFocusPainted(false);
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 70, 60));

        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/agregar-usuario.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusPainted(false);
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, 130, 40));

        txtTelefono.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtTelefono.setEnabled(false);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 170, 30));

        txtDni.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtDni.setEnabled(false);
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 160, 30));

        btnAceptarAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarAgregar.setText("Aceptar");
        btnAceptarAgregar.setEnabled(false);
        jPanel1.add(btnAceptarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 30));

        btnCancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 110, 30));

        btnAceptarEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.setEnabled(false);
        jPanel1.add(btnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 30));

        btnAceptarEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnAceptarEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptarEliminar.setText("Aceptar");
        btnAceptarEliminar.setEnabled(false);
        jPanel1.add(btnAceptarEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/satisfaccion-del-consumidor.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 830, -1));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Tienes que elegir el valor que deseas ordenar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel4.setText("Gestionar Clientes");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.setEnabled(false);
        jPanel1.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 240, -1, -1));

        buttonGroup1.add(btnAscendente);
        btnAscendente.setSelected(true);
        btnAscendente.setText("Ascendente");
        btnAscendente.setBorder(null);
        btnAscendente.setEnabled(false);
        jPanel1.add(btnAscendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 190, -1, -1));

        buttonGroup1.add(btnDescendente);
        btnDescendente.setText("Descendente");
        btnDescendente.setBorder(null);
        btnDescendente.setEnabled(false);
        jPanel1.add(btnDescendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 190, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel6.setText("Busqueda de Clientes");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 320, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel7.setText("Ordenar Tabla Clientes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 40, -1, -1));

        btnBuscarData.setText("Buscar");
        btnBuscarData.setEnabled(false);
        jPanel1.add(btnBuscarData, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 410, -1, -1));

        txtData.setEnabled(false);
        jPanel1.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 410, 170, -1));

        areaData.setEditable(false);
        areaData.setColumns(20);
        areaData.setRows(5);
        jScrollPane3.setViewportView(areaData);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 450, 310, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/informacion.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, 50, 60));

        jComboValores1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir valor" }));
        jPanel1.add(jComboValores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 140, 170, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Columna a buscar : ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 370, -1, -1));

        labelColumna.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(labelColumna, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 370, 110, 20));

        jLabelId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelId.setForeground(new java.awt.Color(0, 0, 0));
        jLabelId.setText("Id Cliente");
        jPanel1.add(jLabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(0, 0, 0));
        jLabelApellido.setText("Apellido");
        jPanel1.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombre.setText("Nombre");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Dni");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTelefono.setText("Telefono");
        jPanel1.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCorreo.setText("Correo");
        jPanel1.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea areaData;
    public javax.swing.JButton btnAceptarAgregar;
    public javax.swing.JButton btnAceptarEditar;
    public javax.swing.JButton btnAceptarEliminar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JRadioButton btnAscendente;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnBuscarData;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JRadioButton btnDescendente;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnOrdenar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> jComboValores1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabelApellido;
    public javax.swing.JLabel jLabelCorreo;
    public javax.swing.JLabel jLabelId;
    public javax.swing.JLabel jLabelNombre;
    public javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel labelColumna;
    public javax.swing.JTable tableClients;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtData;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
