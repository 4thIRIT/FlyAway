	package database;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class DBconnection {
	
	

	public static Connection dbConn()
	{
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/flyaway", 
					"root", "root");

			System.out.println("DB conected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	

}
