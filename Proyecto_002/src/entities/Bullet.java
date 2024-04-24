package entities;

import java.awt.Graphics;
import java.awt.Color;  // Importa la clase Color

//En esta clase se almacenará la posición y la velocidad de cada bala

public class Bullet {
    private int x, y;
    private final int speed = 10;  // Velocidad de la bala
    private final int width = 5;  // Ancho de la elipse
    private final int height = 15;  // Altura de la elipse
    public Bullet(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update() {
        y -= speed;  // La bala se mueve hacia arriba
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);  // Color de las balas 
        g.fillOval(x, y, width, height);  // Dibuja una elipse en la posición actual
    }

    public boolean isOffScreen() {
        return y < 0;  // Verifica si la bala ha salido completamente de la pantalla
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
    
}
