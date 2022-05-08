package Monsters;

/**
 * 
 * @author sammiller
 *
 *         This class is the parent of all of the monster types. It contains all
 *         of the generic methods and attributes of monsters.
 * 
 */
public abstract class Monster { // abstract
	/**
	 * the name of the monster
	 */
	private String name;
	/**
	 * the health cap of the monster
	 */
	private int maxHealth;
	/**
	 * the base attack damage of the monster
	 */
	private int attackDamage;
	/**
	 * the current health of the monster
	 */
	private int currentHealth;
	/**
	 * the rarity of the monster
	 */
	private String rarity; // Are we including this?
	/**
	 * the price/value of the monster
	 */
	private int price;
	/**
	 * the current level of the monster
	 */
	private int level;
	/**
	 * the current xp of the monster
	 */
	private int xp = 0;
	/**
	 * the amount of xp required for the monster to be able to level up
	 */
	private int levelUpXpAmount;
	/**
	 * whether or not the monster has fainted (as opposed to being conscious)
	 */
	private boolean fainted = false;

	/**
	 * Initialises the variables of an instance of the Monster class
	 * 
	 * @param name           the name of the monster
	 * @param maxHealth      the health cap of the monster
	 * @param attackDamage   the damage per attack done by the monster using its
	 *                       regular/base attack
	 * @param rarity         the rarity of the monster //Are we using this and do we
	 *                       need a better description?
	 * @param price          the value of the monster if it were to be bought from
	 *                       the shop
	 * @param level          the level of the monster
	 * @param xp             the xp of the monster (how far towards leveling up it
	 *                       is)
	 * @param levelUpXpCount the amount of xp at which the monster will level up
	 * 
	 */
	public Monster(String name, int maxHealth, int attackDamage, String rarity, int price, int level, int xp,
			int levelUpXpAmount) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.attackDamage = attackDamage;
		this.currentHealth = maxHealth;
		this.rarity = rarity;
		this.price = price;
		this.level = level;
		this.xp = xp;
		this.levelUpXpAmount = levelUpXpAmount;
	}

	/**
	 * Returns a string of the monster's name followed by its attributes
	 * 
	 * @return a formatted string of the monster's name followed by its attributes
	 */
	public String toString() {
		return String.format(
				"Monster %s: maxHealth=%d, attackDamage=%d, currentHealth=%d, "
						+ "rarity=%s, price=%d, level=%d, xp=%d, levelUpXpAmount=%d, fainted=%s",
				name, maxHealth, attackDamage, currentHealth, rarity, price, level, xp, levelUpXpAmount, fainted);
	}

	/**
	 * Gets the name of the monster
	 * 
	 * @return the name of the monster
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name the desired name of the monster
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Yields the health cap of the monster
	 * 
	 * @return the health cap of the monster
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * sets the health cap of the monster to a desired value
	 * 
	 * @param maxHealth the desired new health cap of the monster
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * yields the base attack damage of a monster
	 * 
	 * @return the monster's base attack damage
	 */
	public int getAttackDamage() {
		return attackDamage;
	}

	/**
	 * sets the monster's base attack damage
	 * 
	 * @param damage desired new value of the monster's base attack damage
	 */
	public void setAttackDamage(int damage) {
		attackDamage = damage;
	}

	/**
	 * yields the monster's current health
	 * 
	 * @return the current health of the monster
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * sets the current health of the monster to a desired new value
	 * 
	 * @param health the desired new value of the health of the monster
	 */
	public void setCurrentHealth(int health) {
		currentHealth = health;
	}

	/**
	 * yields the rarity of the monster
	 * 
	 * @return the rarity of the monster
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 * sets the rarity of the monster
	 * 
	 * @param rarity the desired new value of rarity
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/**
	 * yields the value of the monster
	 * 
	 * @return the value of the monster (the price it would be in the store)
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * sets the value of a monster
	 * 
	 * @param price the desired new value of the monster
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Yields the current level of the monster
	 * 
	 * @return the current level of the monster
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * sets the level of the monster to the desired amount //necessary?
	 * 
	 * @param level the desired new level of the monster
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * yeilds the current xp of the monster
	 * 
	 * @return the current xp of the monster
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * sets the monster's xp to a desired value
	 * 
	 * @param xp the desired new value of the monster's xp
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	/**
	 * yields the amount of xp required for the monster to level up
	 * 
	 * @return the xp level-up amount
	 */
	public int getLevelUpXpAmount() {
		return levelUpXpAmount;
	}

	/**
	 * sets the amount of xp required to level up to be a new desired value
	 * 
	 * @param xp the new desired xp level up amount
	 */
	public void setLevelUpXpAmount(int xp) {
		levelUpXpAmount = xp;
	}

	/**
	 * Yields a boolean of whether or not the monster has fainted
	 * 
	 * @return <code>true<\code> if the monster has fainted; <code>false<\code>
	 *         otherwise (the monster is conscious)
	 */
	public boolean hasFainted() {
		return fainted;
	}

	/**
	 * Sets the value of fainted to be true from false (i.e the monster was
	 * conscious, then fainted)
	 * 
	 * @throws IllegalStateException if fainted is already true (the monster has
	 *                               already fainted)
	 */
	public void faint() {
		if (fainted == true)
			throw new IllegalStateException("This monster has already fainted");
		else {
			fainted = true;
		}
	}

	/**
	 * Sets the value of fainted to be false from true (i.e the monster had fainted,
	 * then was woken up)
	 * 
	 * @throws IllegalStateException if fainted is already false (the monster is
	 *                               already conscious)
	 */
	public void revive() {
		if (fainted == false)
			throw new IllegalStateException("This monster is already awake!");
		else {
			fainted = false;
		}
	}

	/**
	 * Levels the monster up and increases some of its stats if its xp meets the
	 * required threshold
	 * 
	 * @throws IllegalArgumentException if the xp is not at the required threshold
	 * 
	 */
	public void levelUp() {
		if (xp < levelUpXpAmount)
			throw new IllegalArgumentException("More xp is required to level up");
		else {
			level = level + 1;
			levelUpXpAmount = (int) Math.round(levelUpXpAmount + 0.5 * levelUpXpAmount);
			increaseStat();
		}
	}

	/**
	 * Generates a value/cost of the monster taking into account its stats
	 * 
	 * @return a value/price of the monster
	 * 
	 * @throws IllegalStateException if the rarity is not one of the possible values
	 *                               of rarities
	 */
	public int generateCost() { // Very happy to revise this
		int price = 0;

		if (rarity != "Common" && rarity != "Rare" && rarity != "Legendary") {
			throw new IllegalArgumentException("Not a valid rarity");
		} else {
			switch (rarity) {
			case "Common":
				price = 25;
				break;
			case "Rare":
				price = 50;
				break;
			case "Legendary":
				price = 100;
				break;
			}
		}

		price = price * (int) Math.pow(1.2, level);
		price = (int) price * (maxHealth + attackDamage) / 20; // *10% of the average
		if (hasFainted())
			price = (int) Math.round(price * 0.8);

		return price;
	}

	/**
	 * Increases one of the monster's stats (chosen from attackDamage, maxHealth, or
	 * specialAbility)
	 * 
	 */
	public abstract void increaseStat();

	/**
	 * Uses the monster's special ability if it has not been used in the current
	 * battle
	 * 
	 * @param the monster on which the special ability will be used
	 * @throws IllegalStateException if the special attack has already been used in
	 *                               the current battle
	 */
	public abstract void useSpecialAbility(Monster target);					//I think there should be a for loop which can have a
																			//number of iterations of 1 for the basic ones
	/**
	 * Yeilds a description of the monster's special ability
	 * 
	 * @return a description of the monster's special ability
	 */
	public abstract String getSpecialAbilityDescription();

	/**
	 * Yields a description of the monster
	 * 
	 * @return a description of the monster
	 */
	public abstract String getDescription();

}