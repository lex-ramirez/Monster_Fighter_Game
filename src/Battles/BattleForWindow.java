package Battles;

import java.util.Random;
import java.util.Scanner;

import GUI.BattleManager;
import GameEnvironmentElements.Player;
import Monsters.*;

public class BattleForWindow {

	
	//***ADD ITEM IMPLEMENTATION***
	//***FIX SPECIAL***

    private Player opposition;
    private int pointsReward;
    private int goldReward;
    private int[] playerSpecialsUsed = {0, 0, 0};
    private int[] oppositionSpecialsUsed = {0,0,0};			
    private boolean isPlayerTurn = true;
    private int monsterIndexTurn = 0;
    private Player mainPlayer;
    private int turnNumber = 0;		//Not sure if i need this tbh lol
    private boolean playerHasWon = false;
    private boolean fightIsOver = false;
    private int targetIndex;
   

    public BattleForWindow(Player opposition, int pointsReward, int goldReward, int[] playerSpecialsUsed,
			boolean isPlayerTurn, int monsterIndexTurn, Player mainPlayer, int[] oppositionSpecialsUsed) {
		super();
		this.opposition = opposition;
		this.pointsReward = pointsReward;
		this.goldReward = goldReward;
		this.playerSpecialsUsed = playerSpecialsUsed;
		this.isPlayerTurn = isPlayerTurn;
		this.monsterIndexTurn = monsterIndexTurn;
		this.mainPlayer = mainPlayer;
		this.oppositionSpecialsUsed = oppositionSpecialsUsed;
	}

