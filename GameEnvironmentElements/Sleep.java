package GameEnvironmentElements;
import java.util.ArrayList;
import Monsters.*;
import java.util.Random;
import GameEnvironmentElements.*;


/**
 * 
 * @author Lex Ramirez
 * Sleep represents a player 'sleeping' overnight. During sleep, a few
 * things should happen to the player, implemented in this class.
 *
 */
public class Sleep {
	
	private Random rng;
	private int randomNumber;
	private PlayerDirectory monsters = new PlayerDirectory();
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();

	
	public Sleep() {
		
		rng = new Random();
	}
	
	/**
	 * This method heals all the monsters to full health
	 * @param team - Player's team of monsters.
	 */
	public void healMonstersOvernight(ArrayList<Monster> team) {

		// Heals all monsters back to full health
		for (Monster monster : team) {
			
			monster.setCurrentHealth(monster.getMaxHealth());
		}
	}
	
	/**
	 * Method for a monster leaving overnight
	 */
	public void monsterLeaves(ArrayList<Monster> team) {
		
		randomNumber = rng.nextInt(31);
		
		
		// 1 in 30 chance
		if (randomNumber == 30) {
			System.out.println(team.get(0).getName() + " has left your team overnight!");
			team.remove(0);
			
		}
		
		//Not sure how to implement: "The chance of a monster leaving should be increased if the monster
		//has fainted the previous day(s)
	}
	
	//Pass in the player team to be added to 
	public void monsterJoins(ArrayList<Monster> team) {
		
		//List of monsters from player directory
		monsterList = monsters.getAllMonsters();
		
		if (team.size() < 3) {
			
			//If team has only 1 free spot
			if (team.size() == 2) {
				randomNumber = rng.nextInt(51);
				
				//1 in 50 chance
				if (randomNumber == 50) {
					
					//Take a random monster from player directory
					team.add(monsterList.get(rng.nextInt(9)));
				}
			}
			
			//If team has 2 free spots
			else if (team.size() == 1) {
				randomNumber = rng.nextInt(31);
				
				//1 in 30 chance
				if (randomNumber == 30) {
					
					team.add(monsterList.get(rng.nextInt(9)));
				}
			}
		}
	}
	
	/**
	 * Method for a monster leveling up overnight
	 * @param team - Player's team of monsters
	 */
	public void monsterLevelsUp(ArrayList<Monster> team) {
		
		randomNumber = rng.nextInt(21);
		
		//1 in 20 chance of a monster leveling up overnight
		if (randomNumber == 20) {
		Monster currentMonster = team.get(0);
		currentMonster.setLevel((currentMonster.getLevel() + 1));
		}
		
	}
	
	public static void main(String[] args) {
		
		Sleep sleep = new Sleep();
		
		//TEST FOR HEALING MONSTERS OVERNIGHT: PASSED
		Healer stJohn = new Healer("St John", 40, 5,"Common", 65, 1, 20, 30, 5);
		Archer robinHood = new Archer("Robin Hood", 30, 8, "Common", 100, 1, 20, 30, 5);
		PoisonMaster twitch = new PoisonMaster("Twitch", 25, 5, "rare", 100, 1, 20, 30, 8, 2);
		stJohn.setCurrentHealth(30);
		robinHood.setCurrentHealth(20);
		twitch.setCurrentHealth(15);
		System.out.println("stJohn injured Health: " + stJohn.getCurrentHealth());
		System.out.println("robinHood injured Health: " + robinHood.getCurrentHealth());
		System.out.println("twitch injured Health: " + twitch.getCurrentHealth());
		
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		monsterList.add(stJohn);
		monsterList.add(robinHood);
		monsterList.add(twitch);
		
		
		sleep.healMonstersOvernight(monsterList);
		
		for (int i = 0; i < monsterList.size(); i++) {
			
			System.out.println("Updated Health: " + monsterList.get(i).getCurrentHealth());
		}
		
		
		//TEST FOR MONSTER LEAVING: PASSED
		sleep.monsterLeaves(monsterList);
		System.out.println(monsterList.size());
		
		
		
		
		
	}
	
	//Battles are updated needs to be implemented elsewhere?
	//Update items in the shop implemented elsewhere?
}
