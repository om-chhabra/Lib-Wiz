import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {

	public static int save(String callno, String name, String author, String publisher, int quantity) {
		int status = 0;
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement("INSERT INTO books(callno, name, author, publisher, quantity) VALUES(?,?,?,?,?)")) {

			ps.setString(1, callno);
			ps.setString(2, name);
			ps.setString(3, author);
			ps.setString(4, publisher);
			ps.setInt(5, quantity);

			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(); // It's usually not recommended to print the stack trace in production code
		}
		return status;
	}
}
