package GUI;

import GameEnvironmentElements.PlayerDirectory;
import ShopAndItems.*;

public class ShopManager {
//Could potentially put this in the mainGame class
	private boolean tutorialShown = false;
	private Shop shop;
	
	
	
	public boolean isTutorialShown() {
		return tutorialShown;
	}

	public void setTutorialShown(boolean tutorialShown) {
		this.tutorialShown = tutorialShown;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ShopManager(Shop shop) {
		this.shop = shop;
	}

	public void launchTutorialScreen() {
		tutorialShown = true;
		ShopTutorialWindow tutorialWindow = new ShopTutorialWindow(this);
	}
	
	public void goBackTutorialWindow(ShopTutorialWindow window) {
		window.closeWindow();
		System.out.println("Launching mainGame window");
	}
	
	public void continueTutorialWindow(ShopTutorialWindow window) {
		window.closeWindow();
		launchShopWindow();
	}
	
	public void launchShopWindow() {
		ShopWindow shopWindow = new ShopWindow(this);
	}
	
	public void closeShopWindow(ShopWindow window) {
		window.closeWindow();
		System.out.println("Launching mainGame window");
	}
	
	public void redisplayTutorial(ShopWindow window) {
		window.closeWindow();
		launchTutorialScreen();
	}
	
	public void launchConfirmWindow(Item item) {
		PurchaseConfirmWindow confirmWindow = new PurchaseConfirmWindow(this, item);
	}
	//Keep getting errors
	//Exception in thread "AWT-EventQueue-0" java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
	
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
