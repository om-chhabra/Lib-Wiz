import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LibrarianSuccess extends JFrame {
	public LibrarianSuccess() {
		createUI();
	}

	private void createUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Librarian Section");
		setSize(450, 433);
		setLocationRelativeTo(null); // Center the window

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblLibrarianSection = new JLabel("Librarian Section");
		lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLibrarianSection.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblLibrarianSection);

		panel.add(createButton("Add Books", e -> openWindow(BooksForm.class)));
		panel.add(createButton("View Books", e -> openWindow(ViewBooks.class)));
		panel.add(createButton("Issue Book", e -> openWindow(IssueBookForm.class)));
		panel.add(createButton("View Issued Books", e -> openWindow(ViewIssuedBooks.class)));
		panel.add(createButton("Return Book", e -> openWindow(ReturnBook.class)));
		panel.add(createButton("Logout", e -> logout()));

		getContentPane().add(panel);
	}

	private JButton createButton(String text, ActionListener action) {
		JButton button = new JButton(text);
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.addActionListener(action);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
		return button;
	}

	private void openWindow(Class<? extends JFrame> windowClass) {
		try {
			JFrame window = windowClass.newInstance();
			window.setVisible(true);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		dispose();
	}

	private void logout() {
		Library.main(new String[]{});
		dispose();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				LibrarianSuccess frame = new LibrarianSuccess();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
