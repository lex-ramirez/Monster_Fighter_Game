package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PauseWindow {
	//dialog box?

	private JFrame frame;
	private BattleManager manager;


	/**
	 * Create the application.
	 */
	public PauseWindow(BattleManager manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void resumeGame() {
		manager.resume(this);
	}
	
	public void forfeitGame() {
		manager.forfeit(this);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Would you like to forfeit the game, "
				+ "losing all rewards and with all<br/> monsters retaining their health as it is right now?</html>");
		lblNewLabel.setBounds(6, 6, 444, 96);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Yeah...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forfeitGame();
				System.out.println("Going back to the main game");
			}
		});
		btnNewButton.setBounds(30, 114, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No way!!!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resumeGame();
			}
		});
		btnNewButton_1.setBounds(276, 114, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}
