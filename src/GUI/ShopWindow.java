package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ShopAndItems.Item;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Main shop window in GUI
 * @author sammiller
 *
 */
public class ShopWindow {
	/**
	 * the frame on which the elements of the shop are placed
	 */
	private JFrame frame;
	/**
	 * The shop manager to control the shop-related windows (including this one)
	 */
	private ShopManager manager;

	/**
	 * Returns the JFrame on which the elements of the shop are placed
	 * @return the JFrame on which the elements of the shop are placed
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 * @param incomingManager the manager which will manage the shop
	 */
	public ShopWindow(ShopManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	/**
	 * Close the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
	/**
	 * Asks the manager to close the window, and thus any subsequent actions
	 *  can be carried out by the manager
	 */
	public void finishedWindow() {
		manager.closeShopWindow(this);
	}
	/**
	 * Displays the tutorial screen again
	 */
	public void replayTutorial() {
		manager.redisplayTutorial(this);
	}
	/**
	 * Gets the inventory of Items carried by the shop
	 * @return an ArrayList of Items carried by the shop
	 */
	public ArrayList<Item> getItems() {
		return manager.getShop().getItemList();
	}
	/**
	 * Opens a confirmation window to buy an item
	 * @param item the item the player is being asked to confirm buying
	 */
	public void openConfirmWindow(Item item) {
		manager.launchConfirmWindow(item);
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
		
		JButton backButton = new JButton("Back to main game");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(69, 662, 150, 97);
		frame.getContentPane().add(backButton);
		
		JButton btnReplayTutorial = new JButton("Replay tutorial");
		btnReplayTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replayTutorial();
			}
		});
		btnReplayTutorial.setBounds(1282, 662, 150, 97);
		frame.getContentPane().add(btnReplayTutorial);
		
		//Add the first potion
		JButton potion1Image = new JButton("");
		//Maybe make this a button not a label
		potion1Image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openConfirmWindow(getItems().get(0));
			}
		});
		potion1Image.setVerticalAlignment(SwingConstants.TOP);
		//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
		//Potion by James Smith from NounProject.com
		ImageIcon potionImageIcon = new ImageIcon(ShopWindow.class.getResource("/Desktop/SENG201/Images/noun-potion-1071046.png")); // load the image to a imageIcon
		Image potionImage = potionImageIcon.getImage(); // transform it 
		Image newimg = potionImage.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  (set size to be smaller than the JLabel for cropping
		potionImageIcon = new ImageIcon(newimg);  // transform it back
		potion1Image.setIcon(potionImageIcon);
		potion1Image.setBounds(69, 84, 150, 125);
		potion1Image.setToolTipText(getItems().get(0).getDescription());
		frame.getContentPane().add(potion1Image);
		
		//***CHANGE DESCRIPTIONS TO REMOVE UNECCESSARY STUFF***
		//abstract class
		
		JButton potion1Name = new JButton(getItems().get(0).getName());
		potion1Name.setBounds(215, 84, 256, 16);
		frame.getContentPane().add(potion1Name);
		
		JLabel potion1PriceLabel = new JLabel(String.format("Price: %d gold", getItems().get(0).getPrice()));
		potion1PriceLabel.setBounds(215, 128, 162, 16);
		frame.getContentPane().add(potion1PriceLabel);
		
		JLabel potion1StockLabel = new JLabel(String.format("Current stock: %d", 5));	//***GET CURRENT STOCK***
		potion1StockLabel.setBounds(215, 182, 150, 16);
		frame.getContentPane().add(potion1StockLabel);
		
		//Add the other potion
		JLabel potion2Image = new JLabel("");
		potion2Image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openConfirmWindow(getItems().get(1));
			}
		});
		potion2Image.setVerticalAlignment(SwingConstants.TOP);
		potion2Image.setIcon(potionImageIcon);
		potion2Image.setToolTipText(getItems().get(1).getDescription());
		potion2Image.setBounds(69, 437, 150, 125);
		frame.getContentPane().add(potion2Image);
		
		JLabel potion2Name = new JLabel(getItems().get(1).getName());
		potion2Name.setBounds(215, 437, 256, 16);
		frame.getContentPane().add(potion2Name);
		
		JLabel potion2PriceLabel = new JLabel(String.format("Price: %d gold", getItems().get(1).getPrice()));
		potion2PriceLabel.setBounds(215, 481, 162, 16);
		frame.getContentPane().add(potion2PriceLabel);
		
		JLabel potion2StockLabel = new JLabel(String.format("Current stock: %d", 3));
		potion2StockLabel.setBounds(215, 535, 150, 16);
		frame.getContentPane().add(potion2StockLabel);
		
		
	}
}