	public BattleForWindow( Player mainPlayer, Player opposition, int pointsReward, int goldReward) {
		super();
		this.opposition = opposition;
		this.pointsReward = pointsReward;
		this.goldReward = goldReward;
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
        return goldReward;
    }
    public void setGoldreward(int goldReward) {
        this.goldReward = goldReward;
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
	
	public void incrementOppositionSpecialsUsed(int index) {
		oppositionSpecialsUsed[index]++;
	}
	
	public void incrementPlayerSpecialsUsed(int index) {
		playerSpecialsUsed[index]++;
	}
	
	public int[] getOppositionSpecialsUsed() {
		return oppositionSpecialsUsed;
	}

	public void setOppositionSpecialsUsed(int[] oppositionHasUsedSpecial) {
		this.oppositionSpecialsUsed = oppositionSpecialsUsed;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}

	public int[] getPlayerSpecialsUsed() {
		return playerSpecialsUsed;
	}

	public void setPlayerSpecialsUsed(int[] playerSpecialsUsed) {
		this.playerSpecialsUsed = playerSpecialsUsed;
	}

	public Player getMainPlayer() {
		return mainPlayer;
	}

	public boolean isPlayerHasWon() {
		return playerHasWon;
	}

	public void setPlayerHasWon(boolean playerHasWon) {
		this.playerHasWon = playerHasWon;
	}

	public int getTargetIndex() {
		return targetIndex;
	}

	public void setTargetIndex(int targetIndex) {
		this.targetIndex = targetIndex;
	}

	public void chooseAttack(Player player, int monsterIndexTurn, int targetIndex, int turnTypeIndex) {
        if (turnTypeIndex == 1) {
        	if (playerSpecialsUsed[monsterIndexTurn] >= player.getTeam().get(monsterIndexTurn).getSpecialDuration()) {
    			System.out.println("This monster has already used its special attack!");
    			System.out.println("You must instead use your base attack with this monster");
    			turnTypeIndex = 1;
        	} 
        	else
        		playerSpecialsUsed[monsterIndexTurn] = 1;	//How do you use this with a base attack re choosing  aterget/ remembering the target somehow
        }
        
        //Makes sure that if the special ability is selected, and the ability should 
        //be applied to a teammate, it is
        Player targetPlayer = opposition;
        if (targetIndex == 1 && player.getTeam().get(monsterIndexTurn).getSpecialIsFriendly())
        	targetPlayer = player;
        
        /*
        while (targetPlayer.getTeam().get(targetIndex).hasFainted()) {					//Should be able to just make fainted monsters unclickable
        	System.out.println("That monster has fainted! Choose again");
        	System.out.println("Choose which index to apply the attack to (0, 1, 2)");
        	targetIndex = s.nextInt();
        }
        */
        //Actually apply the attack/ability
        switch(turnTypeIndex) {
        case 0: player.getTeam().get(monsterIndexTurn).attack(opposition.getTeam().get(targetIndex));break;
        case 1: player.getTeam().get(monsterIndexTurn).useSpecialAbility(targetPlayer.getTeam().get(targetIndex));break;	
        }																												
    }
	public void playerBaseAttack(int playerTurnIndex, int targetIndex) {
		Monster playerMonster = mainPlayer.getTeam().get(playerTurnIndex);
		Monster targetMonster = opposition.getTeam().get(targetIndex);
		playerMonster.attack(targetMonster);
		System.out.println(playerMonster.getName() + " attacked " + targetMonster.getName() 
		+ " for " + playerMonster.getAttackDamage());
		
	}

	/**
	 * One opposition monster attacks a player monster uses the base attack
	 * @param player
	 * @param monsterIndexTurn
	 * @param rng
	 */
    public int oppositionAttacks(Player player, int monsterIndexTurn, Random rng) {
    	int attackedIndex = rng.nextInt(player.getTeam().size());	
    	opposition.getTeam().get(monsterIndexTurn).attack(player.getTeam().get(attackedIndex));
    	return attackedIndex;
    }
    							
    /**
     * One opposition Monster uses its special ability
     * @param player
     * @param turn
     * @param rng
     */
    public void oppositionSpecial(int turn, Random rng) {
    	//System.out.println(player.getTeam().size());
    	
    	oppositionSpecialsUsed[turn] = 1;					//I think this is right
    	Monster currentMonster = opposition.getTeam().get(turn);											//***WHAT IS GOING ON WITH MONSTER INDEX TURN???***
		if (currentMonster.getSpecialIsFriendly()) {
			if (currentMonster.isTeamWideSpecial()) {
				for (Monster target : opposition.getTeam())
					currentMonster.useSpecialAbility(target);
			}
			else {
				int attackedIndex = rng.nextInt(opposition.getTeam().size());
				currentMonster.useSpecialAbility(opposition.getTeam().get(attackedIndex));		//What if the target monster has fainted?
			}
		} 
		else {																							//Prolly covered in gui tbf
			if (currentMonster.isTeamWideSpecial()) {
				for (Monster target : mainPlayer.getTeam())
					currentMonster.useSpecialAbility(target);
			}
			else {
				int attackedIndex = rng.nextInt(mainPlayer.getTeam().size());
				currentMonster.useSpecialAbility(mainPlayer.getTeam().get(attackedIndex));		//Wait no lingering attacks lol
			}
		}
		//System.out.println(currentMonster.getSpecialAbilityDescription()+"\n");
	}
    
    public boolean hasThisPlayerLost(Player player) {
    	boolean hasLost = true;
    	for (Monster monster : player.getTeam()) {
    		if (!monster.hasFainted())
    			hasLost = false;
    	}
    	return hasLost;
    }
    /*
    public void playBattle() {
		int seed = (int) System.currentTimeMillis() % 1000000000 % 10000;
    	Random rng = new Random(seed);
    	boolean fightIsOver = false;    
    	
		System.out.println(displayBattleState());
		
		while (!fightIsOver) {
			setTurnNumber(getTurnNumber()+1);												//Increment the turns counter
			
    		executeLingeringSpecials();														//Execute the lingering specials as required
    		
    		for (int turn = 0; turn < mainPlayer.getTeam().size(); turn++)					//Player takes turn 
    			//Maybe make selectable monsters have a green border
    			
				chooseAttack(mainPlayer, turn);
    		
    		if (hasBattleEnded())
    			break;
    		
			aiTakesTurn(rng);
			
			if (hasBattleEnded())
    			break;
			
			undoLingeringSpecials();
			
			System.out.println(displayBattleState());
			
		}
		if (playerHasWon)
    		System.out.println("You won!");
    	else
    		System.out.println("You lost :(");
    	//Apply rewards
    	//Multiply points based on progression through (i.e. number of turns) if lost
    	//undo all the boosts and stuff
    }
    */
    public void executeLingeringSpecials() {
    	
    	//Check for the player's lingering specials, and apply them if required
    	for (int i = 0; i < getMainPlayer().getTeam().size(); i++) {
			Monster monster = getMainPlayer().getTeam().get(i);
			if (getPlayerSpecialsUsed()[i] < monster.getSpecialDuration()+1 && getPlayerSpecialsUsed()[i] > 0) {
				monster.useSpecialAbility(monster.getSpecialTarget()); 
				incrementPlayerSpecialsUsed(i);			
			}
		}
    	
    	//Check for the AI's lingering specials, and apply them if required
    	for (int i = 0; i < getOpposition().getTeam().size(); i++) {
			Monster monster = getOpposition().getTeam().get(i);
			if (getOppositionSpecialsUsed()[i] < monster.getSpecialDuration()+1 && getOppositionSpecialsUsed()[i] > 0) {
				monster.useSpecialAbility(monster.getSpecialTarget()); 		//Gotta fix lingering specials
				incrementOppositionSpecialsUsed(i);						
			}
		}
    	
    }
    
    public boolean hasBattleEnded() {
    	if (hasThisPlayerLost(mainPlayer)) {
			setPlayerHasWon(false);
			fightIsOver = true;
			return true;
		} else if (hasThisPlayerLost(opposition)) {
			setPlayerHasWon(true);
			fightIsOver = true;
			return true;
		}
		else
			return false;
    }
    
    public void aiTakesTurn(Random rng) {
    	for (int turn = 0; turn < opposition.getTeam().size(); turn++) {
			if (oppositionSpecialsUsed[turn]==0 && rng.nextFloat() < 0.4) {
				oppositionSpecial(turn, rng);
				System.out.println(opposition.getTeam().get(turn).getSpecialAbilityDescription()+"\n");
			}
			else {
				int attackedIndex = oppositionAttacks(mainPlayer, turn, rng);
				System.out.println(opposition.getTeam().get(turn).getName() + " deals "+ 
						opposition.getTeam().get(turn).getAttackDamage() + " damage to "
								+ mainPlayer.getTeam().get(attackedIndex).getName());
			}
		}
    }
    
    public void undoLingeringSpecials() {
    	for (int i=0; i< mainPlayer.getTeam().size(); i++) {		//Undo the main player's expired lingering special attacks
			Monster monster = mainPlayer.getTeam().get(i);
			if (playerSpecialsUsed[i] > 0) {
				if (playerSpecialsUsed[i]==monster.getSpecialDuration()+1)
					monster.undoSpecial(monster.getSpecialTarget());
				incrementPlayerSpecialsUsed(i);
			}
		}
    	for (int i = 0; i < opposition.getTeam().size(); i++) {
			Monster monster = opposition.getTeam().get(i);
			if (oppositionSpecialsUsed[i] > 0) {
				if (oppositionSpecialsUsed[i] < monster.getSpecialDuration()+1)
					monster.undoSpecial(monster.getSpecialTarget()); 	
				incrementOppositionSpecialsUsed(i);	
			}
		}
    }


	public String displayBattleState() {
		String stateString = "****************BATTLE STATE****************\n";
		stateString = stateString + mainPlayer.getName() + ":\n";
		for (int i = 0; i < mainPlayer.getTeam().size(); i++) {
			Monster monster = mainPlayer.getTeam().get(i);
			stateString = stateString + i +": "+ monster.getName() +", hasFainted=" 
			+ monster.hasFainted() +", currentHealth="+ monster.getCurrentHealth() + "\n";
		}
		stateString = stateString + "Inventory: " + mainPlayer.getInventory() + "\n\n";
		
		stateString = stateString + opposition.getName() + ":\n";
		for (int i = 0; i < opposition.getTeam().size(); i++) {
			Monster monster = opposition.getTeam().get(i);
			stateString = stateString + i + ": " + monster.getName() + ", hasFainted=" + monster.hasFainted()
			+ ", currentHealth=" + monster.getCurrentHealth() + "\n";
		}
		stateString = stateString + "Inventory: " + opposition.getInventory() + "\n";
		stateString = stateString +"*******************************************\n";
		
		return stateString;
	}
	
}
