import java.sql.*;

public class LibrarianDao {

	private static final String INSERT_LIBRARIAN_SQL = "INSERT INTO librarian(name, password, email, address, city, contact) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String DELETE_LIBRARIAN_SQL = "DELETE FROM librarian WHERE id=?";
	private static final String VALIDATE_LIBRARIAN_SQL = "SELECT * FROM librarian WHERE name=? AND password=?";

	public static int save(String name, String password, String email, String address, String city, String contact) {
		int status = 0;
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement(INSERT_LIBRARIAN_SQL)) {
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, city);
			ps.setString(6, contact);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement(DELETE_LIBRARIAN_SQL)) {
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean validate(String name, String password) {
		boolean status = false;
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement(VALIDATE_LIBRARIAN_SQL)) {
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
