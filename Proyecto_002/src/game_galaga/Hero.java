package game_galaga;

import interface_galaga.*;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero implements Drawable, Movable, Deadable, Shootable {
	private int x, y;
	private int health = 100;
	private int width = 45;
	private int height = 25;
	private int life = 100;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;
	private List<HeroBullet> heroBullet;

	public Hero(int x, int y, List<HeroBullet> heroBullet) {
		this.x = x;
		this.y = y;
		this.heroBullet = heroBullet;

	}

	public boolean isDestroyed() {
		return life <= 0;
	}

	@Override
	public void draw(Graphics g) {
		int[] xpoints = { x - width / 2, x, x + width / 2 };
		int[] ypoints = { y, y - height, y };
		Polygon ship = new Polygon(xpoints, ypoints, 3);

		// Factor de escala para ajustar el tamaño del héroe
		double scaleFactor = 1;

		// Aplicar el factor de escala a cada punto del polígono
		for (int i = 0; i < xpoints.length; i++) {
			xpoints[i] = (int) (x + (xpoints[i] - x) * scaleFactor);
			ypoints[i] = (int) (y + (ypoints[i] - y) * scaleFactor);
		}

		// Dibujar el polígono con los puntos escalados
		g.setColor(Color.WHITE);
		g.fillPolygon(new Polygon(xpoints, ypoints, 3));
	}

	@Override
	public void move() {
		if (movingLeft && x > 25) {
			x -= 6;
		}
		if (movingRight && x < 800 - width) {
			x += 6;
		}
		if (movingUp && y > 424) {
			y -= 6;
		}
		if (movingDown && y < 580 - height) {
			y += 6;
		}
	}

	@Override
	public boolean isDead() {
		return health <= 0;
	}

	@Override
	public void takeDamage(int damage) {
		life -= damage;
		if (life <= 0) {
			life = 0;
		}
		System.out.println("El héroe ha recibido " + damage + " puntos de daño.");

	}

	@Override
	public void shoot() {
		int bulletWidth = 23;
		int bulletHeight = 30;
		HeroBullet bullet = new HeroBullet(x + width / 2 - bulletWidth, y - bulletHeight);

		heroBullet.add(bullet);

	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
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

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}