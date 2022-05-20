package GUI;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import GameEnvironmentElements.PlayerDirectory;
import Monsters.Monster;
import ShopAndItems.Item;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleInventory {

	private JFrame frame;
	private BattleManager manager;
	private int[] inventory;
	private int playerTurn;
	private ArrayList<Item> itemDirectory = new PlayerDirectory().addToList();
	private JLabel[] itemCounters = {new JLabel(""), new JLabel(""), new JLabel(""), new JLabel("")};
	private JLabel noMorePotionsLabel = new JLabel("You can't use any more of this potion, you've got none left!!");
	

	/**
	 * Create the application.
	 */
	public BattleInventory(BattleManager manager, int playerTurn) {
		this.manager = manager;
		this.inventory = manager.getBattle().getMainPlayer().getInventory();
		this.playerTurn = playerTurn;
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
	
	public void placeItem(Item item, int pos_x, int pos_y) {
		JLabel itemImage = new JLabel("");
		itemImage.setIcon(new ImageIcon(BattleWindow.class.getResource("/Desktop/SENG201/Images/"
				+ item.getDrawingId())));	//Maybe should have the whole filepath in the monster class
				//+ item.getDrawingId())));;
		JLabel itemLabel = new JLabel("<html>" + item.getName() 
			+ "<br/>"
			+ "<br/>Special Ability: " + item.getDescription() 
			+ "</html>"); 	
		
		JButton border = new JButton("");
		border.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		border.setBounds(pos_x-5, pos_y-5, 300, 160);
		border.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				border.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			public void mouseReleased(MouseEvent e) {
				border.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				if (inventory[itemDirectory.indexOf(item)] > 0) {
					noMorePotionsLabel.setVisible(false);
					item.useItemBoost(manager.getBattle().getMainPlayer().getTeam().get(playerTurn));
					inventory[itemDirectory.indexOf(item)] -= 1;
					itemCounters[itemDirectory.indexOf(item)].setText("x"+Integer.toString(inventory[item.getInventoryIndex()]));	
				}
				else
					noMorePotionsLabel.setVisible(true);
			}
		});
		frame.getContentPane().add(border);
		
		
		
		// Make a count of how many are in the inventory
		itemCounters[itemDirectory.indexOf(item)].setText("x"+Integer.toString(inventory[item.getInventoryIndex()]));
		itemCounters[itemDirectory.indexOf(item)].setBounds(pos_x + 135, pos_y+125, 61, 16);
		frame.getContentPane().add(itemCounters[itemDirectory.indexOf(item)]);
		
		//monsterImage.setContentAreaFilled(false);
		//itemImage.setOpaque(false);
		//itemImage.setBorder(null);
		itemImage.setBounds(pos_x, pos_y, 120, 120);
		frame.getContentPane().add(itemImage);
		
		itemLabel.setBounds(pos_x+130, pos_y, 150, 180);
		itemLabel.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(itemLabel);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		noMorePotionsLabel.setBounds(227, 356, 388, 59);
		frame.getContentPane().add(noMorePotionsLabel);
		noMorePotionsLabel.setVisible(false);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(53, 386, 117, 29);
		frame.getContentPane().add(backButton);
		
		
		int[] itemCoords = {30, 30, 350, 30, 30, 190, 350, 190};
		for (int index=0;index < inventory.length; index++) {
			placeItem(itemDirectory.get(index), itemCoords[2*index], itemCoords[2*index+1]);
		}
		
	}
}
