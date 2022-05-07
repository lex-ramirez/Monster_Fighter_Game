/**
 * @author Lex Ramirez
 * 
 * Parent class 'Item' is a superclass which the subclasses of
 * all the different in game items inherit. 
 *
 */
public class Item implements Purchasable {
	
	/**
	 * @Variables
	 * itemBoost - an integer value showing how much the item boosts a monster 
	 * statistic. This is simply a multiplier
	 */
	private int itemBoost;
	private String itemName;
	private int itemPrice;
	private int sellBackPrice;
	
	/**
	 * Constructor method that sets the boost multiplier of the item
	 * @param 
	 * boost (integer) - boost multiplier of item
	 */
	public Item(int boost, String name, int price, int sellPrice) {
		// TODO Auto-generated constructor stub
		itemBoost = boost;
		itemName = name;
		itemPrice = price;
		sellBackPrice = sellPrice;
	}

	/**
	 * Method which returns the boost multiplier, useful for when the item is 
	 * used in game as the value can simply be returned and added to a 
	 * monster statistic
	 * @return itemBoost (integer)
	 */
	public int useItemBoost() {
		return itemBoost;
	}
	
	/**
	 * Method which returns the name of the item
	 * @return
	 * itemName - the name of the item
	 */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Returns the price of the item (integer)
	 * @return 
	 * itemPrice - price of the item
	 */
	@Override
	public int getPrice() {
		return itemPrice;
	}
	
	/**
	 * Sets the price of the item, useful for changing prices for higher
	 * difficulties, later levels etc...
	 * @param
	 * price (integer) - price of the item
	 */
	@Override
	public void setPrice(int price) {
		itemPrice = price;
	}
	
	/**
	 * Returns the sell back price of the item (integer)
	 * @return
	 * sellBackPrice - sell back price of the item
	 */
	@Override
	public int getSellBackPrice() {
		return sellBackPrice;
	}
	
	/**
	 * Sets the sell back price of the item, useful once again for changing
	 * the sell back price for higher difficulties, etc...
	 * @param 
	 * price (integer) - price of the item 
	 * percentage (double) - factor of the sell back price (e.g. 0.9)
	 */
	@Override
	public void setSellBackPrice(int price, double percentage) {
		sellBackPrice = (int)(price * percentage);
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}