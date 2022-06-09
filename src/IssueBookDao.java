import java.sql.*;

public class IssueBookDao {

	public static boolean checkBook(String bookcallno) {
		boolean status = false;
		String query = "SELECT * FROM books WHERE callno=?";
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, bookcallno);
			try (ResultSet rs = ps.executeQuery()) {
				status = rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Consider using logging here
		}
		return status;
	}

	public static int save(String bookcallno, int studentid, String studentname, String studentcontact) {
		int status = 0;
		if (updateBook(bookcallno) > 0) {
			String query = "INSERT INTO issuebooks(bookcallno, studentid, studentname, studentcontact) VALUES(?,?,?,?)";
			try (Connection con = DB.getConnection();
				 PreparedStatement ps = con.prepareStatement(query)) {

				ps.setString(1, bookcallno);
				ps.setInt(2, studentid);
				ps.setString(3, studentname);
				ps.setString(4, studentcontact);
				status = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace(); // Consider using logging here
			}
		}
		return status;
	}

	private static int updateBook(String bookcallno) {
		int status = 0;
		String selectQuery = "SELECT quantity, issued FROM books WHERE callno=?";
		String updateQuery = "UPDATE books SET quantity=?, issued=? WHERE callno=?";
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement(selectQuery)) {

			ps.setString(1, bookcallno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int quantity = rs.getInt("quantity");
				int issued = rs.getInt("issued");

				if (quantity > 0) {
					try (PreparedStatement ps2 = con.prepareStatement(updateQuery)) {
						ps2.setInt(1, quantity - 1);
						ps2.setInt(2, issued + 1);
						ps2.setString(3, bookcallno);
						status = ps2.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Consider using logging here
		}
		return status;
	}
}
