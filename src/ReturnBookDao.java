import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnBookDao {

	public static boolean delete(String bookcallno, int studentid) {
		boolean isDeleted = false;
		try (Connection con = DB.getConnection()) {
			// Updating book quantities first
			if (updateBook(bookcallno)) {
				try (PreparedStatement ps = con.prepareStatement("delete from issuebooks where bookcallno=? and studentid=?")) {
					ps.setString(1, bookcallno);
					ps.setInt(2, studentid);
					int rowsAffected = ps.executeUpdate();
					isDeleted = rowsAffected > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Consider replacing with more robust error handling
		}
		return isDeleted;
	}

	public static boolean updateBook(String bookcallno) {
		boolean isUpdated = false;
		try (Connection con = DB.getConnection()) {
			try (PreparedStatement ps = con.prepareStatement("select quantity,issued from books where callno=?")) {
				ps.setString(1, bookcallno);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						int quantity = rs.getInt("quantity");
						int issued = rs.getInt("issued");

						if (issued > 0) {
							try (PreparedStatement ps2 = con.prepareStatement("update books set quantity=?,issued=? where callno=?")) {
								ps2.setInt(1, quantity + 1);
								ps2.setInt(2, issued - 1);
								ps2.setString(3, bookcallno);

								int rowsAffected = ps2.executeUpdate();
								isUpdated = rowsAffected > 0;
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Consider replacing with more robust error handling
		}
		return isUpdated;
	}
}
