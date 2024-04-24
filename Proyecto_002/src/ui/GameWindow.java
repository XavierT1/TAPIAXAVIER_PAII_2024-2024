package ui;

import javax.swing.JFrame;

//Esta clase la encargada de configurar la ventana del juego y contener el panel principal del juego.

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Galaga Game");
        setSize(800, 600); // Tamaño específico para el juego
        setLocationRelativeTo(null); // Centrar en pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void initUI() {
        GamePanel gamePanel = new GamePanel(); // GamePanel ya maneja la inicialización de la nave
        add(gamePanel);
        setVisible(true);
    }
}