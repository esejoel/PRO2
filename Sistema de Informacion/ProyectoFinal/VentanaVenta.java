import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VentanaVenta extends JFrame implements ActionListener
{
    Texto empresa= new Texto("TODO MOTO", 20, 30, 500, 30, Color.BLACK, 40);
    Texto indice= new Texto("VENTAS", 30, 70, 1000, 20, Color.BLACK, 16);
    Texto buscarVenta= new Texto("Cod. Venta:", 40, 110, 100, 20, Color.BLACK, 13);
    Caja tbBuscador= new Caja(40, 130, 5);
    Boton btnBuscar= new Boton("Buscar", 40, 160, 100, 30, Color.YELLOW);
    Boton btnActualizar= new Boton("Actualizar", 40, 240, 100, 30, Color.YELLOW);
    Boton btnEliminar= new Boton("Eliminar", 40, 280, 100, 30, Color.YELLOW);
    
    Texto codVenta= new Texto("Cod. Venta: ", 300, 120, 100, 20, Color.BLACK, 16);
    Texto fecha= new Texto("Fecha: ", 300, 150, 100, 20, Color.BLACK, 16);
    Texto cliente= new Texto("Cliente: ", 300, 180, 100, 20, Color.BLACK, 16);
    Texto cantidad= new Texto("Cantidad: ", 300, 210, 100, 20, Color.BLACK, 16);
    Texto producto= new Texto("Producto: ", 300, 240, 100, 20, Color.BLACK, 16);
    Texto total= new Texto("Total: ", 300, 270, 100, 20, Color.BLACK, 16);
    
    Caja tbOldCodVenta= new Caja(0, 0, 5);
    Caja tbCodVenta= new Caja(400, 120, 5);
    Caja tbFecha= new Caja(400, 150, 5);
    Caja tbCliente= new Caja(400, 180, 5);
    Caja tbCantidad= new Caja(400, 210, 5);
    Caja tbProducto= new Caja(400, 240, 5);
    Caja tbTotal= new Caja(400, 270, 5);
    
    Boton btnRegistrar= new Boton("REGISTRAR", 300, 320, 100, 30, Color.white);
    Boton btnMenu= new Boton("MENU", 420, 320, 100, 30, Color.white);
    
    public VentanaVenta()
    {
        //AÑADIR OBJETOS
        add(empresa);
        add(indice);
        add(buscarVenta);
        add(tbBuscador);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);
        
        add(codVenta);
        add(fecha);
        add(cliente);
        add(cantidad);
        add(producto);
        add(total);
        
        tbOldCodVenta.setVisible(false);
        add(tbOldCodVenta);
        add(tbCodVenta);
        add(tbFecha);
        add(tbCliente);
        add(tbCantidad);
        add(tbProducto);
        add(tbTotal);
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
            int cv = !tbCodVenta.getText().isEmpty() ? Integer.parseInt(tbCodVenta.getText()) : 0;
            String f = tbFecha.getText();
            String c = tbCliente.getText();
            int ca = !tbCantidad.getText().isEmpty() ? Integer.parseInt(tbCantidad.getText()) : 0;
            String p = tbProducto.getText();
            double t = tbTotal.getText().isEmpty() ? 0.0 : Double.parseDouble(tbTotal.getText());
            
            System.out.println("Registrando venta con código: " + cv); // Depuración
            
            Venta rv = new Venta(cv, f, c, ca, p, t);
            DBA.setVenta(rv);
            setTitle("GUARDADO");

            // Limpiar los campos después del registro
            tbCodVenta.setText("");
            tbFecha.setText("");
            tbCliente.setText("");
            tbCantidad.setText("");
            tbProducto.setText("");
            tbTotal.setText("");
        }
        
        if (e.getSource() == btnBuscar) {
            try {
                String codStr = tbBuscador.getText().trim();
                System.out.println("Código ingresado: " + codStr); // Depuración
                int cod = Integer.parseInt(codStr);
                Venta v = DBA.getVentaPorCod(cod);
                if (v != null) {
                    tbCodVenta.setText(String.valueOf(v.getCodVenta()));
                    tbFecha.setText(v.getFecha());
                    tbCliente.setText(v.getCliente());
                    tbCantidad.setText(String.valueOf(v.getCantidad()));
                    tbProducto.setText(v.getProducto());
                    tbTotal.setText(String.valueOf(v.getTotal()));
                    
                    // Almacenar el código antiguo en la caja de texto oculta
                    tbOldCodVenta.setText(String.valueOf(v.getCodVenta()));
                } else {
                    JOptionPane.showMessageDialog(this, "Registro NO encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al visualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnActualizar) {
            try {
                int oldCod = Integer.parseInt(tbOldCodVenta.getText().trim()); // Código antiguo
                System.out.println("Código antiguo ingresado para actualización: " + oldCod);
        
                int newCod = !tbCodVenta.getText().isEmpty() ? Integer.parseInt(tbCodVenta.getText()) : 0; // Nuevo código
                String f = tbFecha.getText();
                String c = tbCliente.getText();
                int ca = !tbCantidad.getText().isEmpty() ? Integer.parseInt(tbCantidad.getText()) : 0;
                String p = tbProducto.getText();
                double t = tbTotal.getText().isEmpty() ? 0.0 : Double.parseDouble(tbTotal.getText());
        
                System.out.println("Intentando actualizar la venta con código antiguo: " + oldCod);
                Venta rv = new Venta(newCod, f, c, ca, p, t);
                boolean actualizado = DBA.updateVenta(oldCod, rv);
        
                if (actualizado) {
                    setTitle("ACTUALIZADO");
                    JOptionPane.showMessageDialog(this, "Venta actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la actualización
                tbCodVenta.setText("");
                tbFecha.setText("");
                tbCliente.setText("");
                tbCantidad.setText("");
                tbProducto.setText("");
                tbTotal.setText("");
        
                // Limpiar la caja de texto oculta
                tbOldCodVenta.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar la venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnEliminar) {
            try {
                int codVenta = !tbCodVenta.getText().isEmpty() ? Integer.parseInt(tbCodVenta.getText()) : 0;
                boolean eliminado = DBA.deleteVenta(codVenta);
                if (eliminado) {
                    setTitle("ELIMINADO");
                    JOptionPane.showMessageDialog(this, "Venta eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la eliminación
                tbCodVenta.setText("");
                tbFecha.setText("");
                tbCliente.setText("");
                tbCantidad.setText("");
                tbProducto.setText("");
                tbTotal.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        new VentanaVenta();
    }
}
