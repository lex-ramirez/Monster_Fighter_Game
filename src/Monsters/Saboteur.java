package Monsters;

/**
 * Saboteur is a type of monster with the special ability to weaken an
 * opposition monster's attack once per battle
 * 
 * @author sammiller
 *
 */
public class Saboteur extends Monster {

	/**
	 * The amount by which the saboteur weakens the targeted monster's attack
	 */
	private int weakenAmount;

	/**
	 * 
	 * Constructor to instantiate a Saboteur
	 * 
	 * @param name            the name of the saboteur
	 * @param maxHealth       the health cap of the Saboteur
	 * @param attackDamage    the base attack damage per attack of the saboteur
	 * @param rarity          the rarity of the saboteur
	 * @param price           the price/value of the saboteur
	 * @param level           the current level of the saboteur
	 * @param xp              the current xp of the saboteur
	 * @param levelUpXpAmount the amount of xp required for the saboteur to level up
	 * @param weakenAmount    how much the saboteur weakens an opposition's base
	 *                        attack by
	 * 
	 */
	public Saboteur(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
			int levelUpXpAmount, int weakenAmount) {
		super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount, false, 1, true, "saboteur-monster-drawing.png");
		this.weakenAmount = weakenAmount;
	}

	/**
	 * Yields the amount by which the saboteur reduces the damage done by an
	 * opposition monster's base attack
	 * 
	 * @return the amount by which the saboteur weakens opposition attacks
	 */
	public int getWeakenAmount() {
		return weakenAmount;
	}

	/**
	 * Sets the weakenAmount to a desired new value
	 * 
	 * @param amount the desired new value of weakenAmount
	 */
	public void setWeakenAmount(int amount) {
		this.weakenAmount = amount;
	}

	/**
	 * Increases one of the Saboteur's stats (chosen from attackDamage, maxHealth,
	 * or damageBoost) based on the level (the stat chosen to be increased is on a
	 * cycle so it changes each time the Saboteur levels up)
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
			setWeakenAmount((int) Math.round(getWeakenAmount() * 1.2));
			break;
		}
	}

	/**
	 * Weakens the base attack damage of one of the opposition monsters for one turn
	 * 
	 * @param target the opposition monster to whom the effect is being applied
	 * 
	 */
	@Override
	public void useSpecialAbility(Monster target) {
		setSpecialTarget(target);
		target.setAttackDamage(target.getAttackDamage() - weakenAmount);

	}

	/**
	 * Takes back the effect applied in a previous turn so that it only lasts one
	 * turn
	 * 
	 * @param target the enemy monster whose attack damage is being restored
	 * 
	 */
	public void undoSpecial(Monster target) {
		target.setAttackDamage(target.getAttackDamage() + weakenAmount);
	}

	/**
	 * Yeilds a decription of the Saboteur's special ability
	 * 
	 * @return a description of the special ability
	 */
	@Override
	public String getSpecialAbilityDescription() {
		return String.format("The Saboteur applies a weakening effect of %d hit points to %s's base attack",
				getWeakenAmount(), getSpecialTarget().getName());
	}

	/**
	 * yeilds a decription of the saboteur
	 * 
	 * @return a description of the saboteur
	 */
	@Override
	public String getDescription() {
		return "The Sabateur can weaken an opposition's base attack once per battle";
	}

}