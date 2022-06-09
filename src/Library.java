import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Library extends JFrame {

	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Library Management System");
		setSize(450, 300);
		setLocationRelativeTo(null); // Center on screen
		setResizable(false);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JLabel lblLibraryManagement = new JLabel("Library Wizard");
		lblLibraryManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLibraryManagement.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblLibraryManagement);

		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdminLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdminLogin.addActionListener(e -> {
			AdminLogin.main(new String[]{});
			dispose();
		});
		contentPane.add(btnAdminLogin);

		JButton btnLibrarianLogin = new JButton("Librarian Login");
		btnLibrarianLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLibrarianLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLibrarianLogin.addActionListener(e -> {
			LibrarianLogin.main(new String[]{});
			dispose();
		});
		contentPane.add(btnLibrarianLogin);

		// Add some spacing between the buttons
		btnAdminLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnAdminLogin.getMinimumSize().height));
		btnLibrarianLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnLibrarianLogin.getMinimumSize().height));
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Library frame = new Library();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
