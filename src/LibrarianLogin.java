import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LibrarianLogin extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	public LibrarianLogin() {
		createUI();
	}

	private void createUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Librarian Login");

		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblName = new JLabel("Enter Name:");
		textField = new JTextField(10);

		JLabel lblPassword = new JLabel("Enter Password:");
		passwordField = new JPasswordField(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(this::performLogin);

		panel.add(lblName);
		panel.add(textField);
		panel.add(lblPassword);
		panel.add(passwordField);
		panel.add(new JLabel()); // Spacer
		panel.add(btnLogin);

		add(panel, BorderLayout.CENTER);
		pack(); // Adjusts size to fit components
	}

	private void performLogin(ActionEvent e) {
		String name = textField.getText();
		String password = new String(passwordField.getPassword());

		if (LibrarianDao.validate(name, password)) {
			LibrarianSuccess.main(new String[]{});
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
			textField.setText("");
			passwordField.setText("");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				LibrarianLogin frame = new LibrarianLogin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
