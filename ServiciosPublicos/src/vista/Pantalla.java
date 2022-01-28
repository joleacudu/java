/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
/**
 *
 * @author LEONARDO
 */
public class Pantalla {
    public static void ingresarDatos(int consumo, String unidad, double valor, int estrato, double costo, double desSob, double impuesto, double total){  
    System.out.println("");
    System.out.println("\t========================================================");
    System.out.println("\t              PAGO DE SERVICIOS PÚBLICOS");
    System.out.println("\t========================================================");
    System.out.println("\tDatos del consumo del inmueble, descuento o sobrecosto,");
    System.out.println("\t        el1 impuestos y lo que se debe pagar.");
    System.out.println("\t========================================================");
    System.out.println("\tEl consumo fue              : " + consumo + unidad);
    System.out.println("\tValor unidad                : " +"$"+ valor + " Pesos");
    System.out.println("\tEstrato del inmueble        : " + estrato);
    System.out.println("\tCosto total                 : " +"$"+ costo + " Pesos");
    System.out.println("\tDescuento o sobrecosto      : " +"$"+ (desSob *-1) + " Pesos");
    System.out.println("\tImpuesto por infraestructura: " +"$"+ impuesto+ " Pesos");
    System.out.println("\tTOTAL A PAGAR               : " +"$"+ total + " Pesos");
    System.out.println("\t=========================================================");
    System.out.println("");
    

}
        
}

