
package GUI;

import java.util.ArrayList;
import java.util.Random;

import Battles.BattleForWindow;
import GameEnvironmentElements.*;
import Monsters.*;
import ShopAndItems.Item;

public class BattleManager {
	private BattleForWindow battle;
	private BattleWindow battleWindow;

	public BattleManager(BattleForWindow battle) {
		this.battle = battle;
	}
	
	public void launchBattleWindow() {
		BattleWindow window = new BattleWindow(this);
		this.battleWindow = window;
	}
	
	public BattleForWindow getBattle() {
		return battle;
	}
	
	public void closeBattleWindow(BattleWindow window) {
		window.closeWindow();
		System.out.println("Launching mainGame window");
	}
	
	public void launchPauseWindow() {
		PauseWindow window = new PauseWindow(this);
	}
	
	public void resume(PauseWindow window) {
		window.closeWindow();
	}
	
	public void forfeit(PauseWindow window) {
		window.closeWindow();
		closeBattleWindow(battleWindow);
	}
	
	public void launchInventory() {
		BattleInventory window = new BattleInventory(this);
	}
	
	public void closeInventory(BattleInventory inventory) {
		inventory.closeWindow();
	}
	
	public void playBattle(BattleForWindow battle) {
		int seed = (int) System.currentTimeMillis() % 1000000000 % 10000;
    	Random rng = new Random(seed);
    	boolean fightIsOver = false;    
    	
		System.out.println(battle.displayBattleState());
/*
		if (battle.isPlayerHasWon())
    		System.out.println("You won!");
    	else
    		System.out.println("You lost :("); */
    	//Apply rewards
    	//Multiply points based on progression through (i.e. number of turns) if lost
    	//undo all the boosts and stuff
    }
	
	public static void main(String[] args) {
		//Test whether the monsters' health updates dynamically on GUI or whether an observer kinda vibe is needed
		//or like a loop after each turn to update stats?
		PoisonMaster myPoisonMaster = new PoisonMaster("My Poisonmaster", 25, 5, "rare", 100, 1, 20, 30, 4, 2);
		Healer myHealer = new Healer("My Healer", 30, 3, "rare", 150, 4, 12, 19, 7);
		HypeMan myHypeMan = new HypeMan("My Hype man",  20,  4,  "Common",  85,  2,  9, 15,  3);
		ArrayList<Monster> starterTeam = new ArrayList<Monster>();
		starterTeam.add(myHypeMan);
		starterTeam.add(myPoisonMaster);
		starterTeam.add(myHealer);
		int[] inv = {0, 0, 0, };
		Player testPlayer = new Player("Me!", starterTeam, inv);
		/*
		Battle battle = new Battle(testPlayer, PlayerDirectory.getAiPlayers().get(0), 100, 100);
		BattleManager manager = new BattleManager(battle);
		manager.launchBattleWindow();
		*/
		BattleForWindow battle = new BattleForWindow(testPlayer, PlayerDirectory.getAiPlayers().get(0), 100, 100);
		BattleManager manager = new BattleManager(battle);
		manager.launchBattleWindow();
		manager.playBattle(battle);
	}
}
