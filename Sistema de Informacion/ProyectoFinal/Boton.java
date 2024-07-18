import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Boton extends JButton {

    public Boton(String txt, int px, int py, int tx, int ty, Color textColor) {
        super(txt); // Llama al constructor de JButton con el texto proporcionado
        setBounds(px, py, tx, ty); // Establece posición y tamaño usando setBounds
        setFont(new Font("Gill Sans MT", Font.PLAIN, 14)); // Cambia la fuente del botón a Arial, negrita, tamaño 14
        setForeground(textColor != null ? textColor : Color.BLACK); // Establece el color del texto del botón
        setBackground(Color.BLACK); // Establece el color de fondo del botón (predeterminado blanco)
        setBorder(createRoundBorder(10)); // Establece bordes redondeados con un radio de 10 píxeles
    }

    // Método para crear un borde redondeado personalizado
    private static Border createRoundBorder(int radius) {
        return new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
                g2.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(radius, radius, radius, radius);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        };
    }
}