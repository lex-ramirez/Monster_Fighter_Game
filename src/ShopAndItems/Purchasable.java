package ShopAndItems;

/**
 * 
 * @author Lex Ramirez
 * This is the 'Purchasable' interface that is inherited by both monsters
 * and items as they can both be bought within the game. It is up to the 
 * individual monsters and items to implement methods of purchasable
 *
 */
public interface Purchasable {
	
	public String getDescription();
	
	public int getPrice();
	
	public void setPrice(int price);
	
	public int getSellBackPrice();
	
	public void setSellBackPrice(int price, double percentage);
	
		
}
