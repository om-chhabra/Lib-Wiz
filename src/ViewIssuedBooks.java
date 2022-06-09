import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewIssuedBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				ViewIssuedBooks frame = new ViewIssuedBooks();
				frame.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error loading the frame: " + e.getMessage());
			}
		});
	}

	public ViewIssuedBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {}, // Data will be set later
				new String[] {} // Column names will be set later
		));
		loadData();

		JScrollPane sp = new JScrollPane(table);
		contentPane.add(sp, BorderLayout.CENTER);
	}

	private void loadData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try (Connection con = DB.getConnection();
			 PreparedStatement ps = con.prepareStatement("select * from issuebooks", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 ResultSet rs = ps.executeQuery()) {

			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			String[] columnNames = new String[cols];
			for (int i = 1; i <= cols; i++) {
				columnNames[i - 1] = rsmd.getColumnName(i);
			}
			model.setColumnIdentifiers(columnNames);

			while (rs.next()) {
				Object[] row = new Object[cols];
				for (int i = 1; i <= cols; i++) {
					row[i - 1] = rs.getObject(i);
				}
				model.addRow(row);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
