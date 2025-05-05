// Esta clase se encarga de manejar todas las operaciones relacionadas con los pedidos en la base de datos.
// Permite listar, registrar, actualizar, eliminar y buscar pedidos utilizando consultas SQL.
package modelo;

import conexion.Conexion; // Importa la clase para conectar con la base de datos.
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    // Este método lista todos los pedidos guardados en la base de datos.
    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos = new ArrayList<>();
        String sql = "SELECT id_pedido, id_cliente, nombre_cliente, tipo_pan, cantidad, fecha_entrega, estado, valor_unitario " +
                     "FROM pedidos";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorre cada fila en los resultados y crea un objeto Pedido.
            while (rs.next()) {
                Pedido pedido = new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getInt("id_cliente"),
                    rs.getString("nombre_cliente"),
                    rs.getString("tipo_pan"),
                    rs.getInt("cantidad"),
                    rs.getDate("fecha_entrega"),
                    rs.getString("estado"),
                    rs.getDouble("valor_unitario")
                );
                listaPedidos.add(pedido); // Agrega el pedido a la lista.
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }

        return listaPedidos; // Devuelve la lista completa de pedidos.
    }

    // Este método registra un nuevo pedido en la base de datos.
    public boolean registrarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (id_cliente, nombre_cliente, tipo_pan, cantidad, fecha_entrega, estado, valor_unitario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, pedido.getIdCliente()); // Asigna el ID del cliente.
            ps.setString(2, pedido.getNombreCliente()); // Asigna el nombre del cliente.
            ps.setString(3, pedido.getTipoPan()); // Asigna el tipo de pan.
            ps.setInt(4, pedido.getCantidad()); // Asigna la cantidad pedida.
            ps.setDate(5, new Date(pedido.getFechaEntrega().getTime())); // Convierte la fecha de entrega.
            ps.setString(6, pedido.getEstado()); // Asigna el estado del pedido.
            ps.setDouble(7, pedido.getValorUnitario()); // Asigna el valor unitario.

            int filasInsertadas = ps.executeUpdate(); // Ejecuta la consulta.

            if (filasInsertadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        pedido.setIdPedido(rs.getInt(1)); // Asigna el ID generado al pedido.
                    }
                }
                return true; // Retorna true si el pedido fue registrado exitosamente.
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el pedido: " + e.getMessage());
        }
        return false; // Retorna false si hubo un error.
    }

    // Este método actualiza los datos de un pedido existente en la base de datos.
    public boolean actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET id_cliente = ?, nombre_cliente = ?, tipo_pan = ?, cantidad = ?, fecha_entrega = ?, estado = ?, valor_unitario = ? WHERE id_pedido = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pedido.getIdCliente()); // Actualiza el ID del cliente.
            ps.setString(2, pedido.getNombreCliente()); // Actualiza el nombre del cliente.
            ps.setString(3, pedido.getTipoPan()); // Actualiza el tipo de pan.
            ps.setInt(4, pedido.getCantidad()); // Actualiza la cantidad.
            ps.setDate(5, new Date(pedido.getFechaEntrega().getTime())); // Actualiza la fecha de entrega.
            ps.setString(6, pedido.getEstado()); // Actualiza el estado.
            ps.setDouble(7, pedido.getValorUnitario()); // Actualiza el valor unitario.
            ps.setInt(8, pedido.getIdPedido()); // Especifica el ID del pedido que se actualizará.

            return ps.executeUpdate() > 0; // Retorna true si se actualizó correctamente.
        } catch (SQLException e) {
            System.out.println("Error al actualizar pedido: " + e.getMessage());
            return false;
        }
    }

    // Este método elimina un pedido de la base de datos usando su ID.
    public boolean eliminarPedido(int idPedido) {
        String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPedido); // Asigna el ID del pedido a eliminar.
            return ps.executeUpdate() > 0; // Retorna true si el pedido fue eliminado.
        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
            return false;
        }
    }

    // Este método busca pedidos en la base de datos por el nombre del cliente.
    public List<Pedido> buscarPedidosPorCliente(String nombreCliente) {
        List<Pedido> listaPedidos = new ArrayList<>();
        String sql = "SELECT id_pedido, id_cliente, nombre_cliente, tipo_pan, cantidad, fecha_entrega, estado, valor_unitario " +
                     "FROM pedidos WHERE nombre_cliente LIKE ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nombreCliente + "%"); // Configura la consulta para buscar parcialmente por nombre.
            ResultSet rs = ps.executeQuery();

            // Crea un objeto Pedido por cada resultado y lo agrega a la lista.
            while (rs.next()) {
                Pedido pedido = new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getInt("id_cliente"),
                    rs.getString("nombre_cliente"),
                    rs.getString("tipo_pan"),
                    rs.getInt("cantidad"),
                    rs.getDate("fecha_entrega"),
                    rs.getString("estado"),
                    rs.getDouble("valor_unitario")
                );
                listaPedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar pedidos por cliente: " + e.getMessage());
        }

        return listaPedidos; // Devuelve la lista de pedidos encontrados.
    }

    // Este método simplemente llama a "listarPedidos" para obtener todos los pedidos.
    public List<Pedido> obtenerTodosLosPedidos() {
        return listarPedidos();
    }
}
