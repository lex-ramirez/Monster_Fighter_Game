package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopTutorialWindow {
	private ShopManager manager;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopTutorialWindow window = new ShopTutorialWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ShopTutorialWindow(ShopManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	public void continueFromWindow() {
		manager.continueTutorialWindow(this);
	}
	
	public void backFromWindow() {
		manager.goBackTutorialWindow(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width =  screenSize.width;
		int height =  screenSize.height;
		frame.setBounds(100, 100, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeTextLabel = new JLabel("<html>Welcome to the shop!!<br/><br/>"
				+ "Here you can buy items to heal the monsters in your team, or even s"
				+ "ome more monsters to add to your team!<br/><br/>"
				+ "If you hover your mouse over items, a short description of the effects of that item "
				+ "will appear.<br/>"
				+ "To purchase an item, simply click on its icon<br/>"
				+ "Items are only in limited stock, so if we sell out of something, you'll have to wait for me to "
				+ "renew my inventory overnight.<br/><br/>"
				+ "If you pay a small fee, I could even be convinced to update my inventory...<br/><br/>"
				+ "Good luck traveller! I hope you find what you're looking for within.</html>");
		welcomeTextLabel.setVerticalAlignment(SwingConstants.CENTER);
		welcomeTextLabel.setBounds(29, 20, 1445, 220);
		frame.getContentPane().add(welcomeTextLabel);
		
		JButton continueButton = new JButton("Continue to the shop");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continueFromWindow();
			}
		});
		continueButton.setBounds(1192, 516, 234, 153);
		frame.getContentPane().add(continueButton);
		
		JButton backButton = new JButton("Go back to the main game");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backFromWindow();
			}
		});
		backButton.setBounds(70, 516, 234, 153);
		frame.getContentPane().add(backButton);
	}
}
