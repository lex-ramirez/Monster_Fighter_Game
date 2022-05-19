package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ShopAndItems.Item;

public class BattleInventory {

	private JFrame frame;
	private BattleManager manager;
	

	/**
	 * Create the application.
	 */
	public BattleInventory(BattleManager manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeInventory(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int itemsDisplayed = 0;
		int[] itemCooords = {30, 30, 160, 30, 30, 190, 160, 190};
		for (int i : manager.getBattle().getMainPlayer().getInventory()) {
		JButton AttackDamagePotionImage = new JButton();
		AttackDamagePotionImage.setBounds(29, 29, 118, 120);
		frame.getContentPane().add(AttackDamagePotionImage);
		
		JLabel AttackDamagePotionLabel = new JLabel("<html>"
				+ "Attack Damage Potion:<br/><br/>"
				+ );
		lblNewLabel_2.setBounds(341, 29, 118, 120);
		frame.getContentPane().add(lblNewLabel_2);
		}
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(159, 29, 160, 120);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(471, 29, 160, 120);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(471, 194, 160, 120);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(341, 194, 118, 120);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(29, 194, 118, 120);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(159, 194, 160, 120);
		frame.getContentPane().add(lblNewLabel_1_2);
	}
}
