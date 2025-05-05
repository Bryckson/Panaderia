// Esta clase se encarga de realizar operaciones relacionadas con los productos en la base de datos.
// Permite listar, agregar, actualizar y eliminar productos utilizando consultas SQL.
package modelo;

import conexion.Conexion; // Importa la clase para manejar la conexión con la base de datos.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // Este método obtiene todos los productos almacenados en la base de datos.
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id_producto, nombre_producto, precio_unitario FROM Productos";

        try (Connection con = Conexion.conectar(); // Establece la conexión con la base de datos.
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorre cada fila de resultados y crea un objeto Producto con los datos.
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto")); // Asigna el ID del producto.
                producto.setNombreProducto(rs.getString("nombre_producto")); // Asigna el nombre del producto.
                producto.setPrecioUnitario(rs.getDouble("precio_unitario")); // Asigna el precio unitario.
                productos.add(producto); // Agrega el producto a la lista.
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
        return productos; // Devuelve la lista completa de productos.
    }

    // Este método agrega un nuevo producto a la base de datos.
    public boolean agregarProducto(Producto producto) {
        String sql = "INSERT INTO Productos (nombre_producto, precio_unitario) VALUES (?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombreProducto()); // Configura el nombre del producto.
            ps.setDouble(2, producto.getPrecioUnitario()); // Configura el precio unitario.
            ps.executeUpdate(); // Ejecuta la consulta para insertar el producto.
            return true; // Devuelve true si el producto se agregó correctamente.

        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            return false; // Devuelve false si ocurrió un error.
        }
    }

    // Este método actualiza el precio de un producto existente en la base de datos.
    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE Productos SET precio_unitario = ? WHERE id_producto = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, producto.getPrecioUnitario()); // Configura el nuevo precio unitario.
            ps.setInt(2, producto.getIdProducto()); // Especifica el ID del producto a actualizar.
            int filasAfectadas = ps.executeUpdate(); // Ejecuta la consulta.
            return filasAfectadas > 0; // Devuelve true si se actualizó correctamente.

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false; // Devuelve false si ocurrió un error.
        }
    }

    // Este método elimina un producto de la base de datos usando su ID.
    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM Productos WHERE id_producto = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto); // Especifica el ID del producto a eliminar.
            int filasAfectadas = ps.executeUpdate(); // Ejecuta la consulta.
            return filasAfectadas > 0; // Devuelve true si se eliminó correctamente.

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false; // Devuelve false si ocurrió un error.
        }
    }
}
