import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Texto extends JLabel {
    public Texto(String txt, int px, int py, int tx, int ty, Color color, int fontSize) {
        setText(txt);  
        setBounds(px, py, tx, ty);  // Utilizando setBounds en lugar de setLocation y setSize
        setFont(new Font("Gill Sans MT", Font.PLAIN, fontSize));  // Usando la fuente Arial, tamaño especificado
        setForeground(color != null ? color : Color.BLACK);  // Si color es null, usa negro como color de fuente
    }
    // Método para establecer la fuente por defecto
    private void setDefaultFont() {
        setFont(new Font("Gill Sans MT", Font.PLAIN, 20));  // Definiendo la fuente Arial, tamaño 20, sin estilo adicional
    }
} 