package aplicacion;

public class FachadaAplicacion {

    interfaz.FachadaInterfaz finterfaz;
    baseDatos.FachadaBaseDatos fbd;
    GestionClinica gc;
    //GestionUsuarios cu;
    //GestionCategorias cc;

    public FachadaAplicacion() {
        finterfaz = new interfaz.FachadaInterfaz(this);    //Crea la VPrincipal
        fbd = new baseDatos.FachadaBaseDatos(this);
        gc = new GestionClinica(finterfaz, fbd);
        //cu = new GestionUsuarios(fgui, fbd);
        //cc = new GestionCategorias(fgui, fbd);
    }

    public static void main(String args[]) {
        FachadaAplicacion fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }
    
    public void iniciaInterfazUsuario() {
        finterfaz.iniciaVista();
    }
    
    public void muestraExcepcion(String e) {
        finterfaz.muestraExcepcion(e);
    }
    
    /* Gestion Citas */
    
    /* Gestion Clinica */
    
    public Boolean comprobarAutenticacion(String DNI, String clave) {
        return gc.comprobarAutenticacion(DNI, clave);
    }
    
    /* Gestion Datos */
    
    /* Gestion Pacientes */
    
}
