import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	// Database credentials as constants
	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String USER = "root"; // Your database user
	private static final String PASS = "OM2003@mysql"; // Your database password

	// Static block to load the driver class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // Log or handle ClassNotFoundException
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace(); // Log or handle SQLException
		}
		return con;
	}
}
