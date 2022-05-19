package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

import ShopAndItems.Item;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * A window to ask the player to confirm a purchase from the shop
 * @author sammiller
 *
 */
public class PurchaseConfirmWindow {
	/**
	 * the JDialog frame on which the elements of the shop are placed
	 */
	private JDialog frame;
	/**
	 * The shop manager to control the shop-related windows (including this one)
	 */
	private ShopManager manager;
	/**
	 * the item the player is being asked to confirm buying
	 */
	private Item item;


	/**
	 * Create the application.
	 * @param incomingManager the manager which will manage the shop
	 * @param the item the player is being asked to confirm buying
	 */
	public PurchaseConfirmWindow(ShopManager incomingManager, Item item) {
		manager = incomingManager;
		this.item = item;
		initialize();
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
	/**
	 * Closes the window
	 */
	public void closeWindow() {
		frame.dispose();
	}
	/**
	 * Asks the manager to close the window, and thus any subsequent actions
	 *  can be carried out by the manager
	 */
	public void finishedWindow() {
		manager.closeConfirmWindow(this);
	}
	/**
	 * Buys the item from the shop
	 */
	public void buyItem() {
		int index = manager.getShop().getItemList().indexOf(item);
		manager.getShop().buyItem(index);
		System.out.println("Bought "+item.getName());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//https://coderanch.com/t/664207/java/Multiple-Windows
		//https://www.geeksforgeeks.org/java-swing-jdialog-examples/#:~:text=JDialog%20is%20a%20part%20Java,title%20or%20any%20specified%20owner
		frame = new JDialog();	// Can click on window behind it???
		frame.setBounds(100, 100, 445, 168);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel confirmText = new JLabel(String.format("Are you sure you want to purchase %s for %d gold?", item.getName(), item.getPrice()));
		confirmText.setHorizontalAlignment(SwingConstants.CENTER);
		confirmText.setBounds(6, 25, 433, 16);
		frame.getContentPane().add(confirmText);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		cancelButton.setBounds(20, 89, 117, 29);
		frame.getContentPane().add(cancelButton);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem();
				finishedWindow();
			}
		});
		confirmButton.setBounds(307, 89, 117, 29);
		frame.getContentPane().add(confirmButton);
	}
}
