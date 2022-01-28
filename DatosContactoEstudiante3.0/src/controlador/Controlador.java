package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;
import modelo.EstudianteDAO;
import vista.Vista;

/**
 *
 * @author LEONARDO
 */
public class Controlador implements ActionListener{
    
    // Atributos
    Estudiante estudiante = new Estudiante();
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(Vista v) {
        // Poder usar los atributos de la vista
        this.vista = v;
        // Definir el uso de los botones con ActioListener
        //this.vista.btnListar.addActionListener(this);
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == vista.btnListar){
//            limpiarRegistro();
//            limpiarTabla();
//            listar(vista.tabla);
//        }
        if(e.getSource() == vista.btnInsertar){
            agregar();
            limpiarTabla();
            listar(vista.tabla);
            limpiarRegistro();
        }
        if(e.getSource() == vista.btnEditar){
            editar();
            limpiarTabla();
            listar(vista.tabla);
        }
        if(e.getSource() == vista.btnActualizar){
            actualizar();
            limpiarRegistro();
            limpiarTabla();
            listar(vista.tabla);
        }
        if(e.getSource() == vista.btnEliminar){
            eliminar();
            limpiarRegistro();
            limpiarTabla();
            listar(vista.tabla);
        }
        if(e.getSource() == vista.btnBuscar){
            buscar();
            //limpiarRegistro();
            listar(vista.tabla);
        }
        if(e.getSource() == vista.btnLimpiar){
            limpiarRegistro();
            //listar(vista.tabla);
            
        }
    }
    
    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void listar(JTable tabla) {
//        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        // Llamamos al DAO para mostrar los datos de la BDs
        ArrayList<Estudiante> lista = estudianteDAO.verEstudiantes();
        // Llenar los datos de la Tabla
        Object[] objeto = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            
            objeto[0] = lista.get(i).getNombres();
            objeto[1] = lista.get(i).getApellidos();
            objeto[2] = lista.get(i).getFechaNacimiento();
            objeto[3] = lista.get(i).getCorreoInstitucional();
            objeto[4] = lista.get(i).getCorreoPersonal();
            objeto[5] = lista.get(i).getTelefonoCelular();
            objeto[6] = lista.get(i).getTelefonoFijo();
            objeto[7] = lista.get(i).getPrograma();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(25);
        tabla.setRowMargin(10);

    }

