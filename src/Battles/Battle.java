package Battles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import GameEnvironmentElements.*;
import Monsters.*;
import ShopAndItems.Item;

public class Battle {

    private Player opposition;
    private int pointsReward;
    private int goldreward;
    private boolean[] hasUsedSpecialAbility = {false, false, false};
    private boolean[] oppositionHasUsedSpecial = {false, false, false};
    private boolean isPlayerTurn = true;
    private int monsterIndexTurn = 0;
    private Player mainPlayer;
   

    public Battle(Player opposition, int pointsReward, int goldreward, boolean[] hasUsedSpecialAbility,
			boolean isPlayerTurn, int monsterIndexTurn, Player mainPlayer, boolean[] oppositionHasUsedSpecial) {
		super();
		this.opposition = opposition;
		this.pointsReward = pointsReward;
		this.goldreward = goldreward;
		this.hasUsedSpecialAbility = hasUsedSpecialAbility;
		this.isPlayerTurn = isPlayerTurn;
		this.monsterIndexTurn = monsterIndexTurn;
		this.mainPlayer = mainPlayer;
		this.oppositionHasUsedSpecial = oppositionHasUsedSpecial;
	}

	public Battle(Player opposition, int pointsReward, int goldreward, Player mainPlayer) {
		super();
		this.opposition = opposition;
		this.pointsReward = pointsReward;
		this.goldreward = goldreward;
		this.mainPlayer = mainPlayer;
	}

	public Player getOpposition() {
        return opposition;
    }
    public void setOpposition(Player opposition) {
        this.opposition = opposition;
    }
    public int getPointsReward() {
        return pointsReward;
    }
    public void setPointsReward(int pointsReward) {
        this.pointsReward = pointsReward;
    }
    public int getGoldreward() {
        return goldreward;
    }
    public void setGoldreward(int goldreward) {
        this.goldreward = goldreward;
    }
    public boolean[] getHasUsedSpecialAbility() {
        return hasUsedSpecialAbility;
    }
    public void setHasUsedSpecialAbility(boolean[] hasUsedSpecialAbility) {
        this.hasUsedSpecialAbility = hasUsedSpecialAbility;
    }

    public boolean isPlayerTurn() {
		return isPlayerTurn;
	}

	public void setPlayerTurn(boolean isPlayerTurn) {
		this.isPlayerTurn = isPlayerTurn;
	}
	
	public void changeTurns() {
		isPlayerTurn = !isPlayerTurn;
	}

	public int getMonsterIndexTurn() {
		return monsterIndexTurn;
	}

	public void setMonsterIndexTurn(int monsterIndexTurn) {
		this.monsterIndexTurn = monsterIndexTurn;
	}
	
	public void incrementMonsterTurn() {
		if (monsterIndexTurn < 2) {
			monsterIndexTurn++;
		}
		else {
			monsterIndexTurn = 0;
			changeTurns();
		}
	}

	public void chooseAttack(Player player, int monsterIndexTurn) {
        Scanner s = new Scanner(System.in);
        
        //Select whether to use base attack or special ability
        System.out.println("Monster selected is " + player.getTeam().get(monsterIndexTurn).getName());
        System.out.println("Press 1 to use base attack: " + player.getTeam().get(monsterIndexTurn).getAttackDamage() + " damage");
        System.out.println("Press 2 to use special attack: " + player.getTeam().get(monsterIndexTurn).getSpecialAbilityDescription());
        int selectedOption = s.nextInt();
        if (selectedOption == 2) {
        	if (hasUsedSpecialAbility[monsterIndexTurn]) {
    			System.out.println("This monster has already used its special attack!");
    			System.out.println("You must instead use your base attack with this monster");
    			selectedOption = 1;
        	} else
        		hasUsedSpecialAbility[monsterIndexTurn] = true;
        }
        
        //Select which monster to apply the special attack to
        System.out.println("Choose which index to apply the attack to (0, 1, 2)");
        int targetIndex = s.nextInt();
        
        //Makes sure that if the special ability is selected, and the ability should 
        //be applied to a teammate, it is
        Player targetPlayer = opposition;
        if (targetIndex == 2 && player.getTeam().get(monsterIndexTurn).getSpecialIsFriendly())
        	targetPlayer = player;
        while (targetPlayer.getTeam().get(targetIndex).hasFainted()) {
        	System.out.println("That monster has fainted! Choose again");
        	System.out.println("Choose which index to apply the attack to (0, 1, 2)");
        	targetIndex = s.nextInt();
        }
        //Actually apply the attack/ability
        switch(selectedOption) {
        case 1: player.getTeam().get(monsterIndexTurn).attack(opposition.getTeam().get(targetIndex));break;
        case 2: player.getTeam().get(monsterIndexTurn).useSpecialAbility(targetPlayer.getTeam().get(targetIndex));break;	
        }																												
    }

