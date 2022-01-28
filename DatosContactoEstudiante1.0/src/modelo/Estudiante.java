/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LEONARDO
 */
public class Estudiante {
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String correoIns;
    private String correoPer;
    private long celular;
    private long fijo;
    private String programa;

    public Estudiante() {
    }
    /**
     * 
     * @param nombre
     * @param apellidos
     * @param nacimiento
     * @param correoIns
     * @param correoPer
     * @param celular
     * @param fijo
     * @param programa 
     */
    public Estudiante(String nombre, String apellidos, String nacimiento, String correoIns, String correoPer, long celular, long fijo, String programa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.correoIns = correoIns;
        this.correoPer = correoPer;
        this.celular = celular;
        this.fijo = fijo;
        this.programa = programa;
    }
    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * 
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
/**
 * 
 * @return 
 */
    public String getNacimiento() {
        return nacimiento;
    }
/**
 * 
 * @param nacimiento 
 */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
/**
 * 
 * @return 
 */
    public String getCorreoIns() {
        return correoIns;
    }
/**
 * 
 * @param correoIns 
 */
    public void setCorreoIns(String correoIns) {
        this.correoIns = correoIns;
    }
/**
 * 
 * @return 
 */
    public String getCorreoPer() {
        return correoPer;
    }
/**
 * 
 * @param correoPer 
 */
    public void setCorreoPer(String correoPer) {
        this.correoPer = correoPer;
    }
/**
 * 
 * @return 
 */
    public long getCelular() {
        return celular;
    }
/**
 * 
 * @param celular 
 */
    public void setCelular(long celular) {
        this.celular = celular;
    }
/**
 * 
 * @return 
 */
    public long getFijo() {
        return fijo;
    }
/**
 * 
 * @param fijo 
 */
    public void setFijo(long fijo) {
        this.fijo = fijo;
    }
/**
 * 
 * @return 
 */
    public String getPrograma() {
        return programa;
    }
/**
 * 
 * @param programa 
 */
    public void setPrograma(String programa) {
        this.programa = programa;
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "\nDatos Estudiante:" + "\n" +
                "\nNombre              : " + nombre + 
                "\nApellidos           : " + apellidos + 
                "\nFecha de Nacimiento : " + nacimiento + 
                "\nCorreo Institucional: " + correoIns + 
                "\nCorreo Personal     : " + correoPer + 
                "\nNumero Celular      : " + celular + 
                "\nNumero Telefono fijo: " + fijo + 
                "\nPrograma            : " + programa;
    }
    
}
