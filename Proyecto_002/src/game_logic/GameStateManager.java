package game_logic;

import java.util.ArrayList;
import java.util.List;
import entities.Alien;
import entities.Bullet;
import interface_galaga.CollisionDetector;

public class GameStateManager {
    private List<Bullet> bullets = new ArrayList<>();
    private List<Alien> aliens = new ArrayList<>();
    private boolean gameOver = false;
   
    //private int alienZoneHeight;
    private int gameWidth = 800;  // Ancho del área de juego
    private int gameHeight = 600;  // Alto del área de juego
    
    private int shipX, shipY;  // Posiciones de la nave
    private final int shipWidth = 30;  // Ancho de la nave
    private final int shipHeight = 20;  // Alto de la nave
    private final int shipZoneHeight = (int) (gameHeight * 0.33);
    private CollisionDetector collisionDetector;
   // private final int shipZoneHeight = gameHeight - alienZoneHeight; 
    
//    private final int gameHeight = 600;
    

    public GameStateManager(CollisionDetector collisionDetector, int gameWidth, int gameHeight) {
        this.collisionDetector = collisionDetector;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        initializeAliens();  // Inicializar aliens
        initializeShipPosition();  // Inicializar la posición de la nave
    }

    public void initializeAliens() {
        for (int i = 0; i < 5; i++) {
            aliens.add(new Alien(50 + i * 50, 50)); // Posiciones arbitrarias, ajusta según necesidad
        }
    }


//    public void initializeShipPosition() {
//        shipX = gameWidth / 2 - shipWidth / 2;
//        shipY = (int) (gameHeight * 0.66) + ((gameHeight - (int) (gameHeight * 0.66)) / 2) - shipHeight / 2;
//    }

    public void initializeShipPosition() {
        shipX = gameWidth / 2 - shipWidth / 2;
        shipY = gameHeight - shipZoneHeight + (shipZoneHeight / 2) - (shipHeight / 2);
    }

    
    public void moveShip(int dx, int dy) {
        shipX += dx;
        shipY += dy;

        // Límites horizontales: garantizar que la nave no se desplace fuera de los bordes izquierdo y derecho
        shipX = Math.max(0, Math.min(shipX, gameWidth - shipWidth));

        // Límites verticales: mantener la nave dentro del 33% inferior de la pantalla
        int lowerBound = gameHeight - shipZoneHeight; // Comienzo del 33% inferior
//        int upperBound = gameHeight - shipHeight; // Permitir que la nave llegue hasta la parte más baja posible sin desaparecer
        shipY = Math.max(lowerBound, Math.min(shipY, gameHeight - shipHeight));
    }


    public int getShipX() {
		return shipX;
	}

	public void setShipX(int shipX) {
		this.shipX = shipX;
	}

	public int getShipY() {
		return shipY;
	}

	public void setShipY(int shipY) {
		this.shipY = shipY;
	}

	public int getShipWidth() {
		return shipWidth;
	}

	public int getShipHeight() {
		return shipHeight;
	}

	public void update() {
        updateBullets();
        updateAliens();
        checkCollisions();
    }

    private void updateBullets() {
        bullets.removeIf(Bullet::isOffScreen);
        bullets.forEach(Bullet::update);
    }

    private void updateAliens() {
        aliens.forEach(Alien::update);
    }

    private void checkCollisions() {
    	 collisionDetector.checkCollisions(bullets, aliens, gameHeight, new boolean[]{gameOver});
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public void addAlien(Alien alien) {
        aliens.add(alien);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public int getGameWidth() {
        return gameWidth;
    }

    public int getGameHeight() {
        return gameHeight;
    }
}
