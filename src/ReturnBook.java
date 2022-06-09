import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReturnBook extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldBookCallNo;
	private JTextField textFieldStudentId;

	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Return Book");
		setSize(400, 300);
		setLocationRelativeTo(null); // Center on screen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblReturnBook);

		textFieldBookCallNo = new JTextField(20);
		textFieldStudentId = new JTextField(20);

		contentPane.add(new JLabel("Book Callno:"));
		contentPane.add(textFieldBookCallNo);
		contentPane.add(new JLabel("Student Id:"));
		contentPane.add(textFieldStudentId);

		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReturnBook.addActionListener(e -> returnBook());
		contentPane.add(btnReturnBook);

		JButton btnBack = new JButton("Back");
		btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBack.addActionListener(e -> goBack());
		contentPane.add(btnBack);

		JLabel lblNote = new JLabel("Note: Check the book properly!");
		lblNote.setForeground(Color.RED);
		lblNote.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNote);
	}
	private void returnBook() {
		String bookcallno = textFieldBookCallNo.getText();
		if (bookcallno.isEmpty() || textFieldStudentId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			int studentid = Integer.parseInt(textFieldStudentId.getText());
			boolean isDeleted = ReturnBookDao.delete(bookcallno, studentid);
			if (isDeleted) {
				JOptionPane.showMessageDialog(this, "Book returned successfully!");
				LibrarianSuccess.main(new String[]{});
				dispose(); // Close the current window
			} else {
				JOptionPane.showMessageDialog(this, "Sorry, unable to return book!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid student ID", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error processing the return", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void goBack() {
		LibrarianSuccess.main(new String[]{});
		dispose();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ReturnBook frame = new ReturnBook();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
