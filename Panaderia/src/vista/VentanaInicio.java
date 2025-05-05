
package vista;

/**
 *
 * @author wixo
 */
public class VentanaInicio extends javax.swing.JFrame {

    public VentanaInicio() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPedidos = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPedidos.setBackground(new java.awt.Color(255, 153, 51));
        btnPedidos.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnPedidos.setForeground(new java.awt.Color(102, 51, 0));
        btnPedidos.setText("Pedidos");
        btnPedidos.setBorder(new javax.swing.border.MatteBorder(null));
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 228, 150, 40));

        btnProductos.setBackground(new java.awt.Color(255, 153, 51));
        btnProductos.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(102, 51, 0));
        btnProductos.setText("Productos");
        btnProductos.setBorder(new javax.swing.border.MatteBorder(null));
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 160, 40));

        btnClientes.setBackground(new java.awt.Color(255, 153, 51));
        btnClientes.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(102, 51, 0));
        btnClientes.setText("Clientes");
        btnClientes.setBorder(new javax.swing.border.MatteBorder(null));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 160, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("ProductivityPro V1.0");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("La solución integral para tu negocio.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pan.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
    VentanaPedidos pedidos = new VentanaPedidos();
pedidos.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
pedidos.setVisible(true);            // Mostrar la ventana




     // TODO add your handling code here:
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
     
    VentanaClientes ventanaClientes = new VentanaClientes(); // Crear instancia de VentanaClientes
    ventanaClientes.setLocationRelativeTo(null);            // Centrar la ventana en la pantalla
    ventanaClientes.setVisible(true);                       // Mostrar la ventana



// TODO add your handling code here:
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
    VentanaPrincipal productos = new VentanaPrincipal();
productos.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
productos.setVisible(true);            // Mostrar la ventana



// TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc="Generated Code">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaInicio inicio = new VentanaInicio();
                inicio.setLocationRelativeTo(null); // Centrar la ventana antes de mostrarla
                inicio.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
