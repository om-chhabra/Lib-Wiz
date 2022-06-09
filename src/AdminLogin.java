import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null); // Center the window
		setTitle("Admin Login");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		add(panel);

		JLabel lblAdminLoginForm = new JLabel("Admin Login Form");
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblAdminLoginForm);

		panel.add(new JLabel("Enter Name:"));
		textField = new JTextField(20);
		panel.add(textField);

		panel.add(new JLabel("Enter Password:"));
		passwordField = new JPasswordField(20);
		panel.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(e -> performLogin());
		panel.add(btnLogin);

		pack(); // Adjusts window size to fit all components
	}

	private void performLogin() {
		String name = textField.getText();
		String password = new String(passwordField.getPassword());
		if (name.equals("admin") && password.equals("admin123")) {
			AdminSuccess.main(new String[]{});
			dispose(); // Close the login window
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
			textField.setText("");
			passwordField.setText("");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			AdminLogin frame = new AdminLogin();
			frame.setVisible(true);
		});
	}
}
