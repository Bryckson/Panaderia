
package vista;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
import modelo.PedidoDAO;
import modelo.ClienteDAO;


public class VentanaPedidos extends javax.swing.JFrame {

    // Constructor
    public VentanaPedidos() {
        initComponents();
        cargarPedidos();
       
        
    }
private void buscarPedidosPorCliente(String nombreCliente) {
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
    modeloTabla.setRowCount(0); // Limpiar la tabla

    PedidoDAO pedidoDao = new PedidoDAO();
    List<Pedido> pedidos = pedidoDao.buscarPedidosPorCliente(nombreCliente); // Busca directamente por nombre_cliente

    for (Pedido pedido : pedidos) {
        modeloTabla.addRow(new Object[]{
            pedido.getIdPedido(),
            pedido.getNombreCliente(), // Ahora se toma directamente el nombre del cliente
            pedido.getTipoPan(),
            pedido.getCantidad(),
            pedido.getFechaEntrega(),
            pedido.getEstado()
        });
    }
}


private void cargarPedidos() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
    modeloTabla.setRowCount(0); // Limpiar tabla

    PedidoDAO pedidoDao = new PedidoDAO();
    List<Pedido> pedidos = pedidoDao.obtenerTodosLosPedidos();

    for (Pedido pedido : pedidos) {
        // Calcular el total
        double total = pedido.getCantidad() * pedido.getValorUnitario();

        modeloTabla.addRow(new Object[]{
            pedido.getIdPedido(),
            pedido.getIdCliente(),
            pedido.getNombreCliente(),
            pedido.getTipoPan(),
            pedido.getCantidad(),
            pedido.getFechaEntrega(),
            pedido.getEstado(),
            pedido.getValorUnitario(),
            total // Total calculado
        });
    }
}




    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarPedidos = new javax.swing.JButton();
        btnEditarPedidos = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrarPedidos.setBackground(new java.awt.Color(255, 153, 51));
        btnRegistrarPedidos.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnRegistrarPedidos.setForeground(new java.awt.Color(102, 51, 0));
        btnRegistrarPedidos.setText("Registrar Pedidos");
        btnRegistrarPedidos.setBorder(new javax.swing.border.MatteBorder(null));
        btnRegistrarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPedidosActionPerformed(evt);
            }
        });

        btnEditarPedidos.setBackground(new java.awt.Color(255, 153, 51));
        btnEditarPedidos.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnEditarPedidos.setForeground(new java.awt.Color(102, 51, 0));
        btnEditarPedidos.setText("Editar Pedido");
        btnEditarPedidos.setBorder(new javax.swing.border.MatteBorder(null));
        btnEditarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPedidosActionPerformed(evt);
            }
        });

        btnEliminarPedido.setBackground(new java.awt.Color(255, 153, 51));
        btnEliminarPedido.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnEliminarPedido.setForeground(new java.awt.Color(102, 51, 0));
        btnEliminarPedido.setText("Eliminar Pedido");
        btnEliminarPedido.setBorder(new javax.swing.border.MatteBorder(null));
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        jScrollPane.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jScrollPaneAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tablaPedidos.setBackground(new java.awt.Color(255, 204, 102));
        tablaPedidos.setBorder(new javax.swing.border.MatteBorder(null));
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pedido", "ID Cliente", "Nombre  Cliente", "Tipo de Pan", "Cantidad", "Fecha de Entrega", "Estado", "Valor Unitario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaPedidos.setName("tablaPedidos"); // NOI18N
        jScrollPane.setViewportView(tablaPedidos);

        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("Buscar por Cliente:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnRegistrarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnEliminarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void btnRegistrarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPedidosActionPerformed
// Solicitar el ID del cliente
String idClienteStr = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente:");
if (idClienteStr == null || idClienteStr.trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Debe ingresar el ID del cliente.");
    return; // Salir si no se ingresa un ID válido
}

try {
    // Convertir el ID del cliente a entero
    int idCliente = Integer.parseInt(idClienteStr.trim());

    // Buscar el nombre del cliente en la base de datos
    ClienteDAO clienteDao = new ClienteDAO();
    String nombreCliente = clienteDao.obtenerNombreClientePorId(idCliente);

    if (nombreCliente == null) {
        JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID ingresado.");
        return; // Salir si no se encuentra el cliente
    }

    // Solicitar el tipo de pan
    String tipoPan = JOptionPane.showInputDialog(null, "Ingrese el tipo de pan:");
    if (tipoPan == null || tipoPan.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de pan.");
        return; // Salir si no se ingresa un tipo de pan válido
    }

    // Solicitar la cantidad
    String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad:");
    if (cantidadStr == null || cantidadStr.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad.");
        return; // Salir si no se ingresa una cantidad válida
    }

    // Convertir la cantidad a entero y validarla
    int cantidad = Integer.parseInt(cantidadStr.trim());
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
        return; // Salir si la cantidad no es válida
    }

    // Solicitar el valor unitario
    String valorUnitarioStr = JOptionPane.showInputDialog(null, "Ingrese el valor unitario del pan:");
    if (valorUnitarioStr == null || valorUnitarioStr.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar el valor unitario.");
        return; // Salir si no se ingresa un valor unitario válido
    }

    // Convertir el valor unitario a double
    double valorUnitario = Double.parseDouble(valorUnitarioStr.trim());

    // Solicitar la fecha de entrega
    String fechaEntrega = JOptionPane.showInputDialog(null, "Ingrese la fecha de entrega (YYYY-MM-DD):");
    if (fechaEntrega == null || fechaEntrega.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de entrega.");
        return; // Salir si no se ingresa una fecha válida
    }

    // Validar el formato de la fecha
    java.sql.Date fechaEntregaDate;
    try {
        fechaEntregaDate = java.sql.Date.valueOf(fechaEntrega.trim());
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "La fecha debe estar en el formato YYYY-MM-DD.");
        return; // Salir si la fecha no es válida
    }

    // Solicitar el estado del pedido
    String estado = JOptionPane.showInputDialog(null, "Ingrese el estado del pedido (Pendiente, Entregado, etc.):");
    if (estado == null || estado.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar el estado del pedido.");
        return; // Salir si no se ingresa un estado válido
    }

    // Crear un objeto Pedido con los datos recopilados
    Pedido pedido = new Pedido(
        0, // ID del pedido (0 al registrar, será asignado automáticamente)
        idCliente,
        nombreCliente,
        tipoPan,
        cantidad,
        fechaEntregaDate,
        estado,
        valorUnitario // Se calcula automáticamente
    );

    // Insertar el pedido en la base de datos
    PedidoDAO pedidoDao = new PedidoDAO();
    if (pedidoDao.registrarPedido(pedido)) { // Método en PedidoDAO para registrar
        JOptionPane.showMessageDialog(null, "Pedido registrado con éxito.");

        // Agregar el pedido directamente a la tabla para reflejar los cambios
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
        modeloTabla.addRow(new Object[]{
            pedido.getIdPedido(),        // El ID del pedido
            pedido.getIdCliente(),       // ID del cliente
            pedido.getNombreCliente(),   // Nombre del cliente
            pedido.getTipoPan(),         // Tipo de pan
            pedido.getCantidad(),        // Cantidad
            pedido.getFechaEntrega(),    // Fecha de entrega
            pedido.getEstado(),          // Estado del pedido
            pedido.getValorUnitario(),   // Valor unitario
            pedido.calcularTotal()       // Total calculado
        });

    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el pedido. Verifique los datos.");
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos en los campos numéricos.");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage());
}




  
    }//GEN-LAST:event_btnRegistrarPedidosActionPerformed

    private void btnEditarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPedidosActionPerformed
    
