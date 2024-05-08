package default_package;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author XavierTapia
 * Title: Contenedores
 */

public class BtnJava extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private enum Shape { TRIANGLE, SQUARE, CIRCLE }
    private Shape currentShape = null;
    private JPanel panel;

    /**
     * Launch de la aplicacion
     *
     *.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { 
                    BtnJava frame = new BtnJava();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crear el frame.
     */
    public BtnJava() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Triangulo");
        btnNewButton.setBounds(24, 66, 103, 21);
        contentPane.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Cuadrado");
        btnNewButton_2.setBounds(24, 175, 103, 21);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Circulo");
        btnNewButton_1.setBounds(24, 122, 103, 21);
        contentPane.add(btnNewButton_1);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentShape != null) {
                    switch (currentShape) {
                        case TRIANGLE:
                            g.setColor(Color.BLUE);
                            int[] x = {100, 150, 50};
                            int[] y = {50, 150, 150};
                            g.fillPolygon(x, y, 3);
                            break;
                        case SQUARE:
                            g.setColor(Color.RED);
                            g.fillRect(50, 50, 100, 100);
                            break;
                        case CIRCLE:
                            g.setColor(Color.GREEN);
                            g.fillOval(50, 50, 100, 100);
                            break;
                    }
                }
            }
        };
        panel.setBackground(Color.WHITE);
        panel.setBounds(177, 53, 192, 200);
        contentPane.add(panel);
        
        JLabel lblNewLabel = new JLabel("Proyecto_001");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(159, 10, 103, 21);
        contentPane.add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShape = Shape.TRIANGLE;
                panel.repaint();
            }
        });

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShape = Shape.SQUARE;
                panel.repaint();
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentShape = Shape.CIRCLE;
                panel.repaint();
            }
        });
    }
}
