import java.util.*;
import java.util.regex.Pattern;

public class MainGame {
	
	public static String getPlayerName(Scanner s) {
		String name = null;
		
		boolean valid = false;
		while (!valid) {
			System.out.println("Input your name");
			s.nextLine();
			name = s.nextLine();
			System.out.println("name: " + name);
			if (Pattern.matches("[a-zA-Z]{3,16}", name))
				valid = true;
			if (!valid)
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
	
	public static ArrayList<Monster> chooseStarter(Scanner s) {

        //Creates a playerDirectory class, important for the monsters
        PlayerDirectory newPlayerDirectory = new PlayerDirectory();
        newPlayerDirectory.chooseAStarter();

        //Asks the user for monster position
        //Scanner s = new Scanner(System.in);
        System.out.println("Select a Starter (0-5): "); 
        String position = s.nextLine();
        int starterPosition = Integer.parseInt(position);

        //Creates arrayList of starter monster (pass this into the player class)
        ArrayList<Monster> starterMonster = new ArrayList<Monster>();
        starterMonster.add(newPlayerDirectory.getStarter(starterPosition));
        System.out.println("You have Selected: " + starterMonster.get(0).getName());

        // Asks the user if they would like to name the monster
        System.out.println("Would you like to name your Monster? (yes/no) ");
        String starterName = s.nextLine();

        // Switch statement depending on the input by the user
        switch(starterName) {
        case "yes": 
            System.out.println("Name your Monster: "); 
            String monsterName = s.nextLine();
            starterMonster.get(0).setName(monsterName);
            System.out.println("Your monster's is: " + starterMonster.get(0).getName());
            break;

        case "no": 
            System.out.println("Your monster's name is: " + starterMonster.get(0).getName()); 
            break;
        }
        return starterMonster;
    }
	
	public static Shop initialiseShop() {
		Shop shop = new Shop();
		shop.setItemList(PlayerDirectory.getAvailableItems());
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int dayLimit = getDayLimit(s);
		String difficulty = getDifficulty(s);
		String name = getPlayerName(s);
		ArrayList<Monster> team = chooseStarter(s);
		Player player = new Player(name, team, new ArrayList<Item>());
	
		//GameEnvironment gameEnvironment = new GameEnvironment(1, dayLimit, difficulty,0, 1, 0, Shop shop, battleSetup, player))
	}
}