package exercise_resolve;

public class Main {

	//instanciar el primer frame de mi software
	
	public static void main(String[] args) {
		
		Container container = new Container();
		//esto es una inversion de dependencias
		container.draw(new Circle());
		container.draw(new Triangle());
		container.draw(new Square());
		
		//metodo abierto-cerrado para cuando se quiere añadir nuevas funcionalidades sin dañar nada
	}

}
