package model_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import abstraction_package.Drawable;
import abstraction_package.Movable;
public class Opponents implements Drawable,Movable{

	int[] cord_x = {100,200,200,150,100};
	int[] cord_y = {100,100,150,125,150};
	
	public Opponents(int randomX, int randomY) {
		cord_x[0] = cord_x[0] + randomX;
		cord_x[1] = cord_x[1] + randomX;
		cord_x[2] = cord_x[2] + randomX;
		cord_x[3] = cord_x[3] + randomX;
		cord_x[4] = cord_x[4] + randomX;
	}
	@Override
	public void draw(Graphics grafics) {
		grafics.setColor(Color.GREEN);
		grafics.fillPolygon(cord_x, cord_y,5);
		
		
	}

	@Override
	public void moveUp(int variable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown(int variable) {
		for (int i = 0; i < cord_y.length; i++) {
			cord_x[i] =  cord_x[i] + variable;
			
		}
		
	}

	@Override
	public void moveLeft(int variable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRigth(int variable) {
		// TODO Auto-generated method stub
		
	}
	
}
