package default_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		
		try {
			
			Person person = new Person(3,"David",50);
			DAOPerson dao = new DAOPerson();
			dao.cretePerson(person);
//
//			//obteniendo datos de BD 
//			//READ
//			
//			ResultSet result = statement.executeQuery("SELECT * FROM pERSON");
//			
//			while (result.next()) {
//				System.out.println("Persona: "+result.getString("name"));
//				
//			}
//			
//			//Actualizar datos
//			//UPDATE
//			statement.execute("UPDATE person SET age = 35 WHERE id = 1");
//			
//			//borrar datos 
//			//DELETE
//			statement.execute("DELETE FROM person WHERE id = 2");
//			
//			//CRUD
//		
//			statement.close();
//			connection.close();
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}

}

