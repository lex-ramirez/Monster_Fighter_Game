package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GameSetupScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSetupScreen window = new GameSetupScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameSetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("I lost the game!");
		lblNewLabel.setBounds(277, 24, 113, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Wanna play it or are you too pussy?");
		lblNewLabel_1.setBounds(220, 52, 262, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Fuck yeah!");
		btnNewButton.setBounds(62, 170, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Nahh :((((");
		btnNewButton_1.setBounds(444, 170, 117, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New Game");
		btnNewButton_2.setBounds(273, 93, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
	}
}
