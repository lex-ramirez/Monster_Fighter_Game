package ShopAndItems;

/**
* @author Lex Ramirez
* smallPotion subclass represents a 'Small Potion' item within the game,
* this inherits the properties and methods of the superclass 'Item' and implements
* the interface Purchasable. It sets the boost multiplier to 50 
* (implying it heals 50 health)
*/
//
public class SmallPotion extends Item {
	/**
	 * The index of this item's counter in the player's inventory
	 */
	int inventoryIndex = 2;
	/**
	 * gets the index of this item's counter in the player's inventory
	 * @return the index of this item's counter in the player's inventory
	 */
    public int getInventoryIndex() {
		return inventoryIndex;
	   }

   /**
    * Constructor method of a small potion
    */
   public SmallPotion() {
       super(50, "Small Potion", 100, 90);
   }

   /**
    * Returns the item description, name, boost, price and sell back price
    * @return
    * Formatted string
    */
   @Override
   public String getDescription() {
       return String.format("%s heals for %d health\nPrice: %d gold\nSell back price: %d gold", 
               getName(), useItemBoost(), getPrice(), getSellBackPrice());
   }
}