import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.*;

public class Caja extends JTextField {

    private int radius; // Radio del borde redondeado

    public Caja(int px, int py, int radius) {
        super(10); // Tamaño de la caja de texto
        this.radius = radius;
        setBounds(px, py, 150, 25);
        setBorder(new RoundBorder(radius)); // Establecer el borde redondeado
    }

    // Clase interna para el borde redondeado
    private class RoundBorder implements Border {
        private int radius;

        public RoundBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        public boolean isBorderOpaque() {
            return false;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}