// Esta clase representa un pedido de productos y guarda la información necesaria para administrarlo.
package modelo;

import java.util.Date; // Importa la clase Date para trabajar con fechas.

public class Pedido {
    // Estas son las variables que guardan la información de un pedido.
    private int idPedido;          // ID único del pedido.
    private int idCliente;         // ID del cliente que hizo el pedido.
    private String nombreCliente;  // Nombre del cliente (opcional).
    private String tipoPan;        // Tipo de pan solicitado en el pedido.
    private int cantidad;          // Cantidad de pan que se pidió.
    private Date fechaEntrega;     // Fecha en que se debe entregar el pedido.
    private String estado;         // Estado del pedido (ejemplo: "Pendiente", "Entregado").
    private double valorUnitario;  // Precio por unidad del producto.

    // Este constructor permite crear un pedido con toda la información, incluyendo el nombre del cliente y el valor unitario.
    public Pedido(int idPedido, int idCliente, String nombreCliente, String tipoPan, int cantidad, 
                  Date fechaEntrega, String estado, double valorUnitario) {
        this.idPedido = idPedido; // Asigna el ID del pedido.
        this.idCliente = idCliente; // Asigna el ID del cliente.
        this.nombreCliente = nombreCliente; // Asigna el nombre del cliente.
        this.tipoPan = tipoPan; // Asigna el tipo de pan.
        this.cantidad = cantidad; // Asigna la cantidad pedida.
        this.fechaEntrega = fechaEntrega; // Asigna la fecha de entrega.
        this.estado = estado; // Asigna el estado del pedido.
        this.valorUnitario = valorUnitario; // Asigna el valor unitario del producto.
    }

    // Este constructor alternativo permite crear un pedido sin incluir el nombre del cliente ni el valor unitario.
    public Pedido(int idPedido, int idCliente, String tipoPan, int cantidad, 
                  Date fechaEntrega, String estado) {
        // Llama al constructor principal pero deja el nombre del cliente como "null" y el valor unitario como 0.0.
        this(idPedido, idCliente, null, tipoPan, cantidad, fechaEntrega, estado, 0.0);
    }

    // Métodos "getters" y "setters".
    // Los "getters" sirven para obtener la información de una variable, y los "setters" para modificarla.

    public int getIdPedido() {
        return idPedido; // Devuelve el ID del pedido.
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido; // Cambia el ID del pedido.
    }

    public int getIdCliente() {
        return idCliente; // Devuelve el ID del cliente.
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente; // Cambia el ID del cliente.
    }

    public String getNombreCliente() {
        return nombreCliente; // Devuelve el nombre del cliente.
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente; // Cambia el nombre del cliente.
    }

    public String getTipoPan() {
        return tipoPan; // Devuelve el tipo de pan.
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan; // Cambia el tipo de pan.
    }

    public int getCantidad() {
        return cantidad; // Devuelve la cantidad pedida.
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad; // Cambia la cantidad pedida.
    }

    public Date getFechaEntrega() {
        return fechaEntrega; // Devuelve la fecha de entrega.
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega; // Cambia la fecha de entrega.
    }

    public String getEstado() {
        return estado; // Devuelve el estado del pedido.
    }

    public void setEstado(String estado) {
        this.estado = estado; // Cambia el estado del pedido.
    }

    public double getValorUnitario() {
        return valorUnitario; // Devuelve el valor unitario.
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario; // Cambia el valor unitario.
    }

    // Este método calcula el valor total del pedido multiplicando la cantidad por el precio unitario.
    public double calcularTotal() {
        return this.cantidad * this.valorUnitario;
    }

    // Este método convierte toda la información del pedido en texto, útil para mostrar o depurar datos.
    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido + // Muestra el ID del pedido.
                ", idCliente=" + idCliente + // Muestra el ID del cliente.
                ", nombreCliente='" + (nombreCliente != null ? nombreCliente : "N/A") + '\'' + // Muestra el nombre del cliente (si existe).
                ", tipoPan='" + tipoPan + '\'' + // Muestra el tipo de pan.
                ", cantidad=" + cantidad + // Muestra la cantidad pedida.
                ", fechaEntrega=" + (fechaEntrega != null ? fechaEntrega : "N/A") + // Muestra la fecha de entrega (si existe).
                ", estado='" + estado + '\'' + // Muestra el estado del pedido.
                ", valorUnitario=" + valorUnitario + // Muestra el valor unitario.
                ", total=" + calcularTotal() + // Calcula y muestra el total.
                '}';
    }
}
