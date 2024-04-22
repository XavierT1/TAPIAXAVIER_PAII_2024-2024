package default_package;

import interfaces_package.interfaceExample;
import interfaces_package.interfaceTwo;

public class Clase_B {
	
	//Concepto Basico de inversion de dependencias
	
	public Clase_B (interfaceExample ie) {
		ie.MetodoA();
		ie.MetodoB();
	}
	
	public Clase_B (interfaceTwo ie) {
		ie.MetodoC();
	}
}
