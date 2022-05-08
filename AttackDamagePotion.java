/**
* @author Lex Ramirez
* attackDamagePotion represents an 'Attack Damage Potion' item within the game
* this inherits the properties and methods of the superclass 'Item' and implements
* the interface Purchasable. It sets the boost multiplier to 20. 
* (implying it increases attack by 20)
*/
//
public class AttackDamagePotion extends Item {

   /**
    * Constructor method for attackDamagePotion 
    */
   public AttackDamagePotion() {
       super(20, "Attack Damage Potion", 70, 63);
   }

   /**
    * Returns the item description, name, boost, price and sell back price
    * @return
    * Formatted string
    */
   @Override
   public String getDescription() {
       return String.format("%s increases attack damage by %d\nPrice: %d gold\nSell back price: %d gold", 
               getName(), useItemBoost(), getPrice(), getSellBackPrice());
   }

}