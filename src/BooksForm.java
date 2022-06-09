import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BooksForm extends JFrame {
	private JPanel contentPane;
	private JTextField txtCallNo;
	private JTextField txtName;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	private JTextField txtQuantity;

	public BooksForm() {
		setTitle("Add Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);

		contentPane.add(createLabelFieldPanel("Call No:", txtCallNo = new JTextField(20)));
		contentPane.add(createLabelFieldPanel("Name:", txtName = new JTextField(20)));
		contentPane.add(createLabelFieldPanel("Author:", txtAuthor = new JTextField(20)));
		contentPane.add(createLabelFieldPanel("Publisher:", txtPublisher = new JTextField(20)));
		contentPane.add(createLabelFieldPanel("Quantity:", txtQuantity = new JTextField(20)));

		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(e -> addBook());
		contentPane.add(btnAddBooks);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(e -> goBack());
		contentPane.add(btnBack);

		pack();
		setLocationRelativeTo(null); // Center on screen
	}

	private JPanel createLabelFieldPanel(String labelText, JTextField textField) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(new JLabel(labelText));
		panel.add(textField);
		return panel;
	}

	private void addBook() {
		// Implement validation and book adding logic
		JOptionPane.showMessageDialog(this, "Books added successfully!");
		// LibrarianSuccess.main(new String[]{}); // Navigate back to librarian success screen
		dispose(); // Close current frame
	}

	private void goBack() {
		// Implement logic to go back to the previous screen
		dispose(); // Close current frame
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new BooksForm().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
