package game_galaga;

import interface_galaga.*;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.Random;
import java.awt.Color;

public class Villain implements Drawable, Movable, Deadable, Shootable {
	private int x, y;
	private int life = 100;
	private boolean alive = true;
	private int width = 30;
	private int height = 30;
	private List<VillainBullet> enemyBullets;
	private boolean moving = true;
	private boolean shooting = true;

	public Villain(int x, int y, List<VillainBullet> enemyBullets) {
		this.x = x;
		this.y = y;
		this.enemyBullets = enemyBullets;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		int[] xPoints = { x, x + 80, x + 80, x + 40, x };
		int[] yPoints = { y, y, y + 80, y + 40, y + 80 };

		// Factor de escala para ajustar el tamaño de la figura
		double scaleFactor = 2.1;

		// Aplicar el factor de escala a cada punto del polígono
		for (int i = 0; i < xPoints.length; i++) {
			xPoints[i] = (int) (x + (xPoints[i] - x) / scaleFactor);
			yPoints[i] = (int) (y + (yPoints[i] - y) / scaleFactor);
		}

		// Dibujar el polígono con los puntos escalados
		g.fillPolygon(xPoints, yPoints, 5);
	}

	@Override
	public void move() {
		y += 1;
	}

	@Override
	public boolean isDead() {
		return !alive;
	}

	@Override
	public void takeDamage(int damage) {
		life -= damage;
		if (life <= 0) {
			alive = false;
		}
	}

	@Override
	public void shoot() {
		if (new Random().nextInt(100) < 2) { // Probabilidad de disparo
			VillainBullet bullet = new VillainBullet(x + width / 2, y + height);
			enemyBullets.add(bullet);
		}
	}

	public void stopMoving() {
		moving = false;
	}

	public void stopShooting() {
		shooting = false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}