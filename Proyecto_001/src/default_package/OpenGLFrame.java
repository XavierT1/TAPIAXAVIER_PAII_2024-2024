package default_package;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author XavierTapia
 * Title: OpenGL Contenedores
 */

public class OpenGLFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private DrawingPanel drawingPanel;

    OpenGLFrame(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);

        JButton btn1 = createButton("Dibujar Triángulo");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setType("Triangulo");
            }
        });
        buttonPanel.add(btn1);

        JButton btn2 = createButton("Dibujar Cuadrado");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setType("Cuadrado");
            }
        });
        buttonPanel.add(btn2);

        JButton btn3 = createButton("Dibujar Círculo");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setType("Circulo");
            }
        });
        buttonPanel.add(btn3);

        JButton btn4 = createButton("Dibujar Pentágono");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setType("Pentagono");
            }
        });
        buttonPanel.add(btn4);

        JButton btn5 = createButton("Dibujar Hexágono");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setType("Hexagono");
            }
        });
        buttonPanel.add(btn5);

        this.setLayout(null); // No utiliza un administrador de diseño
        buttonPanel.setBounds(0, 0, 200, height); // Posición y tamaño del panel para los botones
        this.add(buttonPanel);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBounds(200, 0, width - 200, height); // Posición y tamaño del panel de dibujo
        this.add(drawingPanel);

        this.setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(180, 40));
        button.setBackground(Color.white); // cambiar el color de los botones
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        new OpenGLFrame("Proyecto_001", 800, 600);
    }
}

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private String type = "Circulo";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawString("Haz clic en un botón para dibujar una forma", 170, 20);

        if (type.equals("Triangulo")) {
        	drawTrianhulo(g, width, height);
        } else if (type.equals("Cuadrado")) {
        	drawCuadrado(g, width, height);
        } else if (type.equals("Circulo")) {
        	drawCirculo(g, width, height);
        } else if (type.equals("Pentagono")) {
        	drawPentagono(g, width, height);
        } else if (type.equals("Hexagono")) {
        	drawHexagono(g, width, height);
        }
    }

    private void drawTrianhulo(Graphics g, int width, int height) {
        // Dibuja un triángulo
        int[] xPoints = { width / 2, width / 2 - 110, width / 2 + 110 };
        int[] yPoints = { height / 2 - 110, height / 2 + 110, height / 2 + 110 };
        g.setColor(Color.BLUE);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    private void drawCuadrado(Graphics g, int width, int height) {
        // Dibuja un cuadrado
        g.setColor(Color.RED);
        g.fillRect(width / 2 - 100, height / 2 - 100, 200, 200);
    }

    private void drawCirculo(Graphics g, int width, int height) {
        // Dibuja un círculo
        g.setColor(Color.GREEN);
        g.fillOval(width / 2 - 100, height / 2 - 100, 200, 200);
    }

    private void drawPentagono(Graphics g, int width, int height) {
        // Dibuja un pentágono
        int[] xPoints = { width / 2, width / 2 - 50, width / 2 - 50, width / 2 + 50, width / 2 + 100 };
        int[] yPoints = { height / 2 - 100, height / 2 + 100, height / 2 + 100, height / 2 + 100, height / 2 + 50 };
        g.setColor(Color.ORANGE);
        g.fillPolygon(xPoints, yPoints, 5);
    }

    private void drawHexagono(Graphics g, int width, int height) {
        // Dibuja un hexágono
        int[] xPoints = { width / 2 - 50, width / 2 + 50, width / 2 + 100, width / 2 + 50, width / 2 - 50,
                width / 2 - 100 };
        int[] yPoints = { height / 2 - 100, height / 2 - 100, height / 2, height / 2 + 100, height / 2 + 100,
                height / 2 };
        g.setColor(Color.MAGENTA);
        g.fillPolygon(xPoints, yPoints, 6);
    }

    public void setType(String type) {
        this.type = type;
        repaint();
    }
}