	/**
	 * One opposition monster attacks a player monster uses the base attack
	 * @param player
	 * @param monsterIndexTurn
	 * @param rng
	 */
    public void oppositionAttacks(Player player, int monsterIndexTurn, Random rng) {
    	int attackedIndex = rng.nextInt(player.getTeam().size());	
    	opposition.getTeam().get(monsterIndexTurn).attack(player.getTeam().get(attackedIndex));
    }
    							
    /**
     * One opposition Monster uses its special ability
     * @param player
     * @param turn
     * @param rng
     */
    public void oppositionSpecial(Player player, int turn, Random rng) {
    	//System.out.println(player.getTeam().size());
    	oppositionHasUsedSpecial[turn] = true;
		int attackedIndex = rng.nextInt(player.getTeam().size());	
		if (opposition.getTeam().get(monsterIndexTurn).getSpecialIsFriendly()) {
			opposition.getTeam().get(monsterIndexTurn).useSpecialAbility(opposition.getTeam().get(attackedIndex));
		} else {
			opposition.getTeam().get(monsterIndexTurn).useSpecialAbility(player.getTeam().get(attackedIndex));
		}
	}
    
    public boolean hasThisPlayerLost(Player player) {
    	boolean hasLost = true;
    	for (Monster monster : player.getTeam()) {
    		if (!monster.hasFainted())
    			hasLost = false;
    	}
    	return hasLost;
    }
	
	public static void main(String[] args) {
		//Initialise a Battle
		
		//THIS BLOCK IS FOR TESTING, AND SHOULD BE CHANGED
		PoisonMaster twitch = new PoisonMaster("Twitch", 25, 5, "rare", 100, 1, 20, 30, 8, 2);
		ArrayList<Monster> starterTeam = new ArrayList<Monster>();
		starterTeam.add(twitch);
		Player testPlayer = new Player("Test McPlayer", starterTeam, new ArrayList<Item>());
		
		//This bit stays: actually makes a battle
		Battle battle = new Battle(PlayerDirectory.getAiPlayers().get(0), 100, 100, testPlayer);
		int seed = (int) System.currentTimeMillis() % 1000000000 % 10000;
    	Random rng = new Random(seed);
    	
    	boolean fightIsOver = false;    	
		System.out.println(battle.displayBattleState());

    	while (!fightIsOver) {
	    	//Player takes a turn
			for (int turn = 0; turn < testPlayer.getTeam().size(); turn++)
				battle.chooseAttack(testPlayer, turn);
			//checks if the battle is over (move into its own function)
			if (battle.hasThisPlayerLost(testPlayer)) {
				System.out.println("You lost :(");
				fightIsOver = true;
				break;
			} else if (battle.hasThisPlayerLost(battle.getOpposition())) {
				System.out.println("You won!!!");
				fightIsOver = true;
				break;
			}
			
			//AI takes its turn
			for (int turn = 0; turn < testPlayer.getTeam().size(); turn++) {
				if (!battle.oppositionHasUsedSpecial[turn] && rng.nextBoolean()) {
					battle.oppositionSpecial(testPlayer, turn, rng);
					System.out.println(battle.getOpposition().getTeam().get(turn).getSpecialAbilityDescription()+"\n");
				}
				else {
					battle.oppositionAttacks(testPlayer, turn, rng);
					System.out.println(battle.getOpposition().getTeam().get(turn).getName() + " deals "+ 
							battle.getOpposition().getTeam().get(turn).getAttackDamage() + " damage\n");
				}
			}
			//System.out.println("AI attacks!\n");
			if (battle.hasThisPlayerLost(battle.getOpposition())) {
				System.out.println("You won!!!");
				fightIsOver = true;
			} else if (battle.hasThisPlayerLost(testPlayer)) {
				System.out.println("You lost :(");
				fightIsOver = true;
			}
			System.out.println(battle.displayBattleState());

    	}
	}


	@Override
	public String toString() {
		return "Battle [opposition=" + opposition + ",\npointsReward=" + pointsReward + ", goldreward=" + goldreward
				+ ", hasUsedSpecialAbility=" + Arrays.toString(hasUsedSpecialAbility) + ", isPlayerTurn=" + isPlayerTurn
				+ ", monsterIndexTurn=" + monsterIndexTurn + ",\nmainPlayer=" + mainPlayer + "]";
	}

	public String displayBattleState() {
		String stateString = "****************BATTLE STATE****************\n";
		stateString = stateString + mainPlayer.getName() + ":\n";
		for (Monster monster : mainPlayer.getTeam()) {
			stateString = stateString + monster.getName() +", hasFainted="+ monster.hasFainted() +", currentHealth="+ monster.getCurrentHealth() + "\n";
		}
		stateString = stateString + "Inventory: " + mainPlayer.getInventory() + "\n\n";
		
		stateString = stateString + opposition.getName() + ":\n";
		for (Monster monster : opposition.getTeam()) {
			stateString = stateString + monster.getName() +", hasFainted="+ monster.hasFainted() +", currentHealth="+ monster.getCurrentHealth() + "\n";
		}
		stateString = stateString + "Inventory: " + opposition.getInventory() + "\n";
		stateString = stateString +"*******************************************\n";
		
		return stateString;
	}
	
}