import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VentanaPersonal extends JFrame implements ActionListener
{
    Texto empresa= new Texto("TODO MOTO", 20, 30, 500, 30, Color.BLACK, 40);
    Texto indice= new Texto("PERSONAL", 30, 70, 1000, 20, Color.BLACK, 16);
    Texto buscarCi= new Texto("CI:", 40, 110, 100, 20, Color.BLACK, 13);
    Caja tbBuscador= new Caja(40, 130, 5);
    Boton btnBuscar= new Boton("Buscar", 40, 160, 80, 30, Color.YELLOW);
    Boton btnActualizar= new Boton("Actualizar", 40, 240, 80, 30, Color.YELLOW);
    Boton btnEliminar= new Boton("Eliminar", 40, 280, 80, 30, Color.YELLOW);
    
    Texto ci= new Texto("CI:", 300, 120, 100, 20, Color.BLACK, 16);
    Texto nombre= new Texto("Nombre: ", 300, 150, 100, 20, Color.BLACK, 16);
    Texto apellido= new Texto("Apellido: ", 300, 180, 100, 20, Color.BLACK, 16);
    Texto puesto= new Texto("Puesto: ", 300, 210, 100, 20, Color.BLACK, 16);
    Texto telefono= new Texto("Telefono: ", 300, 240, 100, 20, Color.BLACK, 16);
    Texto correo= new Texto("Correo: ", 300, 270, 100, 20, Color.BLACK, 16);
    
    Caja tbOldCi= new Caja(0, 0, 5);
    Caja tbCi= new Caja(400, 120, 5);
    Caja tbNombre= new Caja(400, 150, 5);
    Caja tbApellido= new Caja(400, 180, 5);
    Caja tbPuesto= new Caja(400, 210, 5);
    Caja tbTelefono= new Caja(400, 240, 5);
    Caja tbCorreo= new Caja(400, 270, 5);
    Boton btnRegistrar= new Boton("REGISTRAR", 300, 320, 100, 30, Color.WHITE);
    Boton btnNuevo= new Boton("NUEVO", 300, 320, 100, 30, Color.WHITE);
    Boton btnMenu= new Boton("MENU", 420, 320, 100, 30, Color.WHITE);
    
    public VentanaPersonal()
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
        add(puesto);
        add(telefono);
        add(correo);
        
        tbOldCi.setVisible(false);
        add(tbOldCi);
        add(tbCi);
        add(tbNombre);
        add(tbApellido);
        add(tbPuesto);
        add(tbTelefono);
        add(tbCorreo);
        add(btnRegistrar);
        add(btnNuevo);
        add(btnMenu);
        
        btnRegistrar.addActionListener(this);
        btnMenu.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnNuevo.addActionListener(this);
        
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
            try {
                int c = !tbCi.getText().isEmpty() ? Integer.parseInt(tbCi.getText()) : 0;
                // Verificar si el CI ya está registrado
                Personal existingPersonal = DBA.getPersonalPorCi(c); // Asumiendo que existe este método en DBA
                if (existingPersonal != null) {
                    JOptionPane.showMessageDialog(this, "El CI ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                String n = tbNombre.getText();
                String a = tbApellido.getText();
                String p = tbPuesto.getText();
                String t = tbTelefono.getText();
                String co = tbCorreo.getText();
        
                Personal rp = new Personal(c, n, a, p, t, co);
                DBA.setPersonal(rp);
                // Obtener el tamaño del vector después de agregar el personal
                int vectorSize = DBA.getSizePersonal(); // Asumiendo que existe este método en DBA
                setTitle("GUARDADO en posición " + vectorSize);
                // Limpiar los campos después del registro
                tbCi.setText("");
                tbNombre.setText("");
                tbApellido.setText("");
                tbPuesto.setText("");
                tbTelefono.setText("");
                tbCorreo.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar el personal: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnBuscar) {
            try {
                int ci = Integer.parseInt(tbBuscador.getText());
                Personal p = DBA.getPersonalPorCi(ci);
                if (p != null) {
                    tbCi.setText(String.valueOf(p.getCi()));
                    tbNombre.setText(p.getNombre());
                    tbApellido.setText(p.getApellido());
                    tbPuesto.setText(p.getPuesto());
                    tbTelefono.setText(p.getTelefono());
                    tbCorreo.setText(p.getCorreo());
                    // Almacenar el nombre antiguo en la caja de texto oculta
                    tbOldCi.setText(String.valueOf(p.getCi()));
                    
                    btnRegistrar.setVisible(false);
                    btnNuevo.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al visualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnActualizar) {
            try {
                int oldCi = !tbOldCi.getText().isEmpty() ? Integer.parseInt(tbOldCi.getText()) : 0;
        
                int c = !tbCi.getText().isEmpty() ? Integer.parseInt(tbCi.getText()) : 0;
                String n = tbNombre.getText();
                String a = tbApellido.getText();
                String p = tbPuesto.getText();
                String t = tbTelefono.getText();
                String co = tbCorreo.getText();
        
                Personal rp = new Personal(c, n, a, p, t, co);
                boolean actualizado = DBA.updatePersonal(oldCi, rp);
        
                if (actualizado) {
                    setTitle("ACTUALIZADO");
                    JOptionPane.showMessageDialog(this, "Personal actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el personal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                // Limpiar los campos después de la actualización
                tbCi.setText("");
                tbNombre.setText("");
                tbApellido.setText("");
                tbPuesto.setText("");
                tbTelefono.setText("");
                tbCorreo.setText("");
                // Limpiar la caja de texto oculta
                tbOldCi.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar el personal: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnEliminar) {
            try {
                int ciPersonal= !tbCi.getText().isEmpty() ? Integer.parseInt(tbCi.getText()) : 0;
                boolean eliminado = DBA.deletePersonal(ciPersonal);
                if (eliminado) {
                    setTitle("ELIMINADO");
                    JOptionPane.showMessageDialog(this, "Personal eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el personal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                // Limpiar los campos después de la eliminación
                tbCi.setText("");
                tbNombre.setText("");
                tbApellido.setText("");
                tbPuesto.setText("");
                tbTelefono.setText("");
                tbCorreo.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el personal: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnNuevo) {
            btnNuevo.setVisible(false);
            tbCi.setText("");
            tbNombre.setText("");
            tbApellido.setText("");
            tbPuesto.setText("");
            tbTelefono.setText("");
            tbCorreo.setText("");  
            btnRegistrar.setVisible(true);
        }
        
        if (e.getSource() == btnMenu) {
            setVisible(false);
            frmCrear = new Sistema();
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
    
    public static void main(String[] args) {
        new VentanaPersonal();
    }
}
