// Esta clase representa un producto y guarda información básica como su ID, nombre y precio unitario.
package modelo;

public class Producto {
    // Variables que guardan la información del producto.
    private int idProducto;          // ID único del producto.
    private String nombreProducto;   // Nombre del producto.
    private double precioUnitario;   // Precio por unidad del producto.

    // Constructor vacío.
    // Se utiliza para crear un producto sin información inicial.
    public Producto() {
    }

    // Constructor con parámetros.
    // Permite crear un producto desde el inicio con todos sus datos.
    public Producto(int idProducto, String nombreProducto, double precioUnitario) {
        this.idProducto = idProducto;          // Asigna el ID del producto.
        this.nombreProducto = nombreProducto; // Asigna el nombre del producto.
        this.precioUnitario = precioUnitario; // Asigna el precio unitario del producto.
    }

    // Métodos "getters" y "setters".
    // Los "getters" sirven para obtener la información de una variable, y los "setters" para modificarla.

    public int getIdProducto() {
        return idProducto; // Devuelve el ID del producto.
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto; // Cambia el ID del producto.
    }

    public String getNombreProducto() {
        return nombreProducto; // Devuelve el nombre del producto.
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto; // Cambia el nombre del producto.
    }

    public double getPrecioUnitario() {
        return precioUnitario; // Devuelve el precio unitario del producto.
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario; // Cambia el precio unitario del producto.
    }
}
