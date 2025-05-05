/*
 * Esta clase crea una ventana gráfica para gestionar clientes y pedidos.
 * Muestra una tabla con información de clientes y permite buscar pedidos por cliente.
 */
package vista;

import java.util.List; // Importa la clase List para manejar listas de datos.
import javax.swing.*; // Importa las clases para la interfaz gráfica.
import javax.swing.table.DefaultTableModel; // Modelo para manejar las tablas.
import modelo.ClienteDAO; // Clase para gestionar datos de clientes desde la base de datos.
import modelo.Cliente; // Clase que representa a un cliente.
import modelo.Pedido; // Clase que representa un pedido.
import modelo.PedidoDAO; // Clase para gestionar datos de pedidos desde la base de datos.

public class VentanaClientes extends javax.swing.JFrame {

    /**
     * Constructor que crea la ventana de clientes.
     */
    public VentanaClientes() {
        initComponents(); // Inicializa los componentes de la ventana (generado automáticamente por NetBeans).
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        cargarClientes(); // Carga los clientes en la tabla al iniciar la ventana.
    }
    
    // Este método carga los datos de los clientes desde la base de datos y los muestra en la tabla.
    private void cargarClientes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaClientes.getModel(); // Obtiene el modelo de la tabla.
        modeloTabla.setRowCount(0); // Limpia los datos actuales de la tabla.

        ClienteDAO dao = new ClienteDAO(); // Crea un objeto para interactuar con la base de datos.
        List<Cliente> listaClientes = dao.listarClientes(); // Obtiene la lista de clientes desde la base de datos.

