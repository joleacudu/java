package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * Clase que conecta con jdbc a la BDs 
 * @author LEONARDO
 */
public class Conexion {
    public static Connection conectar(){
        // Definir los atributos de tipo Connection y el nombre de la Base de Datos
        Connection con = null;
        Statement consulta;
        String ruta = "D:\\MIN TIC\\ciclo 2\\semana 6\\reto\\DatosContactoEstudiante\\bd_estudiantes.db";
        // Definir el url
        String url = "jdbc:sqlite:" + ruta;
        try {
            con = DriverManager.getConnection(url);
            consulta = con.createStatement();
            if(con != null){
                System.out.println("Conectados a la Base de Datos");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la Base de Datos");
            e.printStackTrace();
        }
        return con;
    }
   
}
