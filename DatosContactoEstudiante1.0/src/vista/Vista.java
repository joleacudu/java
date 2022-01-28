package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import controlador.Controlador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import modelo.Estudiante;

/**
 *
 * @author LEONARDO
 */
public class Vista extends JFrame{

    Container contenedor = getContentPane();
    // Declaración de cada variable como´públicas
    // Variables de la ventanaDatos
    public JLabel lblApellidos;
    public JTextField txtApellidos;
    public JLabel lblNombres;
    public JTextField txtNombres;
    public JLabel lblFechaNacimiento;
    public JTextField txtFechaNacimiento;
    public JLabel lblCorreoInstitucional;
    public JTextField txtCorreoInstitucional;
    public JLabel lblCorreoPersonal;
    public JTextField txtCorreoPersonal;
    public JLabel lblTelefonoCelular;
    public JTextField txtTelefonoCelular;
    public JLabel lblTelefonoFijo;
    public JTextField txtTelefonoFijo;
    public JLabel lblPrograma;
    public JTextField txtPrograma;

    // Variables de la Tabla
    public DefaultTableModel modeloTabla;
    public JTable tabla;
    public JScrollPane panelScroll;
    
    // Variables de los Botones
    public JButton btnInsertar;
    public JButton btnEditar;
    public JButton btnEliminar;
    public JButton btnBuscar;
    public JButton btnListar;
    public JButton btnActualizar;
    public JButton btnLimpiar;

    
    // Variable del Controlador
//    Controlador controlador;
    
    public Vista() {
        // Definir las características de la Ventana Principal
        setTitle("COCLO 2 / RETO 5 / Pruebas de código e interfaz gráfica de usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Construye la forma
        setLayout(new BorderLayout());
        setSize(910, 620);
        setBackground(Color.GRAY);
        
///////////////////////////////////////INGRESAR DATOS/////////////////////////////////////////////////
     
        JPanel ventanaDatos = new JPanel();
        ventanaDatos.setBackground(Color.GRAY);//Cambia el fondo       
        // Definimos la distribución por defecto tipo BorderLayout
        // Agregamos un título al borde del organizador
        ventanaDatos.setLayout( new BorderLayout( ) );
        ventanaDatos.setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "DATOS DEL ESTUDIANTE" ) ) );

        lblNombres = new JLabel( "Nombre: " );
        lblNombres.setForeground(Color.WHITE); // para cambiar el color de la letra.
        lblApellidos = new JLabel( "Apellidos: " );
        lblApellidos.setForeground(Color.WHITE);
        lblFechaNacimiento = new JLabel( "Fecha de Nacimiento: " );
        lblFechaNacimiento.setForeground(Color.WHITE);
        lblCorreoInstitucional = new JLabel( "Correo Institucional: " );
        lblCorreoInstitucional.setForeground(Color.WHITE);
        lblCorreoPersonal = new JLabel( "Correo Empresa: " );
        lblCorreoPersonal.setForeground(Color.WHITE);
        lblTelefonoCelular = new JLabel( "Teléfono Celular: " );
        lblTelefonoCelular.setForeground(Color.WHITE);
        lblTelefonoFijo = new JLabel( "Teléfono Fijo: " );
        lblTelefonoFijo.setForeground(Color.WHITE);
        lblPrograma = new JLabel( "Programa: " );
        lblPrograma.setForeground(Color.WHITE);
        txtNombres = new JTextField("Agregar Nombres", 15);//agrego un texto por defecto y dimension.
        txtNombres.setBackground(Color.LIGHT_GRAY);//Agrega color al fondo del cuadro de texto
        txtNombres.setForeground(Color.BLUE);//Cambia el color del texto.
        txtApellidos = new JTextField("Agregar Apellidos", 15);
        txtApellidos.setBackground(Color.LIGHT_GRAY);
        txtApellidos.setForeground(Color.BLUE);
        txtFechaNacimiento = new JTextField("Agregar Fecha de Nacimiento", 15 );
        txtFechaNacimiento.setBackground(Color.LIGHT_GRAY);
        txtFechaNacimiento.setForeground(Color.BLUE);
        txtCorreoInstitucional = new JTextField("Agregar correo Institucional", 15 );
        txtCorreoInstitucional.setBackground(Color.LIGHT_GRAY);
        txtCorreoInstitucional.setForeground(Color.BLUE);
        txtCorreoPersonal = new JTextField("Agregar correo Personal", 15 );
        txtCorreoPersonal.setBackground(Color.LIGHT_GRAY);
        txtCorreoPersonal.setForeground(Color.BLUE);
        txtTelefonoCelular = new JTextField("Agregar número Celular", 15 );
        txtTelefonoCelular.setBackground(Color.LIGHT_GRAY);
        txtTelefonoCelular.setForeground(Color.BLUE);
        txtTelefonoFijo = new JTextField("Agregar número fijo", 15 );
        txtTelefonoFijo.setBackground(Color.LIGHT_GRAY);
        txtTelefonoFijo.setForeground(Color.BLUE);
        txtPrograma = new JTextField("Agregar programa al que pertenece", 10 );
        txtPrograma.setBackground(Color.LIGHT_GRAY);
        txtPrograma.setForeground(Color.BLUE);
        
        ventanaDatos.setLayout( new GridLayout( 8, 2 ) ); //cantidad de filas y columnas
        ventanaDatos.add( lblNombres );
        ventanaDatos.add( txtNombres );
        ventanaDatos.add( lblApellidos );
        ventanaDatos.add( txtApellidos );
        ventanaDatos.add( lblFechaNacimiento );
        ventanaDatos.add( txtFechaNacimiento );
        ventanaDatos.add( lblCorreoInstitucional );
        ventanaDatos.add( txtCorreoInstitucional );
        ventanaDatos.add( lblCorreoPersonal );
        ventanaDatos.add( txtCorreoPersonal );
        ventanaDatos.add( lblTelefonoCelular );
        ventanaDatos.add( txtTelefonoCelular );
        ventanaDatos.add( lblTelefonoFijo );
        ventanaDatos.add( txtTelefonoFijo );
        ventanaDatos.add( lblPrograma );
        ventanaDatos.add( txtPrograma );

        add( ventanaDatos, BorderLayout.CENTER );
        
