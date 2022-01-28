/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

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
    
    //constructor
    public EstudianteDTO() {
        estudiantes = new ArrayList<Estudiante>();
        estudianteDAO = new EstudianteDAO();
    }
    
    //Set y Get
/**
 * 
 * @return 
 */
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
/**
 * 
 * @param estudiantes 
 */
    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
/**
 * 
 * @return 
 */
    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }
/**
 * 
 * @param estudianteDAO 
 */
    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }
    
    
    
}
