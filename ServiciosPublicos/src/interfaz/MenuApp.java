package interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Usuario;
import static vista.Pantalla.ingresarDatos;

public class MenuApp {

    public static void main(String[] args) {
       // se crea un objeto para hacer captura de datos
        Scanner sc = new Scanner(System.in);
        boolean centinela = true;
        int opcion = 0;
        while(centinela){
            System.out.println("");
            System.out.println("\t==============================================");
            System.out.println("\t         PAGO DE SERVICIOS PÚBLICOS");
            System.out.println("\t==============================================");
            System.out.println("\tSeleccione el servicio público a pagar:");
            System.out.println("\t1. Energia");
            System.out.println("\t2. Acueducto");
            System.out.println("\t3. Gas Natural");
            System.out.println("\t4. Salir");
            System.out.println("\t==============================================");
            System.out.println("");
            try {
                System.out.print("\tEscriba la opcion del servicio a pagar: ");
                opcion = sc.nextInt();//este seria el servicio en ingresarDatos().
                switch(opcion){
                    case 1:
                        System.out.println("\tSelecciono el pago del Servicio de Energía");
                        System.out.println("");
                        enviarDatos(opcion);
                        break;
                    case 2:
                        System.out.println("\tSelecciono el pago del Acueducto");
                        System.out.println("");
                        enviarDatos(opcion);
                        break;
                    case 3:
                        System.out.println("\tSelecciono el pago del Gas Natural");
                        System.out.println("");
                        enviarDatos(opcion);
                        break;
                    case 4:
                        System.out.println("");
                        System.out.println("Gracias por su pago.");
                        System.out.println("Le deseamos un excelente dia, hasta pronto.");
                        centinela = false;
                        System.exit(0);
                    default:
                        System.out.println("\t=====================================");
                        System.out.println("\tDebe ingresar un valor entre 1 y 4.");
                        System.out.println("\tPulse ENTER para continuar...");
                        System.out.println("\t======================================");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\t==================================");
                System.out.println("\tDebe ingresar un numero entero.");
                System.out.println("\tPulse ENTER para continuar...");
                System.out.println("\t==================================");
                sc.nextLine();
                sc.nextLine();
            }
        }
    }
public static void enviarDatos(int opcion){
    int estrato, consumo;
    double valor = 0;
    String unidad = "";
    Scanner sc = new Scanner(System.in);    
    System.out.print("\tPor favor escriba el estrato del inmueble: ");
    estrato = sc.nextInt();  
    System.out.print("\tPor favor escriba el consumo del inmueble: ");
    consumo = sc.nextInt();
    Usuario usu = new Usuario(estrato, consumo, opcion);
    if(opcion==1){
        valor = Usuario.ENERGIA;
        unidad = " Kilowatt";
    }else if(opcion==2){
        valor = Usuario.AGUA;
        unidad = " Metros Cubicos";
    }else if(opcion==3){
        valor = Usuario.GAS_NATURAL;
        unidad = " Metros Cubicos";
    }
    ingresarDatos(consumo, unidad, valor, estrato, usu.calcularCosto(), usu.descuentoSobrecosto(), usu.calcularImpuesto(), usu.valorTotal());
}  
}
