package baseDatos;

import java.sql.*;

public class DAOPacientes extends AbstractDAO {

    public DAOPacientes(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

}
