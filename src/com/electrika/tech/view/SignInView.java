
package com.electrika.tech.view;

public class SignInView extends javax.swing.JFrame {
    
    
    public SignInView() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNewNombre = new javax.swing.JTextField();
        btnini = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNewContra = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        txtNewUsuario = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtNewApellido = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrarse");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, 40));

        txtNewNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNewNombre.setText("Ingrese su nombre");
        txtNewNombre.setAlignmentX(2.0F);
        txtNewNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtNewNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 210, 30));

        btnini.setBackground(new java.awt.Color(36, 2, 130));
        btnini.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        btnini.setForeground(new java.awt.Color(255, 255, 255));
        btnini.setText("Iniciar");
        btnini.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnini.setBorderPainted(false);
        btnini.setFocusPainted(false);
        btnini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniActionPerformed(evt);
            }
        });
        jPanel1.add(btnini, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 210, 35));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/registro.jpeg"))); // NOI18N
        jLabel2.setText(" ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -460, 420, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 290));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/bloquear.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/usuario.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 30, 50));

        txtNewContra.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNewContra.setText("jPasswordField1");
        txtNewContra.setBorder(null);
        jPanel1.add(txtNewContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 160, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 160, 10));

        txtNewUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNewUsuario.setText("Ingrese nombre de usuario");
        txtNewUsuario.setAlignmentX(2.0F);
        txtNewUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtNewUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 166, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 170, 10));

        txtNewApellido.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtNewApellido.setText("Ingrese su apellido");
        txtNewApellido.setAlignmentX(2.0F);
        txtNewApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(txtNewApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 210, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 210, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 210, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btniniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btniniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JTextField txtNewApellido;
    public javax.swing.JPasswordField txtNewContra;
    public javax.swing.JTextField txtNewNombre;
    public javax.swing.JTextField txtNewUsuario;
    // End of variables declaration//GEN-END:variables
}
