package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

import ShopAndItems.Item;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseConfirmWindow {

	private JFrame frame;
	private ShopManager manager;
	private Item item;


	/**
	 * Create the application.
	 */
	public PurchaseConfirmWindow(ShopManager incomingManager, Item item) {
		manager = incomingManager;
		this.item = item;
		initialize();
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeConfirmWindow(this);
	}
	
	public void buyItem() {
		int index = manager.getShop().getItemList().indexOf(item);
		manager.getShop().buyItem(index);
		System.out.println("Bought "+item.getName());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 168);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
