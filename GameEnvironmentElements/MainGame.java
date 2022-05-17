package GameEnvironmentElements;

import java.util.*;
import java.util.regex.Pattern;

import GUI.TitleScreen;
import Monsters.*;
import ShopAndItems.*;

//
public class MainGame {
	
	public static String getPlayerName(Scanner s) {
		String name = null;
		
		boolean valid = false;
		while (!valid) {
			System.out.println("Input your name");
			//s.nextLine();
			name = s.nextLine();
			System.out.println("name: " + name);
			if (Pattern.matches("[a-zA-Z]{3,16}", name))
				valid = true;
			else
				System.out.println("Invalid name! (name must be 3-15 characters with no special characters");
		}
		return name;
	}
	
	public static int getDayLimit(Scanner s) {
		//Implement with a slider in the gui (if using terminal add exceptions)
		System.out.println("How many days should the game last?");
		int dayLimit = s.nextInt();
		System.out.println(dayLimit + " days long");
		return dayLimit;
	}

	public static String getDifficulty(Scanner s) {
		String difficulty = null;
		System.out.println("Choose your desired difficulty:");
		System.out.println("press 1 for easy, 2 for medium, or 3 for hard");
		int difficultyInt = s.nextInt();
		switch(difficultyInt) {
		case 1: difficulty = "Easy"; 	 break;
		case 2: difficulty = "Medium";	 break;
		case 3: difficulty = "Hard";	 break;
		//Don't need a default to catch errors as there will be no other options once gui is implemented
		}
		return difficulty;
	}
	
	public static ArrayList<Monster> chooseStarter(Scanner s, PlayerDirectory playerDirectory) {
		
        playerDirectory.chooseAStarter();

        //Asks the user for monster position
        //Scanner s = new Scanner(System.in);
        System.out.println("Select a Starter (0-5): "); 
        String position = s.nextLine();
        int starterPosition = Integer.parseInt(position);

        //Creates arrayList of starter team (pass this into the player class)
        //comprised of only the starter monster
        ArrayList<Monster> starterTeam = new ArrayList<Monster>();
        starterTeam.add(playerDirectory.getStarter(starterPosition));
        System.out.println("You have Selected: " + starterTeam.get(0).getName());

        // Asks the user if they would like to name the monster
        System.out.println("Would you like to name your Monster? (yes/no) ");
        String starterName = s.nextLine();

        // Switch statement depending on the input by the user
        switch(starterName) {
        case "yes": 
            System.out.println("Name your Monster: "); 
            String monsterName = s.nextLine();
            starterTeam.get(0).setName(monsterName);
            System.out.println("Your monster's is: " + starterTeam.get(0).getName());
            break;

        case "no": 
            System.out.println("Your monster's name is: " + starterTeam.get(0).getName()); 
            break;
        }
        return starterTeam;
    }
	
	public static Shop initialiseShop(PlayerDirectory playerDirectory) {
		ArrayList<Item> items = playerDirectory.getAvailableItems();
		ArrayList<Monster> monsters = playerDirectory.getAllMonsters();
		Shop shop = new Shop(monsters, items);
		return shop;
	}
	
	
	public static void main(String[] args) {
		
		TitleScreen newWindow = new TitleScreen();
	}
	
	//public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		
        //Creates a playerDirectory class, important for the monsters, shop, and battle
        //PlayerDirectory playerDirectory = new PlayerDirectory();
		
		//int dayLimit = getDayLimit(s);
		//String difficulty = getDifficulty(s);
		//String name = getPlayerName(s);
		/*System.out.println(name);
		ArrayList<Monster> starterTeam = chooseStarter(s, playerDirectory);
		Player player = new Player(name, starterTeam, new ArrayList<Item>());
		Shop shop = initialiseShop(playerDirectory);
		Player aiPlayer = playerDirectory.getAiPlayers().get(0);
		Battle battle = new Battle(aiPlayer, 500, 250);
		ArrayList<Battle> battles = new ArrayList<Battle>(); battles.add(battle);
		BattleSetup battleSetup = new BattleSetup(battles);
		
	
		GameEnvironment gameEnvironment = new GameEnvironment(1, dayLimit, difficulty,0, 1, 0, shop, battleSetup, player);
		System.out.println("\n" + gameEnvironment);*/
		
	//}
}

//Sam has edited MainGame, PlayerDirectory, shop, gamEnvironment, and all items

//Name special chars breaks it lol
//Item toString is broken, but doesn't really matter I guess