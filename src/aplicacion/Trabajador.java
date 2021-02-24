package aplicacion;

public class Trabajador {

    private String DNI;
    private String nombre;
    private String clave;
    private Integer telefono;
    private String direccion;
    private String email;

    public Trabajador(String DNI, String nombre, String clave, Integer telefono, String direccion, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

}
