package model_package;

import java.awt.Color;
import java.awt.Graphics;

import abstraction_package.Drawable;
import abstraction_package.Movable;

public class Bullet implements Drawable, Movable{

	private int x, y;
	private final int speed = 10; // Velocidad con la que la bala se moverá hacia arriba

	public Bullet(int startX, int startY) {
	     this.x = startX;
	     this.y = startY;
	}
	@Override
	public void moveUp(int variable) {
		y -= speed;
		
	}

	@Override
	public void moveDown(int variable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft(int variable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRigth(int variable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.RED);
        graphics.fillOval(x, y, 5, 10);
		
	}
	public int getY() {
		return y;
	}
	

}