        // Recorre cada cliente y lo agrega como una fila en la tabla.
        for (Cliente cliente : listaClientes) {
            modeloTabla.addRow(new Object[]{
                cliente.getIdCliente(), // ID del cliente.
                cliente.getNombre(),    // Nombre del cliente.
                cliente.getTelefono(),  // Teléfono del cliente.
                cliente.getDireccion()  // Dirección del cliente.
            });
        }
    }

    // Este método filtra los pedidos realizados por un cliente específico y los muestra en la tabla.
    private void filtrarPedidosPorCliente(String cliente) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaClientes.getModel(); // Obtiene el modelo de la tabla.
        modeloTabla.setRowCount(0); // Limpia los datos actuales de la tabla.

        PedidoDAO pedidoDao = new PedidoDAO(); // Crea un objeto para interactuar con los datos de pedidos.
        List<Pedido> pedidos = pedidoDao.buscarPedidosPorCliente(cliente); // Busca pedidos del cliente ingresado.

        // Si no hay resultados, muestra un mensaje.
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron pedidos para el cliente ingresado.");
            return; // Sale del método si no hay pedidos.
        }

        // Recorre cada pedido encontrado y lo agrega como una fila en la tabla.
        for (Pedido pedido : pedidos) {
            modeloTabla.addRow(new Object[]{
                pedido.getIdPedido(),      // ID del pedido.
                pedido.getIdCliente(),     // ID del cliente asociado al pedido.
                pedido.getNombreCliente(), // Nombre del cliente.
                pedido.getTipoPan(),       // Tipo de pan pedido.
                pedido.getCantidad(),      // Cantidad de pan.
                pedido.getFechaEntrega(),  // Fecha de entrega del pedido.
                pedido.getEstado()         // Estado del pedido (ejemplo: "Pendiente").
            });
        }

        // Muestra un mensaje indicando que la búsqueda se completó.
        JOptionPane.showMessageDialog(null, "Búsqueda completada.");
    }






    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarCliente.setBackground(new java.awt.Color(255, 153, 51));
        btnAgregarCliente.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnAgregarCliente.setForeground(new java.awt.Color(102, 51, 0));
        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.setBorder(new javax.swing.border.MatteBorder(null));
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 200, 30));

        btnEliminarCliente.setBackground(new java.awt.Color(255, 153, 51));
        btnEliminarCliente.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(102, 51, 0));
        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.setBorder(new javax.swing.border.MatteBorder(null));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 200, 30));

        btnEditarCliente.setBackground(new java.awt.Color(255, 153, 51));
        btnEditarCliente.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnEditarCliente.setForeground(new java.awt.Color(102, 51, 0));
        btnEditarCliente.setText("Editar Cliente");
        btnEditarCliente.setBorder(new javax.swing.border.MatteBorder(null));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 170, 30));

        jScrollPane.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jScrollPaneAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tablaClientes.setBackground(new java.awt.Color(255, 204, 102));
        tablaClientes.setBorder(new javax.swing.border.MatteBorder(null));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Telefono", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaClientes.setName("tablaClientes"); // NOI18N
        jScrollPane.setViewportView(tablaClientes);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 132, 800, 167));

        btnAtras.setBackground(new java.awt.Color(255, 153, 51));
        btnAtras.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(102, 51, 0));
        btnAtras.setText("Atras");
        btnAtras.setBorder(new javax.swing.border.MatteBorder(null));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 90, 30));

        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 140, 30));

        btnBuscarCliente.setBackground(new java.awt.Color(255, 153, 51));
        btnBuscarCliente.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(102, 51, 0));
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.setBorder(new javax.swing.border.MatteBorder(null));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 110, 30));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("Buscar por Nombre :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 59, 230, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setForeground(new java.awt.Color(204, 153, 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed

   // Este bloque de código solicita los datos de un cliente mediante cuadros de diálogo y los agrega a la base de datos.

String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:"); 
// Muestra un cuadro de diálogo para que el usuario ingrese el nombre del cliente y lo guarda en la variable 'nombre'.

if (nombre == null || nombre.trim().isEmpty()) { 
    // Verifica si el usuario no ingresó nada o solo espacios en blanco.
    JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido."); 
    // Si el nombre no es válido, muestra un mensaje de error.
    return; 
    // Termina la ejecución del método.
}

String telefono = JOptionPane.showInputDialog(this, "Ingrese el teléfono del cliente:"); 
// Muestra un cuadro de diálogo para ingresar el teléfono del cliente.

String direccion = JOptionPane.showInputDialog(this, "Ingrese la dirección del cliente:"); 
// Muestra un cuadro de diálogo para ingresar la dirección del cliente.

Cliente nuevoCliente = new Cliente(0, nombre, telefono, direccion); 
// Crea un objeto 'Cliente' con los datos ingresados. Se usa '0' para el ID porque este se generará automáticamente.

ClienteDAO dao = new ClienteDAO(); 
// Crea una instancia de 'ClienteDAO' para interactuar con la base de datos.

if (dao.agregarCliente(nuevoCliente)) { 
    // Llama al método 'agregarCliente' para guardar el cliente en la base de datos.
    JOptionPane.showMessageDialog(this, "Cliente agregado con éxito."); 
    // Si se agregó correctamente, muestra un mensaje de éxito.
    cargarClientes(); 
    // Recarga la tabla de clientes para mostrar el nuevo registro.
} else {
    JOptionPane.showMessageDialog(this, "Error al agregar el cliente."); 
    // Si hubo un error, muestra un mensaje indicando el problema.
}


    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
         
// Este bloque de código permite eliminar un cliente seleccionado de la tabla.

int fila = tablaClientes.getSelectedRow(); 
// Obtiene el índice de la fila seleccionada en la tabla. Si no hay fila seleccionada, devuelve -1.

if (fila < 0) { 
    // Verifica si no se seleccionó ninguna fila.
    JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar."); 
    // Muestra un mensaje indicando que se debe seleccionar un cliente.
    return; 
    // Sale del método si no hay una fila seleccionada.
}

int idCliente = (int) tablaClientes.getValueAt(fila, 0); 
// Obtiene el ID del cliente de la columna 0 de la fila seleccionada.

int confirmacion = JOptionPane.showConfirmDialog(this, 
    "¿Está seguro de eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION); 
// Muestra un cuadro de diálogo de confirmación para asegurar que el usuario desea eliminar al cliente.

if (confirmacion == JOptionPane.YES_OPTION) { 
    // Verifica si el usuario confirmó la acción.
    ClienteDAO dao = new ClienteDAO(); 
    // Crea una instancia de 'ClienteDAO' para interactuar con la base de datos.

    if (dao.eliminarCliente(idCliente)) { 
        // Llama al método 'eliminarCliente' para eliminar al cliente con el ID especificado.
        JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito."); 
        // Si la eliminación fue exitosa, muestra un mensaje de confirmación.
        cargarClientes(); 
        // Recarga la tabla de clientes para reflejar los cambios.
    } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar el cliente."); 
        // Si hubo un error durante la eliminación, muestra un mensaje de error.
    }
}


        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed

       // Este bloque de código permite editar la información de un cliente seleccionado en la tabla.

int fila = tablaClientes.getSelectedRow(); 
// Obtiene el índice de la fila seleccionada en la tabla. Si no hay fila seleccionada, devuelve -1.

if (fila < 0) { 
    // Verifica si no se seleccionó ninguna fila.
    JOptionPane.showMessageDialog(this, "Seleccione un cliente para editar."); 
    // Muestra un mensaje indicando que se debe seleccionar un cliente.
    return; 
    // Sale del método si no hay una fila seleccionada.
}

int idCliente = (int) tablaClientes.getValueAt(fila, 0); 
// Obtiene el ID del cliente de la columna 0 de la fila seleccionada.
String nombre = (String) tablaClientes.getValueAt(fila, 1); 
// Obtiene el nombre del cliente de la columna 1 de la fila seleccionada.
String telefono = (String) tablaClientes.getValueAt(fila, 2); 
// Obtiene el teléfono del cliente de la columna 2 de la fila seleccionada.
String direccion = (String) tablaClientes.getValueAt(fila, 3); 
// Obtiene la dirección del cliente de la columna 3 de la fila seleccionada.

String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", nombre); 
// Muestra un cuadro de diálogo para editar el nombre. El valor inicial es el nombre actual.
String nuevoTelefono = JOptionPane.showInputDialog(this, "Nuevo teléfono:", telefono); 
// Muestra un cuadro de diálogo para editar el teléfono. El valor inicial es el teléfono actual.
String nuevaDireccion = JOptionPane.showInputDialog(this, "Nueva dirección:", direccion); 
// Muestra un cuadro de diálogo para editar la dirección. El valor inicial es la dirección actual.

Cliente clienteActualizado = new Cliente(idCliente, nuevoNombre, nuevoTelefono, nuevaDireccion); 
// Crea un objeto 'Cliente' con la información actualizada del cliente.

ClienteDAO dao = new ClienteDAO(); 
// Crea una instancia de 'ClienteDAO' para interactuar con la base de datos.

if (dao.actualizarCliente(clienteActualizado)) { 
    // Llama al método 'actualizarCliente' para actualizar los datos del cliente en la base de datos.
    JOptionPane.showMessageDialog(this, "Cliente actualizado con éxito."); 
    // Si la actualización fue exitosa, muestra un mensaje de confirmación.
    cargarClientes(); 
    // Recarga la tabla de clientes para reflejar los cambios.
} else {
    JOptionPane.showMessageDialog(this, "Error al actualizar el cliente."); 
    // Si hubo un error durante la actualización, muestra un mensaje de error.
}


    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void jScrollPaneAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jScrollPaneAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPaneAncestorAdded

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

        // Cerrar la ventana actual
        this.dispose();
        

       
     

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed
        // Este bloque de código permite buscar pedidos asociados a un cliente cuyo nombre se ingrese en un campo de texto.

String cliente = txtBuscarCliente.getText().trim(); 
// Obtiene el texto ingresado en el campo de búsqueda y elimina los espacios en blanco al inicio y al final.

if (cliente.isEmpty()) { 
    // Verifica si el campo de búsqueda está vacío.
    JOptionPane.showMessageDialog(null, "Ingrese un nombre para buscar."); 
    // Muestra un mensaje indicando que se debe ingresar un nombre para realizar la búsqueda.
} else {
    filtrarPedidosPorCliente(cliente); 
    // Si se ingresó un nombre, llama al método 'filtrarPedidosPorCliente' para buscar los pedidos asociados al cliente.
}


        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
       
// Obtener el nombre del cliente desde el campo de texto
String nombreCliente = txtBuscarCliente.getText().trim();

// Validar si el campo está vacío
if (nombreCliente.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de cliente para buscar.");
    return;
}

// Limpiar la tabla antes de cargar los resultados
DefaultTableModel modeloTabla = (DefaultTableModel) tablaClientes.getModel();
modeloTabla.setRowCount(0);

// Crear una instancia del DAO para realizar la búsqueda
ClienteDAO clienteDao = new ClienteDAO();
List<Cliente> clientes = clienteDao.buscarClientesPorNombre(nombreCliente);

// Verificar si se encontraron resultados
if (clientes.isEmpty()) {
    JOptionPane.showMessageDialog(this, "No se encontraron clientes con el nombre ingresado.");
    return;
}

// Agregar los resultados a la tabla
for (Cliente cliente : clientes) {
    modeloTabla.addRow(new Object[]{
        cliente.getIdCliente(),   // ID del Cliente
        cliente.getNombre(),      // Nombre del Cliente
        cliente.getTelefono(),    // Teléfono
        cliente.getDireccion()    // Dirección
    });


// Mostrar un mensaje indicando que la búsqueda se completó
JOptionPane.showMessageDialog(this, "Búsqueda de clientes completada.");

    }//GEN-LAST:event_btnBuscarClienteActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            inicio.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
            inicio.setVisible(true); // Mostrar la ventana
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables

 
}
