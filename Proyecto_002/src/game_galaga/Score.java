package game_galaga;

import interface_galaga.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score implements Drawable {
	private int score;
	private int fontSize;

	public Score() {
		this.score = 0;
		this.fontSize = 15;
	}

	public void resetScore() {
		this.score = 0;
	}

	public void increaseScore(int points) {
		score += points;
	}

	public void setFontSize(int size) {
		if (size > 0) {
			fontSize = size;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		g.drawString("Score: " + score, 650, 30);
	}

	public int getScore() {
		return score;
	}

}
