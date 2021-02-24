package baseDatos;

import java.sql.*;

public class DAODatos extends AbstractDAO {

    public DAODatos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

}
