/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
import persistencia.Archivo;
import persistencia.EstudianteDAO;

/**
 *
 * @author LEONARDO
 */
public class EstudianteDTO {
    /**
     * declarar los atributos
     * Un arraylist de estudiante llamado estudiantes
     * Un estudianteDAO
     */
    
    private ArrayList<Estudiante> estudiantes; // un arraylist estudiante llamado estudiantes
    private EstudianteDAO estudianteDAO;
    private File file = new File("Datos_Estudiantes.dat");
    private Archivo archivo;
    
    //constructor
    public EstudianteDTO() {
        estudiantes = new ArrayList<Estudiante>();
        archivo = new Archivo(file);
        estudianteDAO = new EstudianteDAO(archivo);
        estudiantes = archivo.leerArchivo(file);
    }
    
    //Set y Get

    
    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }   
    
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    } 
    
}
