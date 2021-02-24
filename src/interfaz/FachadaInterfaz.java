package interfaz;

public class FachadaInterfaz {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;

    public FachadaInterfaz(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
    }

    public void iniciaVista() {
        VAutenticacion va;

        va = new VAutenticacion(vp, true, fa);
        vp.setVisible(true);
        va.setVisible(true);
    }

    public void muestraExcepcion(String txtExcepcion) {
        VExcepcion ve = new VExcepcion(vp, true, txtExcepcion);
        ve.setVisible(true);
    }

}
