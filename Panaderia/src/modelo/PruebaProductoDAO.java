
package modelo;

public class PruebaProductoDAO {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        // 1. Listar productos
        System.out.println("Lista de Productos:");
        for (Producto p : productoDAO.listarProductos()) {
            System.out.println("ID: " + p.getIdProducto() + 
                               ", Nombre: " + p.getNombreProducto() + 
                               ", Precio: $" + p.getPrecioUnitario());
        }

        // 2. Agregar un nuevo producto
        Producto nuevoProducto = new Producto(0, "Pan de Molde", 300.00);
        if (productoDAO.agregarProducto(nuevoProducto)) {
            System.out.println("Producto agregado con éxito.");
        } else {
            System.out.println("Error al agregar producto.");
        }

        // 3. Actualizar un producto existente
        Producto productoActualizar = new Producto(0, "Baguette", 850.00);
        if (productoDAO.actualizarProducto(productoActualizar)) {
            System.out.println("Producto actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar producto.");
        }
    }
}
