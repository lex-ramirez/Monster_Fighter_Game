package GameEnvironmentElements;

import java.util.ArrayList;
import Monsters.*;
import ShopAndItems.*;

//
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
    public static ArrayList<Player> getAiPlayers() {
    ArrayList<Player> aiPlayers = new ArrayList<Player>();
    ArrayList<Monster> ai1Team = new ArrayList<Monster>(); 
    ai1Team.add(new Tortoise("AI Tortoise", 29, 3, "rare", 145, 2, 5, 7));
    ai1Team.add(new Archer("AI Archer", 25, 5, "Common", 100, 1, 20, 30, 4));
    ai1Team.add(new Saboteur("AI Saboteur", 23, 4, "rare", 110, 3, 12, 15, 3));
    int[] inv = {0};
    Player ai1 =  new Player("AI 1", ai1Team, inv);
    /*
    Player kate =  new Player("Kate", new ArrayList<Monster>(), new ArrayList<Item>());
    Player tom =  new Player("Tom", new ArrayList<Monster>(), new ArrayList<Item>());
    Player jago =  new Player("Jago", new ArrayList<Monster>(), new ArrayList<Item>());
    Player annika =  new Player("Annika", new ArrayList<Monster>(), new ArrayList<Item>());
    Player kent =  new Player("Kent", new ArrayList<Monster>(), new ArrayList<Item>());
    Player sammy =  new Player("Sammy", new ArrayList<Monster>(), new ArrayList<Item>());*/
    aiPlayers.add(ai1);
    /*
    aiPlayers.add(kate);
    aiPlayers.add(tom);
    aiPlayers.add(jago);
    aiPlayers.add(annika);
    aiPlayers.add(kent);
    aiPlayers.add(sammy);
    */
    return aiPlayers;
    }
    
    
    
    //Items
    //removed static
	public ArrayList<Item> addToList() {
    	ArrayList<Item> availableItems = new ArrayList<Item>();
		AttackEnhancer attackEnhancer = new AttackEnhancer();
		//SmallPotion smallPotion = new SmallPotion();
		SuperPotion superPotion = new SuperPotion();
		availableItems.add(attackEnhancer);
		//availableItems.add(smallPotion);
		availableItems.add(superPotion);
		return availableItems;
	}

	public ArrayList<Item> getAvailableItems() {
		return addToList();
	}

	public ArrayList<Monster> getAllMonsters() {
		 ArrayList<Monster> monsterList = new ArrayList<Monster>();
		 
        monsterList.add(stJohn);
        monsterList.add(robinHood);
        monsterList.add(twitch);
        monsterList.add(banshee);
        monsterList.add(doom);
        monsterList.add(toto);
        monsterList.add(florence);
        monsterList.add(hawkeye);
        
        return monsterList;
        
	}
	
}