package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.Schedule;
import Model.ScheduleDAO;

public class MySQLScheduleDAO implements ScheduleDAO {
	private static MySQLScheduleDAO instance;
	private final Connection connection;

	private MySQLScheduleDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Institute";
		String user = "root";
		String password = "123456";
		connection = DriverManager.getConnection(url, user, password);
	}

	public static MySQLScheduleDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new MySQLScheduleDAO();
		}
		return instance;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	@Override
	public void create(Schedule schedule) {
		// TODO Auto-generated method stub

	}

	@Override
	public Schedule read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Schedule schedule) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Schedule schedule) {
		// TODO Auto-generated method stub

	}

}
