import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class IssueBookForm extends JFrame {
	private JTextField textFieldCallNo, textFieldStudentId, textFieldStudentName, textFieldStudentContact;
	private JButton btnIssueBook, btnBack;

	public IssueBookForm() {
		createUI();
	}

	private void createUI() {
		setTitle("Issue Book");
		setSize(438, 414);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 5, 5));

		panel.add(new JLabel("Book Callno:"));
		textFieldCallNo = new JTextField();
		panel.add(textFieldCallNo);

		panel.add(new JLabel("Student Id:"));
		textFieldStudentId = new JTextField();
		panel.add(textFieldStudentId);

		panel.add(new JLabel("Student Name:"));
		textFieldStudentName = new JTextField();
		panel.add(textFieldStudentName);

		panel.add(new JLabel("Student Contact:"));
		textFieldStudentContact = new JTextField();
		panel.add(textFieldStudentContact);

		btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(this::issueBookAction);
		panel.add(btnIssueBook);

		btnBack = new JButton("Back");
		btnBack.addActionListener(e -> dispose());
		panel.add(btnBack);

		add(panel, BorderLayout.CENTER);
		add(new JLabel("Note: Please check Student ID carefully before issuing book!", JLabel.CENTER), BorderLayout.SOUTH);
	}

	private void issueBookAction(ActionEvent e) {
		String bookcallno = textFieldCallNo.getText();
		int studentid = Integer.parseInt(textFieldStudentId.getText());
		String studentname = textFieldStudentName.getText();
		String studentcontact = textFieldStudentContact.getText();

		if (IssueBookDao.checkBook(bookcallno)) {
			int i = IssueBookDao.save(bookcallno, studentid, studentname, studentcontact);
			if (i > 0) {
				JOptionPane.showMessageDialog(this, "Book issued successfully!");
			} else {
				JOptionPane.showMessageDialog(this, "Sorry, unable to issue!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, Callno doesn't exist!");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				IssueBookForm frame = new IssueBookForm();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
