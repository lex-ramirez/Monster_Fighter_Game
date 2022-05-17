package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

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
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("I lost the game!");
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		frame.getContentPane().add(label_2);

		JLabel lblNewLabel_1 = new JLabel("Wanna play it or are you too pussy?");
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("");
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		frame.getContentPane().add(label_4);
						
						JLabel label_5 = new JLabel("");
						frame.getContentPane().add(label_5);
				
						JButton btnNewButton = new JButton("Fuck yeah!");
						frame.getContentPane().add(btnNewButton);
				
				JLabel label_6 = new JLabel("");
				frame.getContentPane().add(label_6);
				
				JLabel lblNewLabel_2 = new JLabel("New label");
				frame.getContentPane().add(lblNewLabel_2);
				
						JButton btnNewButton_2 = new JButton("New Game");
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("PENIS");
							}
						});
						frame.getContentPane().add(btnNewButton_2);
		
				JButton btnNewButton_1 = new JButton("Nahh :((((");
				frame.getContentPane().add(btnNewButton_1);
		
		JLabel label_7 = new JLabel("");
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		frame.getContentPane().add(label_8);
	}
}
