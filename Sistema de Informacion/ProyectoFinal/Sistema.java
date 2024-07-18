import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sistema extends JFrame implements ActionListener
{
    Texto empresa= new Texto("TODO MOTO", 20, 30, 500, 30, Color.BLACK, 40);
    Texto principal= new Texto("MENU PRINCIPAL", 30, 70, 1000, 20, Color.BLACK, 16);
    Boton btnClientes= new Boton("CLIENTES", 40, 100, 150, 30, Color.WHITE);
    Boton btnInventario= new Boton("INVENTARIOS", 40, 140, 150, 30, Color.WHITE);
    Boton btnPersonal= new Boton("PERSONAL", 40, 180, 150, 30, Color.WHITE);
    Boton btnProductos= new Boton("PRODUCTOS", 40, 220, 150, 30, Color.WHITE);
    Boton btnVentas= new Boton("VENTAS", 40, 260, 150, 30, Color.WHITE);
    Boton btnCerrar= new Boton("CERRAR SESION", 40, 300, 150, 30, Color.WHITE);
    
    JLabel imageLabel;
        
    /**
     * Constructor for objects of class Ventana
     */
    public Sistema()
    {
        //AÑADIR OBJETOS
        add(empresa);
        add(principal);
        add(btnClientes);
        add(btnInventario);
        add(btnPersonal);
        add(btnProductos);
        add(btnVentas);
        add(btnCerrar);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/todoMoto.png"));
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(220, 0, 450, 350); // Ajustar posición y tamaño de la imagen
        add(imageLabel);
        
        btnClientes.addActionListener(this);
        btnInventario.addActionListener(this);
        btnPersonal.addActionListener(this);
        btnProductos.addActionListener(this);
        btnVentas.addActionListener(this);
        btnCerrar.addActionListener(this);
        
        //CONFIG FRAME
        setLayout(null);
        setTitle("LOGIN");
        setSize(700, 400);
        setResizable(false); // Evitar que la ventana sea redimensionable
        setLocationRelativeTo(null); // Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static VentanaCliente formularioCliente;
    public static VentanaPersonal formularioPersonal;
    public static VentanaProducto formularioProducto;
    public static VentanaVenta formularioVenta;
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()== btnClientes){
            if (formularioCliente == null) {
                formularioCliente= new VentanaCliente();
            }
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
            formularioCliente.setVisible(true);
        }
        if (e.getSource() == btnInventario) {
            VentanaProducto.mostrarInventario();
        }
        if (e.getSource() == btnPersonal) {
            if (formularioPersonal == null) {
                formularioPersonal = new VentanaPersonal();
            }
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
            formularioPersonal.setVisible(true);
        }
        if (e.getSource() == btnProductos) {
            if (formularioProducto == null) {
                formularioProducto = new VentanaProducto();
            }
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
            formularioProducto.setVisible(true);
        }
        if (e.getSource() == btnVentas) {
            if (formularioVenta == null) {
                formularioVenta = new VentanaVenta();
            }
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
            formularioVenta.setVisible(true);
        }
        if (e.getSource()== btnCerrar){
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}

