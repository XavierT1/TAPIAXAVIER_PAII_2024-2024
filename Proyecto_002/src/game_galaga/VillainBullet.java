package game_galaga;

import interface_galaga.*;
import java.awt.Graphics;
import java.awt.Color;

public class VillainBullet implements Drawable, Movable {
	private int x, y;
	private boolean isActive = true;

	public VillainBullet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		if (isActive) {
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 5, 10);
		}
	}

	@Override
	public void move() {
		y += 10; // Mover la bala hacia abajo
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
