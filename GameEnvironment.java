/**
 * Main class for the game holding the important variables
 * and methods
 * 
 * @author sammiller
 *
 */
public class GameEnvironment {

	/**
	 * Max battles per day??
	 */
	private final int battleLimitPerDay;		//Should be be a global constant
	/**
	 * number of days selected for the game to last
	 */
	private final int dayLimit;
	/**
	 * difficulty of the game
	 */
	private final String difficulty;

	/**
	 * current number of points the player has (contributing towards the overall playthough score)
	 */
	private int points;
	/**
	 * The current day the playthrough is at
	 */
	private int dayCount;
	/**
	 * the current amount of gold the player has
	 */
	private int goldCount;	
	/**
	 * the ingame shop		//???
	 */
	private Shop shop;
	/**
	 * The attributes for the available battles
	 */
	private BattleSetup battleSetup;
	/**
	 * contains the attributes of the player
	 */
	private Player player;
	
	/**
	 * sets up a game environment
	 * 
	 * @param battleLimitPerDay		???
	 * @param dayLimit				number of days selected for the game to last
	 * @param difficulty			difficulty of the game
	 * @param points
	 * @param dayCount
	 * @param goldCount
	 * @param shop
	 * @param battleSetup
	 * @param player
	 */
	public GameEnvironment(int battleLimitPerDay, int dayLimit, String difficulty, int points, int dayCount,
			int goldCount, Shop shop, BattleSetup battleSetup, Player player) {
		super();
		this.battleLimitPerDay = battleLimitPerDay;
		this.dayLimit = dayLimit;
		this.difficulty = difficulty;
		this.points = points;
		this.dayCount = dayCount;
		this.goldCount = goldCount;
		this.shop = shop;
		this.battleSetup = battleSetup;
		this.player = player;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		if (dayCount > dayLimit) {
			throw new IllegalStateException("You've reached the day limit!!");
		} else {
			this.dayCount = dayCount;
		}
	}
	public int getGoldCount() {
		return goldCount;
	}
	public void setGoldCount(int goldCount) {
		this.goldCount = goldCount;
	}
	public int getBattleLimitPerDay() {
		return battleLimitPerDay;
	}
	public int getDayLimit() {
		return dayLimit;
	}
	public String getDifficulty() {
		return difficulty;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public BattleSetup getBattleSetup() {
		return battleSetup;
	}

	public void setBattleSetup(BattleSetup battleSetup) {
		this.battleSetup = battleSetup;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void visitShop() {			//Will be a window: do we need a class for the window and a class for a ShopManager?
		shop.displayInventory();
	}
	
	public void endGame() {
		int additionalPoints = convertStatsToPoints();
		points = points + additionalPoints;
		
		displayFinalStats();
	}
	
	private int convertStatsToPoints() {
		//some formula using monsters, items in inventory, and gold goes here
	}

	public void displayFinalStats() {
		//new window?????
	}
	
	public void progressToNextDay() {
		try {
			setDayCount(getDayCount()+1);			
			shop.refreshInventory();					//Does this block work here, or does it need to go at the end of the method?
			battleSetup.refreshBattleOptions();			//If it goes at the end will it throw an exception if the game ends and then
		}												//the program tries to run that code?
		catch (IllegalStateException e) {
			endGame();
		}
	}
	
}