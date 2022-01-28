package modelo;

/**
 *
 * @author LEONARDO
 */
public class Estudiante {
    /**
     * Clase Empleado con los Atributo del Objeto a usar en el Proyecto
     * Declarar Atributos
     */
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long telefonoCelular;
    private long telefonoFijo;
    private String programa;
    
    // Constructores

    public Estudiante() {
    }
    
    /**
     * 
     * @param nombres
     * @param apellidos
     * @param fechaNacimiento
     * @param correoInstitucional
     * @param correoPersonal
     * @param telefonoCelular
     * @param telefonoFijo
     * @param programa 
     */

    public Estudiante(String nombres, String apellidos, String fechaNacimiento, String correoInstitucional, String correoPersonal, long telefonoCelular, long telefonoFijo, String programa) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.telefonoCelular = telefonoCelular;
        this.telefonoFijo = telefonoFijo;
        this.programa = programa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public long getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(long telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public long getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(long telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return   "Nombres: " + nombres + 
                "\nApellidos: " + apellidos + 
                "\nFecha de Ingreso: " + fechaNacimiento + 
                "\nCorreo institucional: " + correoInstitucional + 
                "\nCorreo personal: " + correoPersonal + 
                "\nNúmero de teléfono celular: " + telefonoCelular + 
                "\nNúmero de teléfono fijo: " + telefonoFijo + 
                "\nPrograma: " + programa + "\n";
    }
    
}
