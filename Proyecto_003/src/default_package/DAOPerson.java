package default_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


//DEBER (todo en MY SQL (JDBC))

//Base de datos (instituto)
//4 tablas
//Alumno (id,name,lastname,age)
//Profesor (id,name,lastname,age)
//Materias (id,name,lastname,age)
//Horarios (id_mat,id_profesor,id_alumnos,hora_inicio,hora_fin,dia)
//
//Como se va a gestionar Connection
//tener una sola coneccion general para la coneccion usando un Patron de diseño 
//
//SUBIR APP
//*clases
//*interfaces
//*id
//*DAO´S (inyeccion de dependencias)




//permitir trabajar con los objetos
public class DAOPerson implements IDAO{
	
	Connection connection;
	
	//inyectando la dependencia (inversion de dependencia)
	public DAOPerson() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "labcom,2015");
	
	}
	
	
	public void closeConnection() throws SQLException{
		if(connection != null)
			connection.close();
	}
	
	public void cretePerson(Person person) throws SQLException{
	
		PreparedStatement ps = connection.prepareStatement("INSERT INTO person Values (?,?,?)");
		ps.setInt(1, person.getId());
		ps.setString(2, person.getName());
		ps.setInt(3, person.getAge());
		ps.execute();
		ps.close();
	}

	public Person readPerson(int id) {
		return null;
	}

	public void updatePerson(Person person) {
		
	}

	public void deletePerson(Person person) {
		
	}


	@Override
	public void crete() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
