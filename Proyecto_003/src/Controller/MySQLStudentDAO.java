package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Student;
import Model.StudentDAO;

public class MySQLStudentDAO implements StudentDAO {
	private static MySQLStudentDAO instance;
	private final Connection connection;

	public MySQLStudentDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Institute";
		String user = "root";
		String password = "123456";
		connection = DriverManager.getConnection(url, user, password);
	}

	public static MySQLStudentDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new MySQLStudentDAO();
		}
		return instance;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	@Override
	public void create(Student student) {
		String query = "INSERT INTO Student (name, lastName, age) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, student.getName());
			statement.setString(2, student.getLastName());
			statement.setInt(3, student.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student read(int id) {
		String query = "SELECT * FROM Student WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Student(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getString("lastName"), resultSet.getInt("age"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Student student) {
		String query = "DELETE FROM Student WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, student.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student student) {
		String query = "UPDATE Student SET name = ?, lastName = ?, age = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, student.getName());
			statement.setString(2, student.getLastName());
			statement.setInt(3, student.getAge());
			statement.setInt(4, student.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
