package Monsters;

/*
 * The Tortoise subclass of Monster has a special ability
 * 
 * @author sammiller
 *
 */
public class Tortoise extends Monster {

    /*
     * instantiates a tortoise
     * 
     * @param name
     * @param maxHealth
     * @param attackDamage
     * @param rarity
     * @param price
     * @param level
     * @param xp
     * @param levelUpXpAmount
     */
    public Tortoise(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
            int levelUpXpAmount) {
        super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void increaseStat() {
        // TODO Auto-generated method stub

    }

    @Override
    public void useSpecialAbility(Monster target) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getSpecialAbilityDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDescription() {
        return "hey";
    }

}