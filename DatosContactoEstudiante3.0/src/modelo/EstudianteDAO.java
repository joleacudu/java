package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Estudiante;

/**
 *
 * @author LEONARDO
 */
public class EstudianteDAO implements IEstudianteDAO{
    
    // Agregar los atributos que permitan usar el JDBC 
    // Tipo Connection Statement ResultSet
    Statement stm = null;
    Connection con = null;
    ResultSet resultado = null;
        
    public boolean buscar(String sql){
        boolean encontrado = false;
        con = Conexion.conectar();

        try {
            stm = con.createStatement();
            resultado = stm.executeQuery(sql);
            while(resultado.next()){
                encontrado = true;
            }
        } catch (SQLException e) {
                String texto = "Mensaje:"+e.getMessage()+"\n"+"Estado:"+e.getSQLState()+"\n"+
                        "Codigo del error:"+e.getErrorCode();
                JOptionPane.showMessageDialog(null,texto,"Error en Búsqueda",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        return encontrado;
    }

    public Estudiante buscarEstudiante(String correo, ArrayList<Estudiante> estudiantes) {
	Estudiante encontrado = null;
		
        if (!estudiantes.isEmpty()) { // Si no está vacío
            for (int i = 0; i < estudiantes.size(); i++) {// Recorre el ArrayList
                // Se busca el correo en el Arreglo
                if (estudiantes.get(i).getCorreoInstitucional().equals(correo)) {
                    encontrado = estudiantes.get(i);// Se almacena un objeto tipo Empleado en encontrado
                }
            }
        }
	return encontrado;
    }
    
    
    @Override
    public boolean agregarEstudiante(Estudiante estudiante) {
        boolean registrar = false;
        boolean encontrado = false;
        String buscar = "SELECT * FROM estudiantes where correoInstitucional = '" 
                + estudiante.getCorreoInstitucional() + "'";
        encontrado = buscar(buscar); // Verificar si existe un estudiante con el correo
        if(!encontrado){
            String sql = "INSERT INTO estudiantes values ('" + estudiante.getApellidos() + "','" 
                    + estudiante.getNombres() + "','" + estudiante.getFechaNacimiento() + "','" 
                    + estudiante.getCorreoInstitucional() + "','" + estudiante.getCorreoPersonal() + 
                    "','" + estudiante.getTelefonoCelular() + "','" + estudiante.getTelefonoFijo() + 
                    "','" + estudiante.getPrograma() + "')";

            try {
                con = Conexion.conectar();
                stm = con.createStatement();
                stm.execute(sql);
                registrar = true;
                stm.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: Clase EstudianteDao, método agregarEstudiante","Error en Creación",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        return registrar;
    }

    @Override
    public ArrayList<Estudiante> verEstudiantes() {
        String sql = "SELECT * FROM ESTUDIANTES";
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        try {
            con = Conexion.conectar(); // Conectamos a la BDs
            stm = con.createStatement(); // Separamos para ejecutar comando sql
            resultado = stm.executeQuery(sql); // Ejecuta el sql y lo almacena en un ResultSet
            while (resultado.next()) {
                // creamos un objeto Estudiante
                Estudiante emp = new Estudiante();
                // Asignamos el valor a cada atributo en el objeto
                emp.setApellidos(resultado.getString(1));
                emp.setNombres(resultado.getString(2));
                emp.setFechaNacimiento(resultado.getString(3));
                emp.setCorreoInstitucional(resultado.getString(4));
                emp.setCorreoPersonal(resultado.getString(5));
                emp.setTelefonoCelular(resultado.getLong(6));
                emp.setTelefonoFijo(resultado.getLong(7));
                emp.setPrograma(resultado.getString(8));
                // Agregar el objeto al ArrayList
                estudiantes.add(emp);
            }
            // cerramos el jdbc
            stm.close();
            resultado.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDao, método verEstudiantes");
            e.printStackTrace();
        }
        return estudiantes;
    }

    @Override
    public boolean actualizarEstudiante(Estudiante estudiante) {
        boolean encontrado = false;
        boolean actualizar = false;
        String sql = "UPDATE estudiantes SET apellidos = '" + estudiante.getApellidos() + "', nombres = '"
                + estudiante.getNombres() + "', fechaNacimiento='" + estudiante.getFechaNacimiento()
                + "', correoPersonal = '" + estudiante.getCorreoPersonal()
                + "', telefonoCelular = " + estudiante.getTelefonoCelular()
                + ", telefonoFijo = " + estudiante.getTelefonoFijo()
                + ", programa = '" + estudiante.getPrograma() + "'"
                + " WHERE correoInstitucional = '" + estudiante.getCorreoInstitucional() + "'";
        System.out.println(""+sql);
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminarEstudiante(Estudiante estudiante) {
        boolean encontrado = false;
        boolean eliminar = false;
        String buscar = "SELECT * FROM estudiantes where correoInstitucional = '" + 
                estudiante.getCorreoInstitucional() + "'";
        encontrado = buscar(buscar);
        String sql = "DELETE FROM ESTUDIANTES WHERE correoInstitucional = '" + 
                estudiante.getCorreoInstitucional() + "'";
        if(encontrado){
            try {
                con = Conexion.conectar();
                stm = con.createStatement();
                stm.execute(sql);
                eliminar = true;
            } catch (SQLException e) {
                System.out.println("Error: Clase EstudianteDao, método eliminar");
                e.printStackTrace();
            }
        }
        return eliminar;
    }

    public ArrayList<Estudiante> verConsulta(String sql) {
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            resultado = stm.executeQuery(sql);
            while (resultado.next()) {
                Estudiante emp = new Estudiante();
                emp.setApellidos(resultado.getString(1));
                emp.setNombres(resultado.getString(2));
                emp.setFechaNacimiento(resultado.getString(3));
                emp.setCorreoInstitucional(resultado.getString(4));
                emp.setCorreoPersonal(resultado.getString(5));
                emp.setTelefonoCelular(resultado.getLong(6));
                emp.setTelefonoFijo(resultado.getLong(7));
                emp.setPrograma(resultado.getString(8));
                estudiantes.add(emp);
            }
            stm.close();
            resultado.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDao, método verEstudiantes");
            e.printStackTrace();
        }
        return estudiantes;
    }
    
}
