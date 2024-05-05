package model_package;

import java.awt.Color;
import java.awt.Graphics;

import abstraction_package.Drawable;
import abstraction_package.Movable;


public class Hero implements Drawable, Movable{
	int[] cord_x = {400, 450 ,350};
	int[] cord_y = {500, 550 ,550};


	@Override
	public void draw(Graphics grafics) {
		grafics.setColor(Color.WHITE);
		grafics.fillPolygon(cord_x, cord_y,3);
		
	}


	@Override
	public void moveUp(int variable) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveDown(int variable) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void moveLeft(int variable) {
		//Restar
		for (int i = 0; i < cord_x.length; i++) {
			cord_x[i] = cord_x[i] - variable;
		}
	}


	@Override
	public void moveRigth(int variable) {
		// Sumar
		for (int i = 0; i < cord_x.length; i++) {
			cord_x[i] = cord_x[i] + variable;
		}
		
	}


	public int[] getCord_x() {
		return cord_x;
	}


	public int[] getCord_y() {
		return cord_y;
	}

}
