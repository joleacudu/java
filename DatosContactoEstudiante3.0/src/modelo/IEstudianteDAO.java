package modelo;

import java.util.ArrayList;
/**
 *
 * @author LEONARDO
 */
public interface IEstudianteDAO {
    // Métodos a Implementar
    // Insertar Registros
    // Mostrar Datos
    // Editar Registros
    // Eliminar Registro

    public boolean agregarEstudiante(Estudiante estudiante);
    public ArrayList<Estudiante> verEstudiantes();
    public boolean actualizarEstudiante(Estudiante estudiante);
    public boolean eliminarEstudiante(Estudiante estudiante);
}
