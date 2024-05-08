package game_galaga;

import java.awt.Graphics;

import interface_galaga.Drawable;
import interface_galaga.Movable;

import java.awt.Color;

public class HeroBullet implements Drawable, Movable {
	private int x, y;
	private boolean isActive = true;

	public HeroBullet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		if (isActive) {
			g.setColor(Color.RED);
			g.fillOval(x, y, 5, 10);
		}
	}

	public void move() {
		y -= 10; // Mover la bala hacia arriba
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
