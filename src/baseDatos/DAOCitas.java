package baseDatos;

import java.sql.*;

public class DAOCitas extends AbstractDAO {

    public DAOCitas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

}
