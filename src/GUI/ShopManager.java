package GUI;

import javax.swing.JFrame;

import GameEnvironmentElements.PlayerDirectory;
import ShopAndItems.*;
/**
 * A class to manage the shop-related GUI elements
 * @author sammiller
 *
 */
public class ShopManager {
//Could potentially put this in the mainGame class
	/**
	 * Records whether the tutorial has been shown before. 
	 * (if the player has been to the shop before, the tutorial window
	 * won't be shown
	 */
	private boolean tutorialShown = false;
	/**
	 * The Shop this class will be managing through the GUI
	 */
	private Shop shop;
	/**
	 * The main shop-window this class will manage
	 */
	private ShopWindow shopWindow;
	
	/**
	 * returns the main shop-window this class will manage
	 * @return the main shop-window this class will manage
	 */
	public ShopWindow getShopWindow() {
		return shopWindow;
	}
	/**
	 * returns whether the tutorial screen has been shown to the player before
	 * @return <code>true</code> if the tutorial screen has been shown before, 
	 * and <code>false</code> otherwise
	 */
	public boolean isTutorialShown() {
		return tutorialShown;
	}
	/**
	 * Sets whether the tutorial screen has been shown before
	 * @param tutorialShown the new value of tutorialShown
	 */
	public void setTutorialShown(boolean tutorialShown) {
		this.tutorialShown = tutorialShown;
	}
	/**
	 * Returns the shop this class is managing
	 * @return the shop this class is managing
	 */
	public Shop getShop() {
		return shop;
	}
	/**
	 * Creates an instance of a shopManager 
	 * @param shop the shop this class will manage
	 */
	public ShopManager(Shop shop) {
		this.shop = shop;
	}
	/**
	 * Launches the tutorial screen instead of the Main Shop screen if it has not been shown yet
	 */
	public void launchTutorialScreen() {
		tutorialShown = true;
		ShopTutorialWindow tutorialWindow = new ShopTutorialWindow(this);
	}
	/**
	 * Returns to the main game window from the tutorial window
	 * @param window the tutorial window from which the user is returning
	 */
	public void goBackTutorialWindow(ShopTutorialWindow window) {
		window.closeWindow();
		System.out.println("Launching mainGame window");
	}
	/**
	 * Progresses from the tutorial window to the main shop window
	 * @param window the window from which the user is progressing
	 */
	public void continueTutorialWindow(ShopTutorialWindow window) {
		window.closeWindow();
		shopWindow = launchShopWindow();
	}
	/**
	 * Launches a shopWindow
	 * @return the shopWindow which was launched
	 */
	public ShopWindow launchShopWindow() {
		ShopWindow shopWindow = new ShopWindow(this);
		return shopWindow;
	}
	/**
	 * Closes the shopWindow and returns to the main game window
	 * @param window the shop window being closed
	 */
	public void closeShopWindow(ShopWindow window) {
		window.closeWindow();
		System.out.println("Launching mainGame window");
	}
	/**
	 * Closes the shop window and relaunches the tutorial window
	 * @param window the shopWindow being closed
	 */
	public void redisplayTutorial(ShopWindow window) {
		window.closeWindow();
		launchTutorialScreen();
	}
	/**
	 * Launches a window asking the user to confirm a purchase
	 * @param item the item to be purchased
	 */
	public void launchConfirmWindow(Item item) {
		PurchaseConfirmWindow confirmWindow = new PurchaseConfirmWindow(this, item);
	}
	//Keep getting errors
	//Exception in thread "AWT-EventQueue-0" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
	/**
	 * Closes the confirmation window
	 * @param window the confirmation window to be closed
	 */
	public void closeConfirmWindow(PurchaseConfirmWindow window) {
		window.closeWindow();
	}
	
	public static void main(String[] args) {
		PlayerDirectory dir = new PlayerDirectory();
		Shop shop = new Shop(dir.getAllMonsters(), dir.addToList());
		System.out.println(shop);
		ShopManager shopManager = new ShopManager(shop);
		if (!shopManager.tutorialShown)
			shopManager.launchTutorialScreen();
		else
			shopManager.launchShopWindow();
	}
}
