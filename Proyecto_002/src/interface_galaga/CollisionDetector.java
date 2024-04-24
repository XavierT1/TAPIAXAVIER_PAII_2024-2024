package interface_galaga;

import java.util.List;
import entities.Alien;
import entities.Bullet;

	public interface CollisionDetector {
		void checkCollisions(List<Bullet> bullets, List<Alien> aliens, int gameHeight, boolean[] gameOver);
	}


