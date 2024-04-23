package exercise_resolve;

import interface_resolved.Drawable;

//Gestionar los dibujos
//Comportamiento de los objetos 

public class Container {
	
	//ya no es recomendable hacer esto
	//	Triangle t;
	//	
	//	//solo nos sirve para inicializar variables (constructor)
	//	public Container(Triangle d) {
	//		t=d;
	//	}
		

		//Respeta el principio de responsabilidad unica
		//solo nos sirve para inicializar variables (constructor)
		public Container() {
			
		}
			
		
	
	//va a recibir la interface, llama al metodo draw de la interfaz no de las clases en conreto
	public void draw(Drawable d) {
		d.draw();
	}
}
