package egen.nivedita.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	private final static String DB_URL = "jdbc:mysql://localhost:3306/restaurant_db";
	private final static String DB_USER = "root";
	private final static String DB_PASSWORD ="root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver successfully loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver not loaded");
		}	
	}
	
	public static Connection getConnection() {
		Connection conn= null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("SQL Connection successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver manager not loaded");
		}
		return conn;
	}
	
	public static void closeResources( PreparedStatement ps, ResultSet rs, Connection con)
	{
		try {
			if (ps!=null){
				ps.close();
			}
			if (rs!=null){
				rs.close();
			}
			if (con!=null){
				con.close();
			}
		} 
		catch (SQLException e) {
				e.printStackTrace();
			}

		}
	
	public static void main(String[]args) {
		DBUtils.getConnection();
	}
}
