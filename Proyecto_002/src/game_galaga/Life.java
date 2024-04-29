package game_galaga;

import java.awt.Color;
import java.awt.Graphics;

import interface_galaga.Drawable;

public class Life implements Drawable {
	private int life;
	private int maxLife;

	public Life(int initialLife) {
		this.maxLife = initialLife; // Establece la vida máxima
		this.life = initialLife; // Suponemos que la vida inicial es también la máxima
	}

	@Override
	public void draw(Graphics g) {
		// Color de fondo de la barra de vida
		g.setColor(Color.WHITE);
		int barWidth = 200; // Ancho total de la barra de vida
		int barHeight = 10; // Altura de la barra de vida
		int xOffset = 20; // Posición inicial x de la barra
		int yOffset = 20; // Posición inicial y de la barra

		g.fillRect(xOffset, yOffset, barWidth, barHeight);

		int lifeWidth = (int) ((life / (double) maxLife) * barWidth);
		// Color de la barra de vida actual
		g.setColor(Color.RED);
		g.fillRect(xOffset, yOffset, lifeWidth, barHeight);

		g.setColor(Color.WHITE);
		String lifeText = life + "/" + maxLife;
		g.drawString(lifeText, xOffset + (barWidth / 2) - g.getFontMetrics().stringWidth(lifeText) / 2,
				yOffset + barHeight + 12);
	}

	public void resetLife() {
		this.life = this.maxLife; // Restablecer la vida al máximo
	}

	// Método para actualizar la vida, asegurando que no exceda la vida máxima ni
	// caiga por debajo de cero
	public void updateLife(int delta) {
		life += delta;
		if (life > maxLife) {
			life = maxLife;
		} else if (life < 0) {
			life = 0;
		}
	}

	// Método para obtener la vida actual
	public int getLife() {
		return life;
	}
}
