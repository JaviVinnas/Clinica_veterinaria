package baseDatos;

import aplicacion.Trabajador;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOCitas daoCitas;
    private DAOClinica daoClinica;
    private DAODatos daoDatos;
    private DAOPacientes daoPacientes;

    // Constructor: establecer conexion con la base de datos
    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            daoCitas = new DAOCitas(conexion, fa);
            daoClinica = new DAOClinica(conexion, fa);
            daoDatos = new DAODatos(conexion, fa);
            daoPacientes = new DAOPacientes(conexion, fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }
    }
    
    /* DAOCitas */
    
    /* DAOClinica */
    
    public Trabajador usuarioValidado(String DNI, String clave) {
        return daoClinica.usuarioValidado(DNI, clave);
    }
    
    /* DAODatos */
    
    /* DAOPacientes */
    
}