int filaSeleccionada = tablaPedidos.getSelectedRow();
if (filaSeleccionada < 0) {
    JOptionPane.showMessageDialog(null, "Seleccione un pedido para editar.");
    return; // Salir si no hay selección
}

try {
    // Obtener los valores del pedido seleccionado
    int idPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSeleccionada, 0).toString());
    int idCliente = Integer.parseInt(tablaPedidos.getValueAt(filaSeleccionada, 1).toString());
    String tipoPan = tablaPedidos.getValueAt(filaSeleccionada, 3).toString();
    int cantidad = Integer.parseInt(tablaPedidos.getValueAt(filaSeleccionada, 4).toString());
    String fechaEntrega = tablaPedidos.getValueAt(filaSeleccionada, 5).toString();
    String estado = tablaPedidos.getValueAt(filaSeleccionada, 6).toString();
    double valorUnitario = Double.parseDouble(tablaPedidos.getValueAt(filaSeleccionada, 7).toString());
    double total = Double.parseDouble(tablaPedidos.getValueAt(filaSeleccionada, 8).toString());

    // Solicitar nuevos valores al usuario
    String nuevoIdClienteStr = JOptionPane.showInputDialog(null, "ID Cliente:", idCliente);
    String nuevoTipoPan = JOptionPane.showInputDialog(null, "Tipo de Pan:", tipoPan);
    String nuevaCantidadStr = JOptionPane.showInputDialog(null, "Cantidad:", cantidad);
    String nuevoValorUnitarioStr = JOptionPane.showInputDialog(null, "Valor Unitario:", valorUnitario);
    String nuevaFechaEntrega = JOptionPane.showInputDialog(null, "Fecha de Entrega (YYYY-MM-DD):", fechaEntrega);
    String nuevoEstado = JOptionPane.showInputDialog(null, "Estado:", estado);

    // Validar los datos ingresados
    if (nuevoIdClienteStr == null || nuevoIdClienteStr.trim().isEmpty() ||
        nuevoTipoPan == null || nuevoTipoPan.trim().isEmpty() ||
        nuevaCantidadStr == null || nuevaCantidadStr.trim().isEmpty() ||
        nuevoValorUnitarioStr == null || nuevoValorUnitarioStr.trim().isEmpty() ||
        nuevaFechaEntrega == null || nuevaFechaEntrega.trim().isEmpty() ||
        nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe completar todos los campos.");
        return; // Salir si algún campo está vacío
    }

    // Convertir los valores ingresados
    int nuevoIdCliente = Integer.parseInt(nuevoIdClienteStr.trim());
    int nuevaCantidad = Integer.parseInt(nuevaCantidadStr.trim());
    double nuevoValorUnitario = Double.parseDouble(nuevoValorUnitarioStr.trim());

    // Calcular el nuevo total
    double nuevoTotal = nuevaCantidad * nuevoValorUnitario;

    // Validar el formato de la fecha
    java.sql.Date nuevaFechaEntregaDate;
    try {
        nuevaFechaEntregaDate = java.sql.Date.valueOf(nuevaFechaEntrega.trim());
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "La fecha debe estar en el formato YYYY-MM-DD.");
        return; // Salir si la fecha no es válida
    }

    // Verificar si el ID del cliente existe y obtener el nombre
    ClienteDAO clienteDao = new ClienteDAO();
    String nombreCliente = clienteDao.obtenerNombreClientePorId(nuevoIdCliente);
    if (nombreCliente == null) {
        JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID ingresado.");
        return; // Salir si no se encuentra el cliente
    }

    // Crear el objeto Pedido con los nuevos datos
    Pedido pedidoEditado = new Pedido(
        idPedido, 
        nuevoIdCliente, 
        nombreCliente, 
        nuevoTipoPan, 
        nuevaCantidad, 
        nuevaFechaEntregaDate, 
        nuevoEstado, 
        nuevoValorUnitario
    );

    // Actualizar el pedido en la base de datos
    PedidoDAO dao = new PedidoDAO();
    if (dao.actualizarPedido(pedidoEditado)) { // Método en PedidoDAO para actualizar
        JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito.");

        // Actualizar la tabla manualmente sin recargar todo
        tablaPedidos.setValueAt(nuevoIdCliente, filaSeleccionada, 1); // ID Cliente
        tablaPedidos.setValueAt(nombreCliente, filaSeleccionada, 2); // Nombre Cliente
        tablaPedidos.setValueAt(nuevoTipoPan, filaSeleccionada, 3); // Tipo de Pan
        tablaPedidos.setValueAt(nuevaCantidad, filaSeleccionada, 4); // Cantidad
        tablaPedidos.setValueAt(nuevaFechaEntrega, filaSeleccionada, 5); // Fecha de Entrega
        tablaPedidos.setValueAt(nuevoEstado, filaSeleccionada, 6); // Estado
        tablaPedidos.setValueAt(nuevoValorUnitario, filaSeleccionada, 7); // Valor Unitario
        tablaPedidos.setValueAt(nuevoTotal, filaSeleccionada, 8); // Total
    } else {
        JOptionPane.showMessageDialog(null, "Error al actualizar el pedido.");
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos en los campos numéricos.");
} catch (IllegalArgumentException e) {
    JOptionPane.showMessageDialog(null, "La fecha debe estar en el formato YYYY-MM-DD.");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage());
}





    
    // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarPedidosActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
  
        int filaSeleccionada = tablaPedidos.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un pedido para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este pedido?");
        if (confirmacion == JOptionPane.YES_OPTION) {
            int idPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSeleccionada, 0).toString());
            PedidoDAO dao = new PedidoDAO();
            if (dao.eliminarPedido(idPedido)) {
                JOptionPane.showMessageDialog(null, "Pedido eliminado con éxito.");
                cargarPedidos(); // Refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el pedido.");
            }
        }
    }   

        private void filtrarPedidosPorCliente(String cliente) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void jScrollPaneAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jScrollPaneAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPaneAncestorAdded

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

    // Obtener el nombre del cliente desde el campo de texto
