package ShopAndItems;

/**
 * @author Lex Ramirez 
 * attackEnhancer represents an 'Attack Enhancer' item within the game
 * this inherits the properties and methods of the superclass 'Item' and implements
 * the interface Purchasable. It sets the boost multiplier to 50 
 * (implying it increases attack by 50)
 */
//
public class AttackEnhancer extends Item {
	/**
	 * The index of this item's counter in the player's inventory
	 */
	int inventoryIndex = 1;
	/**
	 * gets the index of this item's counter in the player's inventory
	 * @return the index of this item's counter in the player's inventory
	 */
    public int getInventoryIndex() {
		return inventoryIndex;
	   }

    /**
     * Constructor method for attackEnhancer
     */
    public AttackEnhancer() {
        super(5, "Attack Damage Enhancer", 140, 126);
    }

    /**
     * Returns the item description: name, boost, price and sell back price
     * @return
     * Formatted string
     */
    @Override
    public String getDescription() {
        return String.format("%s increases attack damage by %d\nPrice: %d gold\nSell back price: %d gold", 
                getName(), useItemBoost(), getPrice(), getSellBackPrice());
    }
}