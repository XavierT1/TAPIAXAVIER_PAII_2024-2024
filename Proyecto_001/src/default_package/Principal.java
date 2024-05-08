package default_package;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		int suma = a + b;
		System.out.println("suma es: " + suma);
		
		//inversion de control 
		
		JFrame frame = new JFrame("Mi primer frame");
			frame.setSize(500, 500);
			frame.setVisible(true);
	
		//no tengo el control de los procesos que pasan por detras
		

	}

}
