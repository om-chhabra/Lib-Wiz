import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminSuccess extends JFrame {
	public AdminSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		setTitle("Admin Section");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);

		JLabel lblAdminSection = new JLabel("Admin Section");
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdminSection.setForeground(Color.GRAY);
		lblAdminSection.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblAdminSection);

		addActionButton(contentPane, "Add Librarian", e -> openForm("LibrarianForm"));
		addActionButton(contentPane, "View Librarian", e -> openForm("ViewLibrarian"));
		addActionButton(contentPane, "Delete Librarian", e -> openForm("DeleteLibrarian"));
		addActionButton(contentPane, "Logout", e -> logout());

		pack(); // Adjusts the frame to fit the preferred size and layouts of its subcomponents
		setLocationRelativeTo(null); // Center the window
	}

	private void addActionButton(JPanel panel, String label, ActionListener action) {
		JButton button = new JButton(label);
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(action);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(button);
	}

	private void openForm(String formName) {
		// Logic to open the specific form
		// e.g., LibrarianForm.main(new String[]{});
		System.out.println(formName + " opened.");
		dispose();
	}

	private void logout() {
		// Logic to perform logout
		// e.g., Library.main(new String[]{});
		System.out.println("Logged out.");
		dispose();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new AdminSuccess().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
