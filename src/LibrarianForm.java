import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LibrarianForm extends JFrame {
	private JPanel contentPane;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField contactField;

	public LibrarianForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setTitle("Add Librarian");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);

		addLabelAndField("Name:", nameField = new JTextField(20));
		addLabelAndField("Password:", passwordField = new JPasswordField(20));
		addLabelAndField("Email:", emailField = new JTextField(20));
		addLabelAndField("Address:", addressField = new JTextField(20));
		addLabelAndField("City:", cityField = new JTextField(20));
		addLabelAndField("Contact No:", contactField = new JTextField(20));

		JButton addButton = new JButton("Add Librarian");
		addButton.addActionListener(e -> addLibrarian());
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(addButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> goBack());
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(backButton);

		pack();
		setLocationRelativeTo(null);
	}

	private void addLabelAndField(String label, JComponent field) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(new JLabel(label));
		panel.add(field);
		contentPane.add(panel);
	}

	private void addLibrarian() {
		// Implement adding librarian logic
		JOptionPane.showMessageDialog(this, "Librarian added successfully!");
		// AdminSuccess.main(new String[]{}); // Navigate back to admin success screen
		dispose(); // Close current frame
	}

	private void goBack() {
		// AdminSuccess.main(new String[]{}); // Navigate back to admin success screen
		dispose(); // Close current frame
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new LibrarianForm().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
