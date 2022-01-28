/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;

/**
 * Pantalla para capturar datos desde cualquier origen.
 * @author LEONARDO
 */
public class pantalla {
    //Atributo de la clase para leer datos.
    private Scanner leerDatos;
    
    /**
     * Constructor
     */
    public pantalla() {
        leerDatos = new Scanner(System.in);
    }
    /**
     * Metodo para leer datos tipo string
     * @param mensaje
     * @return 
     */
    public String leerDatosTexto(String mensaje){
        System.out.println(mensaje);
        String dato = leerDatos.nextLine();
        return dato;
    }
    /**
     * Metodo para leer datos tipo long
     * @param mensaje
     * @return 
     */
    public long leerDatosNumericos(String mensaje){
        long dato = 0;
        while(true){
            try {
                System.out.println(mensaje);
                dato = leerDatos.nextLong();
                leerDatos.nextLine();
                break;
            } catch (Exception e) {
                leerDatos.nextLine();
                System.out.println("El dato ingreado es incorrecto, intentelo nuevamente.");
                dato = 0;
                continue;
            }
        }
        return dato;
    }
    /**
     * Metodo para imprimir un mensaje.
     * @param mensaje 
     */
    public void mostrarDatos(String mensaje){
        //System.out.println("");
        System.out.println("\n==================================================================");
        System.out.println(mensaje);
        System.out.println("==================================================================\n");
        //System.out.println("");
    }
}
