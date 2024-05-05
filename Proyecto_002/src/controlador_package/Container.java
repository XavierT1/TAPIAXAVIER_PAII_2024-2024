package controlador_package;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import model_package.Bullet;
import model_package.Hero;
import model_package.Opponents;

public class Container {
	
	final int SCREEN_WITDH = 700;
	final int SCREEN_HEIGHT = 200;
	Hero hero = new Hero();
	List<Opponents> opponets = new ArrayList();
	List<Bullet> bullets = new ArrayList();
	
	Random random = new Random();
	
	
	public Container() {
		for (int i = 0; i < 5; i++) {
			opponets.add(new Opponents(random.nextInt(SCREEN_WITDH), random.nextInt(SCREEN_HEIGHT)));
        }

	}
	
	public void draw(Graphics graphics) {
		hero.draw(graphics);
        for (Opponents opponent : opponets) {
            opponent.draw(graphics);
        }
        for (Bullet bullet : bullets) {
            bullet.draw(graphics);
        }
    }
	
	public void updateBullets() {
        Iterator<Bullet> it = bullets.iterator();
        while (it.hasNext()) {
            Bullet bullet = it.next();
            bullet.moveUp(5);
            if (bullet.getY() < 0) {
                it.remove();
            }
        }
    }

	public void fireBullet() {
	    // Calculamos el centro horizontal del héroe
	    int minX = Integer.MAX_VALUE;
	    int maxX = Integer.MIN_VALUE;
	    for (int x : hero.getCord_x()) {
	        if (x < minX) {
	            minX = x;
	        }
	        if (x > maxX) {
	            maxX = x;
	        }
	    }
	    int centerX = (minX + maxX) / 2;

	    // Usamos el punto más bajo del héroe como startY (la punta más baja del triángulo)
	    int maxY = Integer.MIN_VALUE;
	    for (int y : hero.getCord_y()) {
	        if (y > maxY) {
	            maxY = y;
	        }
	    }
	    int startY = maxY;

	    // Añadimos la bala a la lista con un ligero desplazamiento hacia arriba para no colisionar instantáneamente con el héroe
	    bullets.add(new Bullet(centerX, startY - 10)); // La bala será creada 10 pixeles por encima del punto más alto del héroe
	}
    
	
	public void moveLeft(int variable) {
		hero.moveLeft(variable);
		
	}
	
	public void moveRigth(int variable) {
		hero.moveRigth(variable);
	}
	
	public void moveDown(int variable) {
		for (int i = 0;i < opponets.size();i++) {
			opponets.get(i).moveDown(variable);
			
		}
	}
	
	
}
