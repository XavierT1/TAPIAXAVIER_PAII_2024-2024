package game_galaga;

import interface_galaga.*;
import java.awt.Graphics;
import java.awt.Color;

public class Line implements Drawable {
	private int y;

	public Line(int y) {
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawLine(0, y, 800, y);
	}

	public int getY() {
		return y; // Devuelve el valor real de la coordenada y
	}
}
