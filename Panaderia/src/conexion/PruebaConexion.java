
package conexion;

import java.sql.Connection;


public class PruebaConexion {
    public static void main(String[] args) {
        Connection con = Conexion.conectar();
        if (con != null) {
            System.out.println("¡Conexión realizada con éxito!");
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
}

