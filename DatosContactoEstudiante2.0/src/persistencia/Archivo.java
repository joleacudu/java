/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Estudiante;

/**
 *
 * @author LEONARDO
 */
public class Archivo {
    private ObjectInputStream entrada; //entra informacion
    private ObjectOutputStream salida; //Saca informacion
    
    public Archivo(File archivo){
        if(archivo.exists()){
    }else{
            try {
                archivo.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }    
    }
    public void escribirEnArchivo(ArrayList<Estudiante> estudiantes, File archivo){
        try {
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(estudiantes);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }     
    }
    public ArrayList<Estudiante> leerArchivo(File archivo){
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        if(archivo.length() != 0){
            try {
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                estudiantes = (ArrayList<Estudiante>) entrada.readObject();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            } 
        }
        return estudiantes;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }
    
}
