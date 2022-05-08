/**
 * Archer sub class of Monster: Special attack is a multi attack which deals
 * damage to all members of an opposition team
 * 
 * @author sammiller
 *
 */

//Test edit to trial git

public class Archer extends Monster {

	/**
	 * The amount of damage the special attack does to the target monster
	 */
	private int volleyDamage;

	/**
	 * Instantiates an instance of the archer class
	 * 
	 * @param name           the name of the archer
	 * @param maxHealth      the health cap of the archer
	 * @param attackDamage   the damage per attack done by the archer using its
	 *                       regular/base attack
	 * @param rarity         the rarity of the archer //Are we using this and do we
	 *                       need a better description? Should each sub-class have a
	 *                       default rarity?
	 * @param price          the value of the archer if it were to be bought from
	 *                       the shop
	 * @param level          the level of the archer
	 * @param xp             the xp of the archer (how far towards leveling up it
	 *                       is)
	 * @param levelUpXpCount the amount of xp at which the archer will level up
	 * @param volleyDamage   the amount of damage the special attack does to each
	 *                       target monster
	 * 
	 */
	public Archer(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
			int levelUpXpAmount, int volleyDamage) {

		super(name, maxHealth, attackDamage, rarity, price, level, xp, levelUpXpAmount);
		this.volleyDamage = volleyDamage;
	}

	/**
	 * Instantiates an instance of archer using the Monster super() constructor
	 * parameters only
	 * 
	 * @param name            the name of the archer
	 * @param maxHealth       the health cap of the archer
	 * @param attackDamage    the damage per attack done by the archer using its
	 *                        regular/base attack
	 * @param rarity          the rarity of the archer //Are we using this and do we
	 *                        need a better description?
	 * @param price           the value of the archer if it were to be bought from
	 *                        the shop
	 * @param level           the level of the archer
	 * @param xp              the xp of the archer (how far towards leveling up it
	 *                        is)
	 * @param levelUpXpAmount the amount of xp at which the archer will level up
	 */
	/*
	 * I only wrote this because i got an error message public Archer(String name,
	 * int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
	 * int levelUpXpAmount) { super(name, maxHealth, attackDamage, rarity, price,
	 * level, xp, levelUpXpAmount); volleyDamage = 0; }
	 */

	/**
	 * Yields the value of the volley attack on each target
	 * 
	 * @return the value of volleyAttack (how much damage the special attack does on
	 *         each target)
	 */
	public int getVolleyDamage() {
		return volleyDamage;
	}

	/**
	 * Sets the value of volleyDamage
	 * 
	 * @param damage the amount of damage the special attack does to each target
	 */
	public void setVolleyDamage(int damage) {
		volleyDamage = damage;
	}

	/**
	 * Launches the volleyAttack on a target, depleting its health by the specified
	 * amount (volleyDamage)
	 * 
	 * @param target the monster being attacked by the arrow volley special attack
	 * 
	 * @throws IllegalStateException if the target monster has already fainted
	 * 
	 */
	@Override
	public void useSpecialAbility(Monster target) {
		if (target.hasFainted())
			throw new IllegalStateException("This monster has already fainted: no more damage can be dealt to it");
		else
			target.setCurrentHealth(Math.max(target.getCurrentHealth() - volleyDamage, 0));
	}

	/**
	 * Yields a description of the Archer's special ability
	 * 
	 * @return a description of the Arrow Volley special attack
	 * 
	 */
	@Override
	public String getSpecialAbilityDescription() {
		return "The archer can launch a devestating volley of arrows dealing " + volleyDamage
				+ "damage to every member of the opposition team";
	}

	/**
	 * Yields a generic description of an archer
	 * 
	 * @return a description of an archer
	 */
	@Override
	public String getDescription() {
		return "The archer's lethal bow skills can effectively combat its rivals, and once per battle"
				+ " it can launch a deadly attack affecting every member of the opposition team";
	}

	/**
	 * increases one of the archer's stats upon levelling up. this is done on a
	 * cycle to avoid the same stat being levelled up over and over
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
			setVolleyDamage((int) Math.round(getVolleyDamage() * 1.2));
			break;
		}
	}

	/**
	 * returns a String representation of the Archer
	 * 
	 * @return a String representation of the Archer
	 * 
	 */
	@Override
	public String toString() {
		return String.format(
				"Archer %s: maxHealth=%d, attackDamage=%d, currentHealth=%d, "
						+ "rarity=%s, price=%d, level=%d, xp=%d, levelUpXpAmount=%d, fainted=%s, volleyDamage=%d",
				getName(), getMaxHealth(), getAttackDamage(), getCurrentHealth(), getRarity(), getPrice(), getLevel(),
				getXp(), getLevelUpXpAmount(), hasFainted(), volleyDamage);
	}
}