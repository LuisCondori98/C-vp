package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MySqlConnection {

	public static Connection getConncetion() {
		
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/DB_Clinica?useSSL=false&serverTimezone=UTC";
		
		String user = "root";
		
		String password = "luiscondori";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		
		try {
			
			connection.close();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