    private void agregar() {
        // Capturamos los datos en una variable
        long telefonoCelular = 0, telefonoFijo = 0;
        String nombres = vista.txtNombres.getText();
        String apellidos = vista.txtApellidos.getText();
        String fechaNacimiento = vista.txtFechaNacimiento.getText();
        String correoInstitucional = vista.txtCorreoInstitucional.getText();
        String correoPersonal = vista.txtCorreoPersonal.getText();
        try {
            telefonoCelular = Long.parseLong(vista.txtTelefonoCelular.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,"El Dato del Teléfono no es un número..","Error en Creación",JOptionPane.ERROR_MESSAGE);
            telefonoCelular = 0;
        }
        try {
            telefonoFijo = Long.parseLong(vista.txtTelefonoFijo.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,"El Dato del Teléfono no es un número..","Error en Creación",JOptionPane.ERROR_MESSAGE);
            telefonoFijo = 0;
        }
        String programa = vista.txtPrograma.getText();
        if(apellidos.equals("") || nombres.equals("") || correoInstitucional.equals("") || telefonoCelular == 0 || telefonoFijo == 0){
            JOptionPane.showMessageDialog(vista,"No hay suficiente información","Error en Creación",JOptionPane.ERROR_MESSAGE);
        }else {
            estudiante = new Estudiante(nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, telefonoCelular, telefonoFijo, programa);
            if(estudianteDAO.agregarEstudiante(estudiante)){
                JOptionPane.showMessageDialog(vista,"Usuario creado exitosamente..","Creación de Usuario",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(vista,"Usuario No se creó..Correo ya existente","Error en Creación",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    private void limpiarRegistro() {
        vista.txtNombres.setText("");
        vista.txtApellidos.setText("");
        vista.txtFechaNacimiento.setText("");
        vista.txtCorreoInstitucional.setText("");
        vista.txtCorreoPersonal.setText("");
        vista.txtTelefonoCelular.setText("");
        vista.txtTelefonoFijo.setText("");
        vista.txtPrograma.setText("");
        vista.txtApellidos.setEditable(true);
        vista.txtNombres.setEditable(true);
        vista.txtFechaNacimiento.setEditable(true);
        vista.txtCorreoInstitucional.setEditable(true);
    }

    private void editar() {
        String correoInstitucional;
        correoInstitucional = JOptionPane.showInputDialog(vista,"Por favor escriba el correo del Estudiante a Editar");
        Estudiante rta = estudianteDAO.buscarEstudiante(correoInstitucional,estudianteDAO.verEstudiantes());
        if(rta != null){
            JOptionPane.showMessageDialog(vista,rta.toString(),"Usuario Encontrado",JOptionPane.INFORMATION_MESSAGE);
            
            vista.txtNombres.setText(rta.getNombres());
            vista.txtApellidos.setText(rta.getApellidos());
            vista.txtFechaNacimiento.setText(rta.getFechaNacimiento());
            vista.txtCorreoInstitucional.setText(rta.getCorreoInstitucional());
            vista.txtCorreoPersonal.setText(rta.getCorreoPersonal());
            vista.txtTelefonoCelular.setText(rta.getTelefonoCelular()+"");
            vista.txtTelefonoFijo.setText(rta.getTelefonoFijo()+"");
            vista.txtPrograma.setText(rta.getPrograma());
        }else {
            JOptionPane.showMessageDialog(vista,"Usuario No se encontró..","Error en Edición",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void actualizar() {
        // Recuperamos los valores del formulario
        String nombres = vista.txtNombres.getText();
        String apellidos = vista.txtApellidos.getText();
        String fechaNacimiento = vista.txtFechaNacimiento.getText();
        String correoInstitucional = vista.txtCorreoInstitucional.getText();
        String correoPersonal = vista.txtCorreoPersonal.getText();
        long telefonoCelular = Long.parseLong(vista.txtTelefonoCelular.getText());
        long telefonoFijo = Long.parseLong(vista.txtTelefonoFijo.getText());
        String programa = vista.txtPrograma.getText();
        // Se crea un objeto Estudiante
        estudiante = new Estudiante(nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, telefonoCelular, telefonoFijo, programa);
        if(estudianteDAO.actualizarEstudiante(estudiante)){
            JOptionPane.showMessageDialog(vista,"Usuario actualizado exitosamente..","Actualización de Usuario",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(vista,"Usuario No se creó..","Error en Creación",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        String correoInstitucional;
        correoInstitucional = JOptionPane.showInputDialog(vista,"Por favor escriba el correo del Estudiante a Eliminar");
        Estudiante estudiante = estudianteDAO.buscarEstudiante(correoInstitucional,estudianteDAO.verEstudiantes());
        if(estudiante != null){
            JOptionPane.showMessageDialog(vista,estudiante.toString(),"Usuario Encontrado",JOptionPane.INFORMATION_MESSAGE);
            if(estudianteDAO.eliminarEstudiante(estudiante)){
                JOptionPane.showMessageDialog(vista,"Usuario eliminado exitosamente..","Eliminar Usuario",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(vista,"Usuario No se pudó eliminar..","Error en Creación",JOptionPane.ERROR_MESSAGE);
            }
            
        }else {
            JOptionPane.showMessageDialog(vista,"Usuario No se encontró..","Error en Edición",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscar() {
        String correoInstitucional;
        correoInstitucional = JOptionPane.showInputDialog(vista,"Por favor escriba el correo del Estudiante a Buscar");
        Estudiante estudiante = estudianteDAO.buscarEstudiante(correoInstitucional,estudianteDAO.verEstudiantes());
        if(estudiante != null){
            JOptionPane.showMessageDialog(vista,estudiante.toString(),"Usuario Encontrado",JOptionPane.INFORMATION_MESSAGE);
            vista.txtNombres.setText(estudiante.getNombres());
            vista.txtApellidos.setText(estudiante.getApellidos());
            vista.txtFechaNacimiento.setText(estudiante.getFechaNacimiento());
            vista.txtCorreoInstitucional.setText(estudiante.getCorreoInstitucional());
            vista.txtCorreoPersonal.setText(estudiante.getCorreoPersonal());
            vista.txtTelefonoCelular.setText(estudiante.getTelefonoCelular()+"");
            vista.txtTelefonoFijo.setText(estudiante.getTelefonoFijo()+"");
            vista.txtPrograma.setText(estudiante.getPrograma());
        }else {
            JOptionPane.showMessageDialog(vista,"Usuario No se encontró..","Error en Edición",JOptionPane.ERROR_MESSAGE);
        }
          
    }
}