String nombreCliente = txtBuscarCliente.getText().trim();

// Validar si el campo está vacío
if (nombreCliente.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de cliente para buscar.");
    return;
}

// Limpiar la tabla antes de cargar los resultados
DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
modeloTabla.setRowCount(0);

// Crear una instancia del DAO para realizar la búsqueda
PedidoDAO pedidoDao = new PedidoDAO();
List<Pedido> pedidos = pedidoDao.buscarPedidosPorCliente(nombreCliente);

// Verificar si se encontraron resultados
if (pedidos.isEmpty()) {
    JOptionPane.showMessageDialog(this, "No se encontraron pedidos para el cliente ingresado.");
    return;
}

// Agregar los resultados a la tabla
for (Pedido pedido : pedidos) {
    modeloTabla.addRow(new Object[]{
        pedido.getIdPedido(),          // ID del Pedido
        pedido.getIdCliente(),         // ID del Cliente
        pedido.getNombreCliente(),     // Nombre del Cliente
        pedido.getTipoPan(),           // Tipo de Pan
        pedido.getCantidad(),          // Cantidad
        pedido.getFechaEntrega(),      // Fecha de Entrega
        pedido.getEstado(),            // Estado del Pedido
        pedido.getValorUnitario(),     // Valor Unitario
        pedido.calcularTotal()         // Total calculado (Cantidad * Valor Unitario)
    });
}

// Mostrar un mensaje indicando que la búsqueda se completó
JOptionPane.showMessageDialog(this, "Búsqueda completada.");




    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed

   
    String cliente = txtBuscarCliente.getText().trim();
    if (cliente.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un nombre para buscar.");
    } else {
        filtrarPedidosPorCliente(cliente);
    }




  // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
     
    // Cerrar la ventana actual
    this.dispose();


// TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEditarPedidos;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnRegistrarPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables

    
}