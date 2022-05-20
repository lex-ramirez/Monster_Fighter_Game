package ShopAndItems;

import Monsters.Monster;

/**
* @author Lex Ramirez
* superPotion represents a 'Super Potion' item within the game, this inherits 
* the properties and methods of the superclass 'Item', and implements the 
* interface Purchasable. it sets the boost multiplier to 150 
* (implying it heals 150 health)
*/
//
public class SuperPotion extends Item {
	/**
	 * The index of this item's counter in the player's inventory
	 */
	int inventoryIndex = 3;
	/**
	 * gets the index of this item's counter in the player's inventory
	 * @return the index of this item's counter in the player's inventory
	 */
    public int getInventoryIndex() {
		return inventoryIndex;
	   }

   /**
    * Constructor method of a super potion
    */
   public SuperPotion() {
       super(15, "Super Potion", 250, 225);
   }

   /**
    * Returns the item description, name, boost, price and sell back price
    * @return
    * Formatted string
    */
   @Override
   public String getDescription() {
       return String.format("%s heals for %d health", 
               getName(), getItemBoost(), getPrice(), getSellBackPrice());
   }

@Override
public void useItemBoost(Monster targetMonster) {
	targetMonster.setCurrentHealth(targetMonster.getCurrentHealth()+getItemBoost());
}

@Override
public String getDrawingId() {
	return "super-potion-drawing.png";
}
}