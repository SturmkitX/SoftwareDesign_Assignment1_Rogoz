package drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDriver {
	private static Connection connection = null;
	
	private ConnDriver() {
		// created in order to overwrite the public constructor
	}
	
	public static Connection getInstance() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");		// may need .newInstance()
				connection = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11227258?" +
				"user=sql11227258&password=mBzWNckV5N");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("SQLException: " + e.getMessage());
			    System.out.println("SQLState: " + e.getSQLState());
			    System.out.println("VendorError: " + e.getErrorCode());
			}
		}
		
		return connection;
	}
}