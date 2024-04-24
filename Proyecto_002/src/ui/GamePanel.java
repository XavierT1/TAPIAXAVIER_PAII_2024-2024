package ui;

import entities.Alien;
import javax.swing.JPanel;
import entities.Bullet;
import game_logic.GameCollisionDetector;
import game_logic.GameStateManager;
import interface_galaga.CollisionDetector;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


//Esta clase es la encargada de los gráficos y manejo de eventos del teclado.

public class GamePanel extends JPanel {
    private final int gameHeight = 600;
    private final int alienZoneHeight = (int) (gameHeight * 0.73); // 66% para los aliens
    private final int shipZoneHeight = gameHeight - alienZoneHeight; // 34% restante para la nave
//    private int shipX, shipY; // Posiciones de la nave
//    private final int shipWidth = 30;
//    private final int shipHeight = 20;
//    private List<Bullet> bullets = new ArrayList<>();
//    private List<Alien> aliens = new ArrayList<>();
//    private boolean gameOver = false;  // Controla si el juego ha terminado
    private Color lineColor = Color.BLUE; // Color de la línea de límite
//    private CollisionDetector collisionDetector;
    private GameStateManager gameStateManager;
    
    public GamePanel() {
        this.gameStateManager = new GameStateManager(new GameCollisionDetector(), 800, gameHeight); // Asignar tamaño adecuado
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new InputHandler(gameStateManager)); // Tamaño de la nave como argumento
        setFocusable(true);
     // Timer para repintar el panel cada 17 ms
        Timer timer = new Timer(17, e -> {
            gameStateManager.update();
            repaint();
        });
        timer.start();
    }
        
//        // Timer para repintar el panel cada 17 ms
//        Timer timer = new Timer(17, e -> repaint());
//        timer.start();
//    }

//        // Timer para repintar el panel cada 17 ms, aproximadamente 60 FPS
//        Timer timer = new Timer(17, e -> repaint());
//        timer.start();
//    }

    
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGameElements(g); // Dibuja elementos estáticos

    // Utiliza gameStateManager para obtener las balas y aliens
    gameStateManager.getAliens().forEach(alien -> alien.draw(g));
    gameStateManager.getBullets().forEach(bullet -> {
        bullet.update();
        bullet.draw(g);
    });

 
 // Dibuja la nave como un triángulo
    g.setColor(Color.WHITE);
    int shipX = gameStateManager.getShipX();
    int shipY = gameStateManager.getShipY();
    int shipWidth = gameStateManager.getShipWidth();
    int shipHeight = gameStateManager.getShipHeight();
    int[] xPoints = {shipX, shipX + shipWidth / 2, shipX + shipWidth};
    int[] yPoints = {shipY + shipHeight, shipY, shipY + shipHeight};
    g.fillPolygon(xPoints, yPoints, 3);
        
    // Línea del límite
    g.setColor(lineColor);
    int lineY = getHeight() - (shipZoneHeight);
    g.drawLine(0, lineY, getWidth(), lineY);

        // Mostrar Game Over si es necesario
    if (gameStateManager.isGameOver()) {
        displayGameOver(g);
    }
    
}


   
    
//    private void initializeAliens() {
//        for (int i = 0; i < 5; i++) {  // Añade 5 aliens por ejemplo
//            aliens.add(new Alien(50 + i * 50, 50));  // Posiciones arbitrarias, ajusta según necesidad
//        }
//    }
    
//    public void initializeShipPosition() {
//        shipX = getWidth() / 2 - shipWidth / 2;
//        shipY = alienZoneHeight + (shipZoneHeight / 2) - shipHeight / 2;
//    }
	private void displayGameOver(Graphics g) {
	        g.setColor(Color.RED);
	        g.setFont(new Font("Arial", Font.BOLD, 48));
	        g.drawString("Game Over", getWidth() / 2 - 150, getHeight() / 2);
	    }

	private void drawGameElements(Graphics g) {
        // Dibuja la zona de los aliens
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), alienZoneHeight);
    }
}


