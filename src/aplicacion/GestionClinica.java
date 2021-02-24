package aplicacion;

import interfaz.FachadaInterfaz;
import baseDatos.FachadaBaseDatos;

public class GestionClinica {

    FachadaInterfaz fgui;
    FachadaBaseDatos fbd;

    public GestionClinica(FachadaInterfaz fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public Boolean comprobarAutenticacion(String DNI, String clave) {
        return fbd.usuarioValidado(DNI, clave) != null;
    }

}
