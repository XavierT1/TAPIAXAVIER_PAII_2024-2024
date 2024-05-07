package View;

import java.sql.SQLException;
import java.util.Scanner;

import Controller.MySQLStudentDAO;
import Model.Student;

public class Main {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
	    MySQLStudentDAO mySQLStudentDAO = new MySQLStudentDAO();
	    int studentId = 1; // Suponiendo que se está buscando el estudiante con ID 1

	    try {
	        Student student = mySQLStudentDAO.read(studentId);
	        if (student != null) {
	            System.out.println(student.toString());
	        } else {
	            System.out.println("No student found with ID: " + studentId);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Failed to retrieve student data.");
	    }
	}

}