//        // Dibuja la nave
//        g.setColor(Color.WHITE);
//        int[] xPoints = {shipX, shipX + shipWidth / 2, shipX + shipWidth};
//        int[] yPoints = {shipY + shipHeight, shipY, shipY + shipHeight};
//        g.fillPolygon(new Polygon(xPoints, yPoints, 3));

    
//    private void handleKeyPress(KeyEvent e) {
//        int speed = 10;
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//                shipX = Math.max(0, shipX - speed);
//                break;
//            case KeyEvent.VK_RIGHT:
//                shipX = Math.min(getWidth() - shipWidth, shipX + speed);
//                break;
//            case KeyEvent.VK_UP:
//                shipY = Math.max(alienZoneHeight, shipY - speed);
//                break;
//            case KeyEvent.VK_DOWN:
//                shipY = Math.min(alienZoneHeight + shipZoneHeight - shipHeight, shipY + speed);
//                break;
//            case KeyEvent.VK_SPACE:
//                bullets.add(new Bullet(shipX + shipWidth / 2 - 2, shipY - 9));
//                break;
//
//        }
//        repaint();
//    }
//}

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        drawGameElements(g);
//
//        // Actualizar y dibujar balas
//        List<Bullet> bulletsToRemove = new ArrayList<>();
//        for (Bullet bullet : bullets) {
//            bullet.update();  // Actualiza la posición de la bala
//            bullet.draw(g);   // Dibuja la bala en su nueva posición
//            if (bullet.isOffScreen()) {
//                bulletsToRemove.add(bullet);
//            }
//        }
//        bullets.removeAll(bulletsToRemove);
//
//        // Actualizar y dibujar aliens, solo si el juego no ha terminado
//        if (!gameOver) {
//            for (Alien alien : aliens) {
//                alien.update();  // Actualiza la posición del alien
//                alien.draw(g);   // Dibuja el alien
//            }
//            // Verificar colisiones (esto puede modificar el estado de gameOver)
//            checkCollisions();
//        } else {
//            displayGameOver(g);  // Muestra el mensaje de Game Over
//        }
//	     // Dibujar la línea del límite
//	        g.setColor(lineColor);
//	        int lineY = getHeight() - shipZoneHeight;
//	        g.drawLine(0, lineY, getWidth(), lineY);
//	}
//}
//    
    

    
//    private void checkCollisions() {
//        List<Bullet> bulletsToRemove = new ArrayList<>();
//        List<Alien> aliensToRemove = new ArrayList<>();
//
//        for (Bullet bullet : bullets) {
//            for (Alien alien : aliens) {
//                if (bullet.getX() < alien.getX() + alien.getWidth() &&
//                    bullet.getX() + bullet.getWidth() > alien.getX() &&
//                    bullet.getY() < alien.getY() + alien.getHeight() &&
//                    bullet.getY() + bullet.getHeight() > alien.getY()) {
//                    bulletsToRemove.add(bullet);
//                    aliensToRemove.add(alien);
//                }
//            }
//        }
//        
//       
//     // Verificar si algún alien ha cruzado el límite del 33% inferior de la pantalla
//        for (Alien alien : aliens) {
//            if (alien.getY() + alien.getHeight() > this.getHeight() - shipZoneHeight) {
//                gameOver = true;  // Asumiendo que 'gameOver' es una variable booleana
//                break;  // No necesitamos comprobar más si el juego ya terminó
//            }
//        }
//        
////     // Verificar colisión entre la nave y los aliens
////        for (Alien alien : aliens) {
////            if (alien.getX() < shipX + shipWidth &&
////                alien.getX() + alien.getWidth() > shipX &&
////                alien.getY() < shipY + shipHeight &&
////                alien.getY() + alien.getHeight() > shipY) {
////                gameOver = true;  // Asumiendo que hay una variable booleana 'gameOver'
////            }
////        }
//
//        bullets.removeAll(bulletsToRemove);
//        aliens.removeAll(aliensToRemove);
//    }
//
//}
