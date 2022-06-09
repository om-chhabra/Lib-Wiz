import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class DeleteLibrarian extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	// Constants for messages
	private static final String ID_BLANK_MESSAGE = "Id can't be blank";
	private static final String RECORD_DELETED_MESSAGE = "Record deleted successfully!";
	private static final String DELETE_ERROR_MESSAGE = "Unable to delete given id!";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				DeleteLibrarian frame = new DeleteLibrarian();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public DeleteLibrarian() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEnterId = new JLabel("Enter Id:");
		textField = new JTextField(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.addActionListener(this::deleteLibrarianAction);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.addActionListener(e -> navigateBack());

		layoutComponents(lblEnterId, btnDelete, btnBack);
	}

	private void layoutComponents(JLabel lblEnterId, JButton btnDelete, JButton btnBack) {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		contentPane.setLayout(gl_contentPane);
		// Layout code goes here...
	}

	private void deleteLibrarianAction(ActionEvent e) {
		String sid = textField.getText();
		if (validateId(sid)) {
			int id = Integer.parseInt(sid);
			int i = LibrarianDao.delete(id);
			String message = i > 0 ? RECORD_DELETED_MESSAGE : DELETE_ERROR_MESSAGE;
			JOptionPane.showMessageDialog(this, message);
		}
	}

	private boolean validateId(String id) {
		if (id == null || id.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, ID_BLANK_MESSAGE);
			return false;
		}
		return true;
	}

	private void navigateBack() {
		AdminSuccess.main(new String[]{});
		dispose();
	}
}
