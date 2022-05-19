package Monsters;

/**
 * Healer sub-class of Monster Is a monster with a special ability to
 * 
 * @author sammiller
 *
 */
public class Healer extends Monster {

	/**
	 * the amount the healer can increase a teammate's health by
	 */
	private int healAmount;

	/**
	 * Instantiates an instance of the Healer class
	 * 
	 * @param name            the name of the healer
	 * @param maxHealth       the health cap of the healer
	 * @param attackDamage    the damage per attack done by the healer using its
	 *                        regular/base attack
	 * @param rarity          the rarity of the healer //Are we using this and do we
	 *                        need a better description? Should each sub-class have
	 *                        a default rarity?
	 * @param price           the value of the healer if it were to be bought from
	 *                        the shop
	 * @param level           the level of the healer
	 * @param xp              the xp of the healer (how far towards leveling up it
	 *                        is)
	 * @param levelUpXpAmount the amount of xp at which the healer will level up
	 * @param healAmount      the amount of health the healer can restore to a
	 *                        teammate
	 * 
	 */
	public Healer(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
			int levelUpXpAmount, int healAmount) {

		super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount, true, 1, false, "healer-monster-drawing.png");
		this.healAmount = healAmount;
	}

	/**
	 * Instantiates an instance of Healer using the Monster super() constructor
	 * parameters only
	 * 
	 * @param name            the name of the healer
	 * @param maxHealth       the health cap of the healer
	 * @param attackDamage    the damage per attack done by the healer using its
	 *                        regular/base attack
	 * @param rarity          the rarity of the healer //Are we using this and do we
	 *                        need a better description?
	 * @param price           the value of the healer if it were to be bought from
	 *                        the shop
	 * @param level           the level of the healer
	 * @param xp              the xp of the healer (how far towards leveling up it
	 *                        is)
	 * @param levelUpXpAmount the amount of xp at which the healer will level up
	 * 
	 */
	/*
	 * I only wrote this because i got an error message public Healer(String name,
	 * int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
	 * int levelUpXpAmount) { super(name, maxHealth, attackDamage, rarity, price,
	 * level, xp, levelUpXpAmount); healAmount = 0; }
	 */

	/**
	 * Yields the amount by which the healer can increase a teammate's health
	 * 
	 * @return the amount by which a healer can increase a teammate's health
	 * 
	 */
	public int getHealAmount() {
		return healAmount;
	}

	/**
	 * sets the healAmount to a desired new value
	 * 
	 * @param amount the desired amount by which the healer can increase a
	 *               teammate's health
	 * 
	 */
	public void setHealAmount(int amount) {
		healAmount = amount;
	}

	/**
	 * Heals a teammate if the teammate is not already at full health. Does not heal
	 * a teammate to more than the teammate's max health
	 * 
	 * @param target the monster the healer is trying to heal
	 * @throws IllegalStateException if the monster the healer is trying to heal is
	 *                               already at full health
	 * @throws IllegalStateException if the monster the healer is attempting to heal
	 *                               has fainted
	 * 
	 */
	@Override
	public void useSpecialAbility(Monster target) {
		setSpecialTarget(target);
		if (target.hasFainted())
			throw new IllegalStateException("This Monster has fainted, and thus can't be healed");
		else if (target.getCurrentHealth() == target.getMaxHealth())
			throw new IllegalStateException("This monster is already at full health!");
		else {
			target.setCurrentHealth(Math.min(target.getCurrentHealth() + healAmount, target.getMaxHealth()));
		}
	}

	/**
	 * yeilds a description of a Healer's special ability
	 * 
	 * @return a description of the special ability
	 */
	@Override
	public String getSpecialAbilityDescription() {
		return "The healer can restore a teammate's health by " + healAmount + "hp";
	}

	/**
	 * Yields a generic description of the healer
	 * 
	 * @return a generic description of a healer
	 */
	@Override
	public String getDescription() {
		return "The healer can use ancient magic to restore the health of a teammate";
	}

	/**
	 * Increases one of the healer's stats (chosen from attackDamage, maxHealth, or
	 * healAmount) based on the level (the stat chosen to be increased is on a cycle
	 * so it changes each time the healer levels up)
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
			setHealAmount((int) Math.round(getHealAmount() * 1.2));
			break;
		}
	}

	/**
	 * returns a string representation of the healer
	 * 
	 * @return a String representation of the Healer
	 */
	@Override
	public String toString() {
		return String.format(
				"Healer %s: maxHealth=%d, attackDamage=%d, currentHealth=%d, "
						+ "rarity=%s, price=%d, level=%d, xp=%d, levelUpXpAmount=%d, fainted=%s, healAmount=%d",
				getName(), getMaxHealth(), getAttackDamage(), getCurrentHealth(), getRarity(), getPrice(), getLevel(),
				getXp(), getLevelUpXpAmount(), hasFainted(), getHealAmount());
	}

	@Override
	public void undoSpecial(Monster target) {
		return;
		
	}
}