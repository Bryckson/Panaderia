// Esta clase representa a un cliente y guarda información básica como su ID, nombre, teléfono y dirección.
package modelo;

public class Cliente {
    // Estas son las variables que guardan la información del cliente.
    private int idCliente;      // Guarda un número único para identificar al cliente.
    private String nombre;      // Guarda el nombre del cliente.
    private String telefono;    // Guarda el número de teléfono del cliente.
    private String direccion;   // Guarda la dirección donde vive o trabaja el cliente.

    // Este es un constructor vacío, sirve para crear un cliente sin datos al principio.
    public Cliente() {
    }

    // Este es otro constructor que sirve para crear un cliente desde el principio con todos sus datos.
    public Cliente(int idCliente, String nombre, String telefono, String direccion) {
        this.idCliente = idCliente; // Asigna el ID del cliente.
        this.nombre = nombre;       // Asigna el nombre del cliente.
        this.telefono = telefono;   // Asigna el teléfono del cliente.
        this.direccion = direccion; // Asigna la dirección del cliente.
    }

    // Aquí vienen los métodos "getters" y "setters". 
    // Los "getters" sirven para obtener el valor de una variable, y los "setters" para cambiarlo.

    public int getIdCliente() {
        return idCliente; // Devuelve el ID del cliente.
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente; // Cambia el ID del cliente.
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del cliente.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Cambia el nombre del cliente.
    }

    public String getTelefono() {
        return telefono; // Devuelve el teléfono del cliente.
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono; // Cambia el teléfono del cliente.
    }

    public String getDireccion() {
        return direccion; // Devuelve la dirección del cliente.
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion; // Cambia la dirección del cliente.
    }

    // Este método convierte toda la información del cliente en texto para que sea más fácil de leer.
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente + // Muestra el ID del cliente.
                ", nombre='" + nombre + '\'' + // Muestra el nombre del cliente.
                ", telefono='" + telefono + '\'' + // Muestra el teléfono del cliente.
                ", direccion='" + direccion + '\'' + // Muestra la dirección del cliente.
                '}';
    }
}
