import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VentanaCliente extends JFrame implements ActionListener
{
    Texto empresa= new Texto("TODO MOTO", 20, 30, 500, 30, Color.BLACK, 40);
    Texto indice= new Texto("CLIENTES", 30, 70, 1000, 20, Color.BLACK, 16);
    Texto buscarCi= new Texto("CI:", 40, 110, 100, 20, Color.BLACK, 13);
    Caja tbBuscador= new Caja(40, 130, 5);
    Boton btnBuscar= new Boton("Buscar", 40, 160, 80, 30, Color.YELLOW);
    Boton btnActualizar= new Boton("Actualizar", 40, 240, 80, 30, Color.YELLOW);
    Boton btnEliminar= new Boton("Eliminar", 40, 280, 80, 30, Color.YELLOW);
    
    Texto ci= new Texto("CI:", 300, 120, 100, 20, Color.BLACK, 16);
    Texto nombre= new Texto("Nombre: ", 300, 150, 100, 20, Color.BLACK, 16);
    Texto apellido= new Texto("Apellido: ", 300, 180, 100, 20, Color.BLACK, 16);
    Texto direccion= new Texto("Dirección: ", 300, 210, 100, 20, Color.BLACK, 16);
    Texto telefono= new Texto("Telefono: ", 300, 240, 100, 20, Color.BLACK, 16);
    Texto correo= new Texto("Correo: ", 300, 270, 100, 20, Color.BLACK, 16);
    
    Caja tbOldNombre= new Caja(0, 0, 5);
    Caja tbCi= new Caja(400, 120, 5);
    Caja tbNombre= new Caja(400, 150, 5);
    Caja tbApellido= new Caja(400, 180, 5);
    Caja tbDireccion= new Caja(400, 210, 5);
    Caja tbTelefono= new Caja(400, 240, 5);
    Caja tbCorreo= new Caja(400, 270, 5);
    Boton btnRegistrar= new Boton("REGISTRAR", 300, 320, 100, 30, Color.WHITE);
    Boton btnMenu= new Boton("MENU", 420, 320, 100, 30, Color.WHITE);
    
    public VentanaCliente()
    {
        //AÑADIR OBJETOS
        add(empresa);
        add(indice);
        add(buscarCi);
        add(tbBuscador);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);
        
        add(ci);
        add(nombre);
        add(apellido);
        add(direccion);
        add(telefono);
        add(correo);
        
        tbOldNombre.setVisible(false);
        add(tbOldNombre);
        add(tbCi);
        add(tbNombre);
        add(tbApellido);
        add(tbDireccion);
        add(tbTelefono);
        add(tbCorreo);
        add(btnRegistrar);
        add(btnMenu);
        
        btnRegistrar.addActionListener(this);
        btnMenu.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        
        //CONFIG FRAME
        setLayout(null);
        setTitle("LOGIN");
        setSize(700, 450);
        setResizable(false); // Evitar que la ventana sea redimensionable
        setLocationRelativeTo(null); // Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static Sistema frmCrear;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            int c = !tbCi.getText().isEmpty() ? Integer.parseInt(tbCi.getText()) : 0;
            String n = tbNombre.getText();
            String a = tbApellido.getText();
            String d = tbDireccion.getText();
            String t = tbTelefono.getText();
            String co = tbCorreo.getText();

            Cliente rc = new Cliente(c, n, a, d, t, co);
            DBA.setCliente(rc);
            setTitle("GUARDADO");

            // Limpiar los campos después del registro
            tbCi.setText("");
            tbNombre.setText("");
            tbApellido.setText("");
            tbDireccion.setText("");
            tbTelefono.setText("");
            tbCorreo.setText("");
        }
       
        if (e.getSource() == btnBuscar) {
            try {
                String codStr = tbBuscador.getText().trim();
                System.out.println("Código ingresado: " + codStr); // Depuración
                
                int ci = Integer.parseInt(tbBuscador.getText()); // Convertir el texto de tbCi a un entero
                Cliente c = DBA.getClientePorCi(ci); // Buscar el cliente por CI
                if (c != null) {
                    tbCi.setText(String.valueOf(c.getCi()));
                    tbNombre.setText(c.getNombre());
                    tbApellido.setText(c.getApellido());
                    tbDireccion.setText(c.getDireccion());
                    tbTelefono.setText(c.getTelefono());
                    tbCorreo.setText(c.getCorreo());
                    
                    // Almacenar el código antiguo en la caja de texto oculta
                    tbOldNombre.setText(c.getNombre());
                } else {
                    JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al visualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnActualizar) {
            try {
                String oldNombre = tbOldNombre.getText().trim(); // Nombre antiguo
                System.out.println("Nombre antiguo ingresado para actualización: " + oldNombre);
                
                int c = !tbCi.getText().isEmpty() ? Integer.parseInt(tbCi.getText()) : 0;
                String newNombre = tbNombre.getText(); // Nuevo nombre
                String a = tbApellido.getText();
                String d = tbDireccion.getText();
                String t = tbTelefono.getText();
                String co = tbCorreo.getText();
        
                Cliente rc = new Cliente(c, newNombre, a, d, t, co);
                boolean actualizado = DBA.updateCliente(oldNombre, rc);
        
                if (actualizado) {
                    setTitle("ACTUALIZADO");
                    JOptionPane.showMessageDialog(this, "Cliente actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la actualización
                tbCi.setText("");
                tbNombre.setText("");
                tbApellido.setText("");
                tbDireccion.setText("");
                tbTelefono.setText("");
                tbCorreo.setText("");
                
                // Limpiar la caja de texto oculta
                tbOldNombre.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnEliminar) {
            try {
                int ci = !tbCi.getText().isEmpty() ? Integer.parseInt(tbCi.getText().trim()) : 0;
                boolean eliminado = DBA.deleteCliente(ci);
                if (eliminado) {
                    setTitle("ELIMINADO");
                    JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la eliminación
                tbCi.setText("");
                tbNombre.setText("");
                tbApellido.setText("");
                tbDireccion.setText("");
                tbTelefono.setText("");
                tbCorreo.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnMenu) {
            setVisible(false);
            frmCrear = new Sistema();
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
    
    public static void main(String[] args) {
        new VentanaCliente();
    }
}