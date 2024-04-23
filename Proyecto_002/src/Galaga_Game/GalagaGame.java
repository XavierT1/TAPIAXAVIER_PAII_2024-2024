package Galaga_Game;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GalagaGame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GalagaGame frame = new GalagaGame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GalagaGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600); // Ajustar el tamaño de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Adding the triangle panel
        TrianglePanel trianglePanel = new TrianglePanel();
        trianglePanel.setBounds(10, 10, 780, 580); // Ajustar el tamaño y la posición del panel del triángulo
        contentPane.add(trianglePanel);
    }

    /**
     * Custom JPanel class that draws a triangle
     */
    private class TrianglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw a triangle
            g.drawLine(390, 10, 10, 570); // Left side
            g.drawLine(390, 10, 770, 570); // Right side
            g.drawLine(10, 570, 770, 570); // Base
        }
    }
}