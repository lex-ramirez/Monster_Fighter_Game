package Monsters;

/*
 * The Tortoise subclass of Monster has a special ability to shield a teammate (or itself)
 * from all damage for the remainder of one turn per battle
 * 
 * @author sammiller
 *
 */
public class Tortoise extends Monster {

	private int previousHealth;
    /**
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
        super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount, true, 1, false, "tortoise-drawing.png");
        previousHealth = maxHealth;
    }

    @Override
    public void increaseStat() {
    	switch (getLevel() % 2) {
		case 0:
			setMaxHealth((int) Math.round(getMaxHealth() * 1.2));
			break;
		case 1:
			setAttackDamage((int) Math.round(getAttackDamage() * 1.2));
			break;
		}

    }

    @Override
    public void useSpecialAbility(Monster target) {
		setSpecialTarget(target);
        previousHealth = target.getCurrentHealth();
        target.setCurrentHealth(1000000000);

    }

    @Override
    public String getSpecialAbilityDescription() {
        return "The Tortoise has a special ability to shield a teammate from "
        		+ "all damage for the remainder of one turn, once per battle";
    }

    @Override
    public String getDescription() {
        return "The Tortoise subclass of Monster has a special ability to shield a teammate (or itself)"	//Doesn't have to be early on the roster, as the AI
        		+ " from all damage for the remainder of one turn per battle.";								//AI always attacks after the special is applied
    }

	@Override
	public void undoSpecial(Monster target) {
		target.setCurrentHealth(previousHealth);
		
	}

}