/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Estudiante;
import modelo.EstudianteDTO;
import vista.pantalla;

/**
 * Es el encargado de controlar la ejecucion del programa.
 * @author LEONARDO
 */
public class ControladorMenu {
    
    //declarar atributos
    private pantalla vista;
    private EstudianteDTO instituto;
    
    //contructor incluye la vista, DTO y el Menu (que se ve en la pantalla pricipal)
    public ControladorMenu(){
        //crear los objetos de cada atributo
        vista = new pantalla();
        instituto = new EstudianteDTO();
        Menu(); //llama al menu
    }
    
    private void Menu(){
        // se crea un objeto para hacer captura de datos
        Scanner sc = new Scanner(System.in);
        boolean centinela = true;
        int opcion = 0;
        while(centinela){
                System.out.println("");
                System.out.println("==============================================");
                System.out.println("          INSTITUTO LA FLORESTA");
                System.out.println("==============================================");
                System.out.println("Seleccione una de las opciones del menu:");
                System.out.println("==============================================");
                System.out.println("1. Ingresar un estudiante.");
                System.out.println("2. Buscar estudiante.");
                System.out.println("3. Modificar estudiante.");
                System.out.println("4. Eliminar Estudiante.");
                System.out.println("5. Ver directorio de estudiantes.");
                System.out.println("6. Salir.");
                System.out.println("==============================================");
                System.out.println("");
                try {//para evitar el ingreso de valores errados y causar datos incorrectos.
                    System.out.print("Seleccione la opcion a realizar: ");
                    opcion = sc.nextInt();//este seria el servicio en ingresarDatos().
                    switch(opcion){ // Selecciona la opcion a ejecutar
                            case 1:
                                ingresarEstudiante(); 
                                break; 
                            case 2:
                                buscarEstudiante();
                                break;
                            case 3:
                                modificarEstudiante();
                                break;
                            case 4:
                                borrarEstudiante();
                                break;
                            case 5:
                                directorio();
                                break;
                            case 6:
                                vista.mostrarDatos("Gracias por preferirnos.\n"+"Le deseamos un excelente dia, hasta pronto.");
                                centinela = false;
                                System.exit(0);
                            default:
                                vista.mostrarDatos("Debe ingresar un valor entre 1 y 6.");
                                break;
                    }
            } catch (InputMismatchException e) {
                    vista.mostrarDatos("Debe ingresar un numero entero.");
                    sc.nextLine();
                    sc.nextLine();
            }
        }
    }
    //opcion 1: Se muestra en pantalla mensajes para ir ingresando los datos de los estudiantes que seran almacenados, se añade un condicional para saber si se agrego o no el estudiante.
    public void ingresarEstudiante(){
        String nombre = "", apellidos = "", nacimiento = "", correoIns = "", correoPer = "", programa = "";
        long celular = 0, fijo = 0;
        vista.mostrarDatos("INGRESAR ESTUDIANTE:");
        nombre = vista.leerDatosTexto("Ingrese solo los nombres del Estudiante: ");
        apellidos = vista.leerDatosTexto("Ingrese los apellidos del Estudiante: ");
        nacimiento = vista.leerDatosTexto("Ingrese la fecha de nacimiento del Estudiante: ");
        correoIns = vista.leerDatosTexto("Ingrese el correo institucional del Estudiante: ");
        correoPer = vista.leerDatosTexto("Ingrese el correo personal del Estudiante: ");
        celular = vista.leerDatosNumericos("Ingrese el numero celular del Estudiante: ");
        fijo = vista.leerDatosNumericos("Ingrese el numero fijo del Estudiante: ");
        programa = vista.leerDatosTexto("Ingrese el programa al que pertenece el Estudiante: ");
        
        if(instituto.getEstudianteDAO().agregarEstudiante(nombre, apellidos, nacimiento, correoIns, correoPer, celular, fijo, programa, instituto.getEstudiantes(), instituto.getFile())){
            vista.mostrarDatos("Se agrego al estudiante con exito.");
        }else{
            vista.mostrarDatos("No fue posible agregar al estudiante, intentelo nuevamente.");
        }
    }
    // opcion 2: por medio de scanner se lee el correo institucional y procede a buscar, con un condicional donde resultado sea diferente de null imprimira en consola los datos recuperados.
    // en caso de ser igual a null mostrara un mensaje de prdefinido.
    public void buscarEstudiante(){
        // se crea un objeto para hacer captura de datos
        Scanner sc = new Scanner(System.in);
        String correoIns = "";
        vista.mostrarDatos("BUSCAR ESTUDIANTE" + "\nIngrese el correo institucional: ");
        correoIns = sc.nextLine();
        Estudiante resultado = instituto.getEstudianteDAO().buscarEstudiante(correoIns, instituto.getEstudiantes());
        if(resultado != null){
            vista.mostrarDatos(resultado.toString());
        }else{
            vista.mostrarDatos("El estudiante no se encuentra registrado en la base de datos");
        }
    }
    // opcion 3: se ingresa por consola el correo institucional, con un condicional se leen nuevamente los datos, luego se borra el registro que se busco y se sobreescribe 
    // con la nueva informacion registrada y se muestra el respectivo mensaje si se logro o no modificar dicho registro.
    public void modificarEstudiante(){
        String nombre = "", apellidos = "", nacimiento = "", correoIns = null, correoPer = "", programa = "";
        long celular = 0, fijo = 0;
        correoIns = vista.leerDatosTexto("MODIFICAR ESTUDIANTE." + "\nIngrese el correo institucional: ");
        Estudiante resultado = instituto.getEstudianteDAO().buscarEstudiante(correoIns, instituto.getEstudiantes());
        if (resultado != null){
            nombre = resultado.getNombre();
            apellidos = resultado.getApellidos();
            nacimiento = resultado.getNacimiento();
            correoPer = vista.leerDatosTexto("Ingresar correo personal del estudiante: ");
            celular = vista.leerDatosNumericos("Ingresar numero celular: ");
            fijo = vista.leerDatosNumericos("Ingresar numero fijo: ");
            programa = vista.leerDatosTexto("Ingresar el programa al que pertenece el estudiante: ");
            instituto.getEstudianteDAO().borrarEstudiante(correoIns, instituto.getEstudiantes(), instituto.getFile());//Eliminamos el estudiante que se busca para modificarlo.
            instituto.getEstudianteDAO().agregarEstudiante(nombre, apellidos, nacimiento, correoIns, correoPer, celular, fijo, programa, instituto.getEstudiantes(), instituto.getFile());
            vista.mostrarDatos("Se modifico el estudiante con exito.\n");
        }else{
            vista.mostrarDatos("El estudiante no se encuentra registrado en nuestra base de datos.");
        }
    }
    // opcion 4: borra los datos de un estudiante que se buscara por medio del correo institucional. por medio de un condicional mostrara un mensaje predefinido
    // si se pudo o no borrar los datos.
    public void borrarEstudiante(){
        String correoIns = "";
        correoIns = vista.leerDatosTexto("BORRAR ESTUDIANTE." + "\nIngrese el correo institucional del estudiante: ");
        if(instituto.getEstudianteDAO().borrarEstudiante(correoIns, instituto.getEstudiantes(), instituto.getFile())){
            vista.mostrarDatos("Se borro de la base de datos al estudiante.");
        }else{
            vista.mostrarDatos("No se puedo borrar de la base de datos al estudiante.");
        }
    }
    // opcion 5: muestra  todos los datos almacenados.
    public void directorio(){
        vista.mostrarDatos("Directorio de los estudiantes registrados: ");
        vista.mostrarDatos(instituto.getEstudianteDAO().datosEstudiantes(instituto.getFile()));
    }
}
