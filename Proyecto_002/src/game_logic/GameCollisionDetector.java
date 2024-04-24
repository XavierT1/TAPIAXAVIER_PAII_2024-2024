package game_logic;

import java.util.ArrayList;
import java.util.List;
import entities.Alien;
import entities.Bullet;
import interface_galaga.CollisionDetector;

public class GameCollisionDetector implements CollisionDetector {
    @Override
    public void checkCollisions(List<Bullet> bullets, List<Alien> aliens, int gameHeight, boolean[] gameOver) {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        List<Alien> aliensToRemove = new ArrayList<>();

        for (Bullet bullet : bullets) {
            for (Alien alien : aliens) {
                if (bullet.getX() < alien.getX() + alien.getWidth() &&
                    bullet.getX() + bullet.getWidth() > alien.getX() &&
                    bullet.getY() < alien.getY() + alien.getHeight() &&
                    bullet.getY() + bullet.getHeight() > alien.getY()) {
                    bulletsToRemove.add(bullet);
                    aliensToRemove.add(alien);
                }
            }
        }

        // Verificar si algún alien ha cruzado el límite del 33% inferior de la pantalla
        int shipZoneHeight = (int) (gameHeight * 0.34);  // Calcula el 34% restante para la nave
        for (Alien alien : aliens) {
            if (alien.getY() + alien.getHeight() > gameHeight - shipZoneHeight) {
                gameOver[0] = true;  // Asumiendo que gameOver es un array para mutabilidad
                break;
            }
        }

        bullets.removeAll(bulletsToRemove);
        aliens.removeAll(aliensToRemove);
    }
}
