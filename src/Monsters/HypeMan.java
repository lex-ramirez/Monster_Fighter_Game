package Monsters;

/**
 * HypeMan, a subclass of monster is a monster with a special ability of
 * boosting his teammate's attacks
 * 
 * @author sammiller
 *
 */
public class HypeMan extends Monster {
	//Change name to hypeBeast

	/**
	 * The amount of extra damage per base attack the HypeMan gives to each of his
	 * teammates
	 * 
	 * ***FOR THE REST OF THE TURN***
	 */
	private int damageBoost;

	/**
	 * Constructor to initialise a HypeMan object
	 * 
	 * @param name            the name of the HypeMan
	 * @param maxHealth       the maximum health of the HypeMan
	 * @param attackDamage    the base damage done per attack by the HypeMan
	 * @param rarity          the rarity of the HypeMan
	 * @param price           the value/price of the HypeMan
	 * @param level           the current level of the HypeMan
	 * @param xp              the current amount of xp the HypeMan has
	 * @param levelUpXpAmount the amount of xp the HypeMan needs to level up
	 * @param damageBoost     the amount of extra damage per attack the HypeMan
	 *                        gives to each of his teammates
	 */
	public HypeMan(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
			int levelUpXpAmount, int damageBoost) {
		super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount, true, 1, true, "hypeman-drawing.png");
		this.damageBoost = damageBoost;
	}

	/**
	 * Yields the damageBoost of the HypeMan
	 * 
	 * @return the amount of extra damage per attack the HypeMan gives to each of
	 *         his teammates
	 * 
	 */
	public int getDamageBoost() {
		return damageBoost;
	}

	/**
	 * Sets a new damageBoost for the HypeMan
	 * 
	 * @param boost the desired new value for the amount of extra damage the HypeMan
	 *              gives his teammates
	 * 
	 */
	public void setDamageBoost(int boost) {
		damageBoost = boost;
	}

	/**
	 * Increases one of the HypeMan's stats (chosen from attackDamage, maxHealth, or
	 * damageBoost) based on the level (the stat chosen to be increased is on a
	 * cycle so it changes each time the HypeMan levels up)
	 */
	@Override
	public void increaseStat() {
		switch (getLevel() % 3) {
		case 0:
			setMaxHealth((int) Math.round(getMaxHealth() * 1.2));
			break;
		case 1:
			setAttackDamage((int) Math.round(getAttackDamage() * 1.2));
			break;
		case 2:
			setDamageBoost((int) Math.round(getDamageBoost() * 1.2));
			break;
		}
	}

	/**
	 * Boosts one of the HypeMan's teammate's base attacks for one turn Is executed
	 * in a loop so as to affect all teammates
	 * 
	 * @param target the teammate to whom the boost is being applied
	 * 
	 */
	@Override
	public void useSpecialAbility(Monster target) {
		setSpecialTarget(target);
		target.setAttackDamage(target.getAttackDamage() + damageBoost);

	}

	/**
	 * Takes back the boost applied in a previous turn so that the boost only lasts
	 * one turn
	 * 
	 * @param target the teammate whose attack boost is being removed
	 * 
	 */
	public void undoSpecial(Monster target) {
		target.setAttackDamage(target.getAttackDamage() - damageBoost);
	}

	/**
	 * Yields a description of a HypeMan's special ability
	 * 
	 * @return a description of the special ability
	 */
	@Override
	public String getSpecialAbilityDescription() {
		return "Boosts all team members' base attacks by " + damageBoost + " damage points for the "
				+ "remainder of one turn";
	}

	/**
	 * Yields a generic description of the HypeMan
	 * 
	 * @return a generic description of a HypeMan
	 */
	@Override
	public String getDescription() {
		return "The hype-man can boost all of his team members' attack damge for one turn per battle"
				+ "You might want to use him in the first slot in your team, as he only boosts the teammates who"
				+"have not yet used their attacks";
	}

	/**
	 * returns a string representation of the HypeMan
	 * 
	 * @return a String representation of the HypeMan
	 */
	@Override
	public String toString() {
		return String.format(
				"HypeMan %s: maxHealth=%d, attackDamage=%d, currentHealth=%d, "
						+ "rarity=%s, price=%d, level=%d, xp=%d, levelUpXpAmount=%d, fainted=%s, damageBoost=%d",
				getName(), getMaxHealth(), getAttackDamage(), getCurrentHealth(), getRarity(), getPrice(), getLevel(),
				getXp(), getLevelUpXpAmount(), hasFainted(), getDamageBoost());
	}	
}