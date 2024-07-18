import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Login extends JFrame implements ActionListener
{
    Texto titulo= new Texto("Iniciar Sesión", 20, 20, 200, 30, Color.BLACK, 25);
    Texto txtUsuario= new Texto("Usuario:", 100, 80, 150, 20, Color.BLACK, 16);
    Texto textPass= new Texto("Contraseña:", 100, 120, 150, 20, Color.BLACK, 16);
    Caja tbUsuario= new Caja(200, 80, 5);
    Caja tbPass= new Caja(200, 120, 5);
    Boton btnIngresar= new Boton("INGRESAR", 110, 180, 100, 30, Color.WHITE);
    Boton btnSalir= new Boton("SALIR", 220, 180, 100, 30, Color.white);
    
    /**
     * Constructor for objects of class Ventana
     */
    public Login()
    {
        //AÑADIR OBJETOS
        add(titulo);
        add(txtUsuario);
        add(tbUsuario);
        add(textPass);
        add(tbPass);
        add(btnIngresar);
        add(btnSalir);
        
        btnIngresar.addActionListener(this);
        btnSalir.addActionListener(this);
        
        //CONFIG FRAME
        setLayout(null);
        setTitle("LOGIN");
        setSize(450, 300);
        setResizable(false); // Evitar que la ventana sea redimensionable
        setLocationRelativeTo(null); // Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void ingresar()
    {
        Personal us= new Personal(tbUsuario.getText(), Integer.parseInt(tbPass.getText()));
        String usu="joel";
        int con=217;
        if (DBA.existePersonal(us) || (tbUsuario.getText().equals(usu) && Integer.parseInt(tbPass.getText()) == con)) {
                frmSistema= new Sistema();
                dispose();
            } else {
                setTitle("ERROR");
            }
    }
    
    public static Sistema frmSistema;
    public static VentanaPersonal frmCrear;
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()== btnIngresar){
            ingresar();
        }
        
        if (e.getSource() == btnSalir) {
            // Obtener el componente raíz (ventana) que contiene el botón cancelar
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            // Cerrar la ventana actual
            window.dispose();
        }
    }
    
    public static void main()
    {
        Login login= new Login();
    }
}