/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 * Clase DAO, permite acceder a las operaciones basicas de los objetos.
 * datosEstudiante(), me permite mostrar lo que contiene el arreglo.
 * buscarEstudiante(), busca el contenido de un estudiante por medio del correo institucional.
 * agregarEstudiante(), agrega un estudiante al arreglo.
 * borrarEstudiant(), borra o elimina del arreglo los datos de un estudiante.
 * @author LEONARDO
 */
public class EstudianteDAO {

    public EstudianteDAO() {
    }
    
    
    /**
     * Para mostrar los datos almacenados en el arreglo, retorna un string con el contenido del arraylist.
     * @param estudiantes
     * @return 
     */
    public String datosEstudiantes(ArrayList<Estudiante> estudiantes){
        String datos = "";
        for(int i = 0; i<estudiantes.size(); i++){
            datos = datos.concat(estudiantes.get(i) + "\n");
        }
        return datos;
    }
    /**
     * metodo para buscar un estudiante por medio del correo institucional, retorna un objeto tipo estudiante.
     * @param correoIns
     * @param estudiantes
     * @return 
     */
    
    public Estudiante buscarEstudiante(String correoIns, ArrayList<Estudiante> estudiantes){
        Estudiante encontrado = null;
        if (!estudiantes.isEmpty()){
            for (int i=0; i<estudiantes.size(); i++){
                if (estudiantes.get(i).getCorreoIns().equals(correoIns)){
                    encontrado = estudiantes.get(i);
                }
            }
        }
        return encontrado;
    }
    /**
     * Agrega un objeto tipo estudiante y retorna un true si se añadio y false si no se pudo.
     * Crea un objeto tipo estudiante llamandolo nuevo. 
     * Busca al estudiante nuevo por medio del correo institucional (correoIns) en el arraylist, si se obtiene 
     * un null lo agregara gracias al add y retorna un true, si se obtiene diferente de null retornara un folse.
     * @param nombre
     * @param apellidos
     * @param nacimiento
     * @param correoIns
     * @param correoPer
     * @param celular
     * @param fijo
     * @param programa
     * @param estudiantes
     * @return 
     */
    public boolean agregarEstudiante(String nombre, String apellidos, String nacimiento, String correoIns, String correoPer, long celular, long fijo, String programa, ArrayList<Estudiante> estudiantes){
        Estudiante nuevo = new Estudiante(nombre, apellidos, nacimiento, correoIns, correoPer, celular, fijo, programa);
        if (buscarEstudiante(correoIns, estudiantes) == null){
            estudiantes.add(nuevo);
            return true;
        }else{
            return false;
        }
    }
    /**
     * Borra a un estudiante por medio del correo institucional en el arraylist. Si la respuesta es diferente de null
     * el estudiante sera borrado con remove y retorna un true, en caso contrario retornara un false y no borrara ningun dato.
     * @param correoIns
     * @param estudiantes
     * @return 
     */
    public boolean borrarEstudiante(String correoIns, ArrayList<Estudiante> estudiantes){
        boolean borrar = false;
        Estudiante alumno = buscarEstudiante(correoIns, estudiantes);
        if (alumno!=null){
            estudiantes.remove(alumno);
            borrar = true;
        }
        return borrar;
    }
}