//////////////////////////////TABLA: BASE DE DATOS///////////////////////////////////////////////

        JPanel Tabla = new JPanel();
        Tabla.setBackground(Color.GRAY); //cambiar el fondo
        Tabla.setLayout( new BorderLayout( ) );
        //Tabla.setBorder( new CompoundBorder(new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "LISTADO DE ESTUDIANTES REGISTRADOS: " ) ));
        Tabla.setBorder( BorderFactory.createTitledBorder( "LISTADO DE ESTUDIANTES REGISTRADOS: " ) );

        modeloTabla = new DefaultTableModel( );
        tabla = new JTable( modeloTabla )
        {
            public boolean isCellEditable( int col, int row )
            {
                return false;
            }    
        }; 
        Tabla.setLayout( new BorderLayout( ) );

        // Títulos de Columnas
        modeloTabla.addColumn( "Nombres" );
        modeloTabla.addColumn( "Apellidos" );
        modeloTabla.addColumn( "Fecha de Nacimiento" );
        modeloTabla.addColumn( "Correo Institucional" );
        modeloTabla.addColumn( "Correo Personal" );
        modeloTabla.addColumn( "Telefono Celular" );
        modeloTabla.addColumn( "Telefono Fijo" );
        modeloTabla.addColumn( "Programa" );
        tabla.setRowHeight(25);
        tabla.setRowMargin(10);

        panelScroll = new JScrollPane( tabla );
        panelScroll.setViewportView(tabla);
        //panelScroll.setSize(700, 400);
        Tabla.add( panelScroll );
        add( Tabla, BorderLayout.CENTER );
        
////////////////////////////////////////BOTONES/////////////////////////////////////////////
        
        JPanel Botones = new JPanel();
        Botones.setBackground(Color.GRAY); //Cambia el fondo
        Botones.setLayout( new BorderLayout( ) );
        Botones.setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "OPCIONES A REALIZAR:" ) ) );

        btnInsertar = new JButton("");
        btnInsertar.setForeground(Color.RED); //cambia el color de la letra
        btnInsertar.setBackground(Color.CYAN);//cambia el color del boton
        btnInsertar.setText( "Insertar");
        btnEditar = new JButton( );
        btnEditar.setForeground(Color.RED);
        btnEditar.setBackground(Color.CYAN);
        btnEditar.setText( "Editar" );
        btnEliminar = new JButton( );
        btnEliminar.setForeground(Color.RED);
        btnEliminar.setBackground(Color.CYAN);
        btnEliminar.setText( "Eliminar" );
//        btnListar = new JButton( );
//        btnListar.setForeground(Color.RED);
//        btnListar.setBackground(Color.CYAN);
//        btnListar.setText( "Listar" );
        btnActualizar = new JButton( );
        btnActualizar.setForeground(Color.RED);
        btnActualizar.setBackground(Color.CYAN);
        btnActualizar.setText( "Actualizar" );
        btnLimpiar = new JButton( );
        btnLimpiar.setForeground(Color.RED);
        btnLimpiar.setBackground(Color.CYAN);
        btnLimpiar.setText( "Limpiar" );
        btnBuscar = new JButton( );
        btnBuscar.setForeground(Color.RED);
        btnBuscar.setBackground(Color.CYAN);
        btnBuscar.setText( "Buscar" );
        Botones.setLayout(new FlowLayout() );
        Botones.add( btnInsertar );
        Botones.add( btnEditar );
        //Botones.add( btnListar );
        Botones.add( btnEliminar );
        Botones.add( btnBuscar );
        Botones.add( btnActualizar );
        Botones.add( btnLimpiar );

        add( Botones, BorderLayout.CENTER );
        
        contenedor.add(ventanaDatos,BorderLayout.NORTH);
        contenedor.add(Tabla,BorderLayout.CENTER);
        contenedor.add(Botones,BorderLayout.SOUTH);
    }
    
public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);     
        controlador.listar(vista.tabla);//para listar la tabla al ejecutar el codigo y no poner el boton listar.
    }
    
}

