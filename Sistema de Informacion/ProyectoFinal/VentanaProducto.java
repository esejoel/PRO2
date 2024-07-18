import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VentanaProducto extends JFrame implements ActionListener
{
    Texto empresa= new Texto("TODO MOTO", 20, 30, 500, 30, Color.BLACK, 40);
    Texto indice= new Texto("PRODUCTOS", 30, 70, 1000, 20, Color.BLACK, 16);
    Texto buscarNombre= new Texto("Nombre:", 40, 110, 100, 20, Color.BLACK, 13);
    Caja tbBuscador= new Caja(40, 130, 5);
    Boton btnBuscar= new Boton("Buscar", 40, 160, 100, 30, Color.YELLOW);
    Boton btnActualizar= new Boton("Actualizar", 40, 240, 100, 30, Color.YELLOW);
    Boton btnEliminar= new Boton("Eliminar", 40, 280, 100, 30, Color.YELLOW);
    
    Texto codProducto= new Texto("Cod. Producto:", 290, 120, 100, 20, Color.BLACK, 16);
    Texto nombre= new Texto("Nombre: ", 290, 150, 100, 20, Color.BLACK, 16);
    Texto descripcion= new Texto("Industria: ", 290, 180, 100, 20, Color.BLACK, 16);
    Texto precio= new Texto("Precio: ", 290, 210, 100, 20, Color.BLACK, 16);
    Texto stock= new Texto("Stock: ", 290, 240, 100, 20, Color.BLACK, 16);
    Texto medida= new Texto("Medida: ", 290, 270, 100, 20, Color.BLACK, 16);
    
    Caja tbOldCodProducto = new Caja(0, 0, 5);
    Caja tbCodProducto= new Caja(410, 120, 5);
    Caja tbNombre= new Caja(410, 150, 5);
    Caja tbDescripcion= new Caja(410, 180, 5);
    Caja tbPrecio= new Caja(410, 210, 5);
    Caja tbStock= new Caja(410, 240, 5);
    Caja tbMedida= new Caja(410, 270, 5);
    Boton btnRegistrar= new Boton("REGISTRAR", 300, 320, 100, 30, Color.WHITE);
    Boton btnMenu= new Boton("MENU", 420, 320, 100, 30, Color.WHITE);
    
    public VentanaProducto()
    {
        //AÑADIR OBJETOS
        add(empresa);
        add(indice);
        add(buscarNombre);
        add(tbBuscador);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);
        
        add(codProducto);
        add(nombre);
        add(descripcion);
        add(precio);
        add(stock);
        add(medida);
        
        tbOldCodProducto.setVisible(false);
        add(tbOldCodProducto);
        add(tbCodProducto);
        add(tbNombre);
        add(tbDescripcion);
        add(tbPrecio);
        add(tbStock);
        add(tbMedida);
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
            String c = tbCodProducto.getText();
            String n = tbNombre.getText();
            String d = tbDescripcion.getText();
            double p = tbPrecio.getText().isEmpty() ? 0.0 : Double.parseDouble(tbPrecio.getText());
            int s = !tbStock.getText().isEmpty() ? Integer.parseInt(tbStock.getText()) : 0;
            String m = tbMedida.getText();

            Producto rp = new Producto(c, n, d, p, s, m);
            DBA.setProducto(rp);
            setTitle("GUARDADO");

            // Limpiar los campos después del registro
            tbCodProducto.setText("");
            tbNombre.setText("");
            tbDescripcion.setText("");
            tbPrecio.setText("");
            tbStock.setText("");
            tbMedida.setText("");
        }
        
        if (e.getSource() == btnBuscar) {
            try {
                String nombre = tbBuscador.getText().trim();
                Producto p = DBA.getProductoPorNombre(nombre);
                if (p != null) {
                    tbCodProducto.setText(p.getCodProducto());
                    tbNombre.setText(p.getNombre());
                    tbDescripcion.setText(p.getDescripcion());
                    tbPrecio.setText(String.valueOf(p.getPrecio()));
                    tbStock.setText(String.valueOf(p.getStock()));
                    tbMedida.setText(p.getMedida());
                    
                    // Almacenar el código antiguo en la caja de texto oculta
                    tbOldCodProducto.setText(p.getCodProducto());
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
                String oldCod = tbOldCodProducto.getText().trim(); // Código antiguo
                System.out.println("Código antiguo ingresado para actualización: " + oldCod);
                
                String newCod = tbCodProducto.getText(); // Nuevo código
                String n = tbNombre.getText();
                String d = tbDescripcion.getText();
                double p = tbPrecio.getText().isEmpty() ? 0.0 : Double.parseDouble(tbPrecio.getText());
                int s = !tbStock.getText().isEmpty() ? Integer.parseInt(tbStock.getText()) : 0;
                String m = tbMedida.getText();
                
                System.out.println("Intentando actualizar el producto con código antiguo: " + oldCod);
                Producto rp = new Producto(newCod, n, d, p, s, m);
                boolean actualizado = DBA.updateProducto(oldCod, rp);
                if (actualizado) {
                    setTitle("ACTUALIZADO");
                    JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
    
                // Limpiar los campos después de la actualización
                tbCodProducto.setText("");
                tbNombre.setText("");
                tbDescripcion.setText("");
                tbPrecio.setText("");
                tbStock.setText("");
                tbMedida.setText("");
                
                // Limpiar la caja de texto oculta
                tbOldCodProducto.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == btnEliminar) {
            try {
                String cod = tbCodProducto.getText().trim();
                boolean eliminado = DBA.deleteProducto(cod);
                if (eliminado) {
                    setTitle("ELIMINADO");
                    JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                // Limpiar los campos después de la eliminación
                tbCodProducto.setText("");
                tbNombre.setText("");
                tbDescripcion.setText("");
                tbPrecio.setText("");
                tbStock.setText("");
                tbMedida.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        new VentanaProducto();
    }
    
    public static void mostrarInventario() {
        // Imprimir encabezado de la tabla
        System.out.println("+-----------+----------------+----------------+--------+-------+---------+");
        System.out.println("| Código    | Nombre         | Descripción    | Precio | Stock | Medida  |");
        System.out.println("+-----------+----------------+----------------+--------+-------+---------+");

        // Iterar sobre el inventario y mostrar cada producto
        for (int i = 0; i < DB.ipr; i++) {
            Producto prod = DB.productoPos(i);
            System.out.printf("| %-9s| %-15s| %-15s| %-7.2f| %-6d| %-8s|%n",
                    prod.getCodProducto(), prod.getNombre(), prod.getDescripcion(),
                    prod.getPrecio(), prod.getStock(), prod.getMedida());
        }

        // Imprimir línea final de la tabla
        System.out.println("+-----------+----------------+----------------+--------+-------+---------+");
    }
}
