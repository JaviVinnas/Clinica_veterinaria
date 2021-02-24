package baseDatos;

import aplicacion.Trabajador;
import java.sql.*;

public class DAOClinica extends AbstractDAO {

    public DAOClinica(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    // Se devuelve, si se encuentra, un Trabajador según su DNI y clave (validación)
    public Trabajador usuarioValidado(String DNI, String clave) {
        Connection con = this.getConexion();
        PreparedStatement stmTrabajador = null;
        ResultSet rsTrabajador;
        
        Trabajador trabajador = null;

        try {
            stmTrabajador = con.prepareStatement("select DNI, nombre, clave, telefono, direccion, email "
                    + "from trabajador_veterinario "
                    + "where DNI = ? and clave = ? "
                    + "union "
                    + "select DNI, nombre, clave, telefono, direccion, email "
                    + "from trabajador_cuidador "
                    + "where DNI = ? and clave = ? ");
            stmTrabajador.setString(1, DNI);
            stmTrabajador.setString(2, clave);
            stmTrabajador.setString(3, DNI);
            stmTrabajador.setString(4, clave);
            rsTrabajador = stmTrabajador.executeQuery();
            if (rsTrabajador.next()) {
                trabajador = new Trabajador(rsTrabajador.getString("DNI"), rsTrabajador.getString("nombre"), rsTrabajador.getString("clave"),
                        rsTrabajador.getInt("telefono"), rsTrabajador.getString("direccion"), rsTrabajador.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmTrabajador.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        return trabajador;
    }

}
