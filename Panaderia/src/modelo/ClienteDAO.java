/*
 * Esta clase se encarga de realizar las operaciones relacionadas con los clientes en la base de datos.
 * Utiliza consultas SQL para buscar, listar, agregar, actualizar y eliminar clientes.
 */
package modelo;

import conexion.Conexion; // Importa la clase que maneja la conexión con la base de datos.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    // Este método busca los IDs de los clientes cuyo nombre contiene una palabra o frase específica.
    public List<Integer> buscarIdsPorNombre(String nombre) {
        List<Integer> idsClientes = new ArrayList<>();
        String sql = "SELECT id_cliente FROM clientes WHERE nombre LIKE ?"; // Consulta SQL para buscar IDs por nombre.
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%"); // Configura la consulta para buscar nombres que contengan la palabra.
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                idsClientes.add(rs.getInt("id_cliente")); // Agrega cada ID encontrado a la lista.
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar IDs por nombre: " + e.getMessage());
        }
        
        return idsClientes; // Devuelve la lista de IDs encontrados.
    }

    // Este método devuelve una lista con todos los clientes almacenados en la base de datos.
    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes"; // Consulta para obtener todos los clientes.
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Crea un cliente por cada fila de resultados y lo agrega a la lista.
                lista.add(new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista; // Devuelve la lista de clientes.
    }

    // Este método busca clientes cuyos nombres contienen una palabra específica.
    public List<Cliente> buscarClientesPorNombre(String nombre) {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nombre LIKE ?"; // Consulta SQL para buscar clientes por nombre.
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%"); // Configura la consulta para buscar parcialmente por nombre.
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                // Crea un cliente por cada resultado y lo agrega a la lista.
                Cliente cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar clientes por nombre: " + e.getMessage());
        }
        
        return listaClientes; // Devuelve la lista de clientes encontrados.
    }

    // Este método agrega un nuevo cliente a la base de datos.
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, telefono, direccion) VALUES (?, ?, ?)"; // Consulta para agregar un cliente.
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre()); // Configura el nombre.
            ps.setString(2, cliente.getTelefono()); // Configura el teléfono.
            ps.setString(3, cliente.getDireccion()); // Configura la dirección.
            return ps.executeUpdate() > 0; // Devuelve true si se agregó correctamente.
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }

    // Este método elimina un cliente usando su ID.
    public boolean eliminarCliente(int idCliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?"; // Consulta para eliminar un cliente.
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente); // Configura el ID del cliente a eliminar.
            return ps.executeUpdate() > 0; // Devuelve true si se eliminó correctamente.
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    // Este método actualiza los datos de un cliente existente.
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, direccion = ? WHERE id_cliente = ?"; // Consulta para actualizar un cliente.
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre()); // Configura el nuevo nombre.
            ps.setString(2, cliente.getTelefono()); // Configura el nuevo teléfono.
            ps.setString(3, cliente.getDireccion()); // Configura la nueva dirección.
            ps.setInt(4, cliente.getIdCliente()); // Configura el ID del cliente a actualizar.
            return ps.executeUpdate() > 0; // Devuelve true si se actualizó correctamente.
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Este método obtiene el nombre de un cliente según su ID.
    public String obtenerNombreClientePorId(int idCliente) {
        String nombreCliente = null;
        String sql = "SELECT nombre FROM clientes WHERE id_cliente = ?"; // Consulta para obtener el nombre por ID.
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente); // Configura el ID del cliente.
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreCliente = rs.getString("nombre"); // Almacena el nombre encontrado.
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del cliente: " + e.getMessage());
        }
        return nombreCliente; // Devuelve el nombre del cliente.
    }
}
