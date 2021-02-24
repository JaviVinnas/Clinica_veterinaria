package aplicacion;

import interfaz.FachadaInterfaz;
import baseDatos.FachadaBaseDatos;

public class GestionDatos {

    FachadaInterfaz fgui;
    FachadaBaseDatos fbd;

    public GestionDatos(FachadaInterfaz fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    /*public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u = fbd.validarUsuario(idUsuario, clave);
        return u != null &&  u.getTipoUsuario() == TipoUsuario.Administrador;
    }*/

}
