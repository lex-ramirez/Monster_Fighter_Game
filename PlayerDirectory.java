import java.util.ArrayList;

public class PlayerDirectory {
	//Add some randomness here?
	//eg generateMaxHealth(int level) {
	//		returns a random int for max health within a certain range determined by the current level
	
	
	// Basic/starter monsters
    private Healer stJohn = new Healer("St John", 40, 5,"Common", 65, 1, 20, 30, 5);
    private Archer robinHood = new Archer("Robin Hood", 30, 8, "Common", 100, 1, 20, 30, 5);
    private PoisonMaster twitch = new PoisonMaster("Twitch", 25, 5, "rare", 100, 1, 20, 30, 8, 2);
    private HypeMan banshee = new HypeMan("Banshee", 35, 5, "rare", 100, 1, 20, 30, 5);
    private Saboteur doom = new Saboteur("Doom", 35, 5, "rare", 100, 1, 20, 30, 5);
    private Tortoise toto = new Tortoise("Toto", 55, 4, "Common", 65, 1, 20, 25);

    
    private ArrayList<Monster> starters = new ArrayList<Monster>();

    public void chooseAStarter() {

        starters.add(stJohn);
        starters.add(robinHood);
        starters.add(twitch);
        starters.add(banshee);
        starters.add(doom);
        starters.add(toto);

        System.out.println("Choose a Starter!");

        for (int i=0; i < starters.size(); i++) {

            System.out.println(i + ": " + starters.get(i));
        }
    }

    public Monster getStarter(int position) {

        return starters.get(position);

    }
    
    // Medium monsters
    private Healer florence = new Healer("Florence", 55, 8, "Common", 135, 2, 34, 56, 10);
    private Archer hawkeye = new Archer("Hawkeye", 45, 10, "Common", 175, 3, 61, 120, 8);
    
    
    //AI players
    ArrayList<Player> aiPlayers = new ArrayList<Player>();
    private Player beth =  new Player("Beth", new ArrayList<Monster>(), new ArrayList<Item>());
    private Player kate =  new Player("Kate", new ArrayList<Monster>(), new ArrayList<Item>());
    private Player tom =  new Player("Tom", new ArrayList<Monster>(), new ArrayList<Item>());
    private Player jago =  new Player("Jago", new ArrayList<Monster>(), new ArrayList<Item>());
    private Player annika =  new Player("Annika", new ArrayList<Monster>(), new ArrayList<Item>());
    private Player kent =  new Player("Kent", new ArrayList<Monster>(), new ArrayList<Item>());
    private Player sammy =  new Player("Sammy", new ArrayList<Monster>(), new ArrayList<Item>());
    
    
    //Items
    
    private ArrayList<Item> availableItems = new ArrayList<Item>();
	AttackEnhancer attackEnhancer = new AttackEnhancer();
	SmallPotion smallPotion = new SmallPotion();
	SuperPotion superPotion = new SuperPotion();
	
	public void addToList() {
		availableItems.add(attackEnhancer);
		availableItems.add(smallPotion);
		availableItems.add(superPotion);
	}

	public ArrayList<Item> getAvailableItems() {
		return availableItems;
	}

	
	
}