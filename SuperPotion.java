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
    * Constructor method of a super potion
    */
   public SuperPotion() {
       super(150, "Super Potion", 250, 225);
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