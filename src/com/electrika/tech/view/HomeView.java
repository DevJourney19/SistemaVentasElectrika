
package com.electrika.tech.view;

public class HomeView extends javax.swing.JFrame {
    
    
    public HomeView() {
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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuName = new javax.swing.JMenu();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuCliente = new javax.swing.JMenu();
        jMenuCat = new javax.swing.JMenu();
        jMenuProd = new javax.swing.JMenu();
        jMenuVentas = new javax.swing.JMenu();
        jMenuProv = new javax.swing.JMenu();
        jMenuSignOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1798, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1800, 760));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1100, 71));

        jMenuName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/logo - Copy_1.png"))); // NOI18N
        jMenuName.setText("Electrika");
        jMenuName.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jMenuName.setPreferredSize(new java.awt.Dimension(295, 67));
        jMenuBar1.add(jMenuName);

        jMenuUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jMenuUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jMenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/vendedor.png"))); // NOI18N
        jMenuUsuario.setText("Usuario");
        jMenuUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuUsuario.setPreferredSize(new java.awt.Dimension(150, 70));
        jMenuBar1.add(jMenuUsuario);

        jMenuCliente.setBackground(new java.awt.Color(0, 0, 0));
        jMenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/clasificacion.png"))); // NOI18N
        jMenuCliente.setText("Cliente");
        jMenuCliente.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuCliente.setPreferredSize(new java.awt.Dimension(150, 70));
        jMenuBar1.add(jMenuCliente);

        jMenuCat.setBackground(new java.awt.Color(0, 0, 0));
        jMenuCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/categorias.png"))); // NOI18N
        jMenuCat.setText("Categoría");
        jMenuCat.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuCat.setPreferredSize(new java.awt.Dimension(160, 70));
        jMenuBar1.add(jMenuCat);

        jMenuProd.setBackground(new java.awt.Color(0, 0, 0));
        jMenuProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/productos.png"))); // NOI18N
        jMenuProd.setText("Productos");
        jMenuProd.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuProd.setPreferredSize(new java.awt.Dimension(165, 70));
        jMenuBar1.add(jMenuProd);

        jMenuVentas.setBackground(new java.awt.Color(0, 0, 0));
        jMenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/punto-de-venta.png"))); // NOI18N
        jMenuVentas.setText("Ventas");
        jMenuVentas.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuVentas.setPreferredSize(new java.awt.Dimension(160, 70));
        jMenuBar1.add(jMenuVentas);

        jMenuProv.setBackground(new java.awt.Color(0, 0, 0));
        jMenuProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/mensajero.png"))); // NOI18N
        jMenuProv.setText("Proveedor");
        jMenuProv.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuProv.setPreferredSize(new java.awt.Dimension(155, 70));
        jMenuBar1.add(jMenuProv);

        jMenuSignOut.setBackground(new java.awt.Color(0, 0, 0));
        jMenuSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/electrika/tech/img/salida.png"))); // NOI18N
        jMenuSignOut.setText("Salir");
        jMenuSignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuSignOut.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jMenuSignOut.setPreferredSize(new java.awt.Dimension(170, 70));
        jMenuBar1.add(jMenuSignOut);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMenuCat;
    public javax.swing.JMenu jMenuCliente;
    public javax.swing.JMenu jMenuName;
    public javax.swing.JMenu jMenuProd;
    public javax.swing.JMenu jMenuProv;
    public javax.swing.JMenu jMenuSignOut;
    public javax.swing.JMenu jMenuUsuario;
    public javax.swing.JMenu jMenuVentas;
    public javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
