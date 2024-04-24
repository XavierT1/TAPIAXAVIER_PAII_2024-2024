package entities;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

import interface_galaga.Movable;

//En esta clase se definiran propiedades como posición, tamaño y métodos para 
//dibujar los aliens enemigos ademas de actualizar su posición.

public class Alien implements Movable{
    private int x, y;
    private final int width = 20;  // Ancho del alien
    private final int height = 20;  // Altura del alien
    private Random random = new Random();
    private int dx = random.nextInt(2) - 2;
    
    public Alien(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }
    
    @Override
    public void update() {

		 // Cambia dx aleatoriamente para un movimiento más natural
        dx += random.nextInt(3) - 1;
        dx = Math.max(Math.min(dx, 3), -3);  // Limita la velocidad máxima de dx

        x += dx;
        y += 1;  // Mueve constantemente hacia abajo

        // Mantener al alien dentro de los límites del área del juego
        if (x < 0) {
            x = 0;
            dx = -dx;  // Cambia la dirección al tocar el borde
        }
        if (x + width > 800) {  // Asumiendo que el ancho del panel es 800
            x = 800 - width;
            dx = -dx;  // Cambia la dirección al tocar el borde
        }
    }
       
    
	public void draw(Graphics g) {
	        g.setColor(Color.GREEN);  // Los aliens son verdes
	        g.fillRect(x, y, width, height);
	    }
	// Métodos getter para la posición y tamaño
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

