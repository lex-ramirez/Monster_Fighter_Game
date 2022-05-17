package Monsters;

/**
 * PoisonMaster is a type of Monster that does a small amount of damage to an 
 * oppostion Monster during a battle for a certain number of turns
 * 
 * @author sammiller
 *
 */
public class PoisonMaster extends Monster {

	/**
	 * the amount of damage the poison master deals to an opposition 
	 * monster per turn
	 */
	private int poisonDamage;
	
	/**
	 * Makes a PoisonMaster object
	 * 
	 * @param name					the name of the poison master
	 * @param maxHealth				the health cap of the poison master
	 * @param attackDamage			the base attack damage of the poison master
	 * @param rarity				the rarity of the poison master
	 * @param price					the value/price of the poison master
	 * @param level					the current level of the poison master
	 * @param xp					the current xp level of the poison master
	 * @param levelUpXpAmount		the amount of xp required for the poison master to level up
	 * @param poisonDamage			the amount of damage dealt by the poison to an opposition monster per turn
	 * @param poisonDuration		the number of turns for which the poison master deals damage to an opposition monster
	 */
	public PoisonMaster(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
			int levelUpXpAmount, int poisonDamage, int poisonDuration) {
		super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount, false, poisonDuration, false, "poison-master-monster-drawing.png");
		this.poisonDamage = poisonDamage;
	}

	/**
	 * Yields the amount of poison damage that the poison master deals per turn 
	 * 
	 * @return	the amount of damage dealt per turn by the poison master
	 */
	public int getPoisonDamage() {
		return poisonDamage;
	}
	
	/**
	 * Sets the poisonDamage of the poison master to some new value
	 * 
	 * @param damage	the desired new value of poisonDamage
	 */
	public void setPoisonDamage(int damage) {
		poisonDamage = damage;
	}
	
	/**
	 * Increases one of the poison master's stats (chosen from maxHealth, attackDamage,
	 * poisonDamage, poisonDuration) based on the level (the stat chosen to be increased is on a cycle
	 * so it changes each time the poison master levels up)
	 */
	@Override
	public void increaseStat() {
		switch (getLevel() % 4) {
		case 0:
			setMaxHealth((int) Math.round(getMaxHealth() * 1.2));
			break;
		case 1:
			setAttackDamage((int) Math.round(getAttackDamage() * 1.2));
			break;
		case 2:
			setPoisonDamage((int) Math.round(getPoisonDamage() * 1.2));
			break;
		case 3: 
			setSpecialDuration((int) getSpecialDuration() + 1);
			break;
		}
	}

	/**
	 * Deals poison attack damage to an opposition monster 
	 * Is done over a loop for the number of iterations of poisonDuration
	 */
	@Override
	public void useSpecialAbility(Monster target) {
		setSpecialTarget(target);
		if (target.hasFainted())
			throw new IllegalStateException("This monster has already fainted: no more damage can be dealt to it");
		else
			target.setCurrentHealth(Math.max(target.getCurrentHealth() - getPoisonDamage(), 0));
	}

	/**
	 * Yields a generic description of an poison master
	 * 
	 * @return a description of an poison master
	 */
	@Override
	public String getSpecialAbilityDescription() {
		return String.format("Deals %d damage to an opposition monster for %d turns", poisonDamage, getSpecialDuration());
	}
	
	/**
	 * Yields a generic description of an poison master
	 * 
	 * @return a description of an poison master
	 */
	@Override
	public String getDescription() {
		return "The poison master uses their array of poisons to, once per battle, deal "
				+ "damage to an opposition monster for a set number of turns";
	}

	@Override
	public void undoSpecial(Monster target) {
		//Does nothing, as this monster does not apply a temporary boost
	}

}