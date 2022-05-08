package Battles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import GameEnvironmentElements.*;
import Monsters.*;
import ShopAndItems.Item;

public class Battle {

    private Player opposition;
    private int pointsReward;
    private int goldreward;
    private boolean[] hasUsedSpecialAbility = {false, false, false};
    private boolean isPlayerTurn = true;
    private int monsterIndexTurn = 0;
    private Player mainPlayer;
   

    public Battle(Player opposition, int pointsReward, int goldreward, boolean[] hasUsedSpecialAbility,
			boolean isPlayerTurn, int monsterIndexTurn, Player mainPlayer) {
		super();
		this.opposition = opposition;
		this.pointsReward = pointsReward;
		this.goldreward = goldreward;
		this.hasUsedSpecialAbility = hasUsedSpecialAbility;
		this.isPlayerTurn = isPlayerTurn;
		this.monsterIndexTurn = monsterIndexTurn;
		this.mainPlayer = mainPlayer;
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
        System.out.println("Monster selected is " + player.getTeam().get(monsterIndexTurn).getName());
        System.out.println("Press 1 to use base attack: " + player.getTeam().get(monsterIndexTurn).getAttackDamage() + " damage");
        System.out.println("Press 2 to use special attack: " + player.getTeam().get(monsterIndexTurn).getSpecialAbilityDescription());
        int selectedOption = s.nextInt();
        System.out.println("Choose which index to apply the attack to (0, 1, 2)");
        int targetIndex = s.nextInt();
        while (opposition.getTeam().get(targetIndex).hasFainted()) {
        	System.out.println("That monster has fainted! Choose again");
        	System.out.println("Choose which index to apply the attack to (0, 1, 2)");
        	targetIndex = s.nextInt();
        }
        switch(selectedOption) {
        case 1: player.getTeam().get(monsterIndexTurn).attack(opposition.getTeam().get(targetIndex));break;
        case 2: player.getTeam().get(monsterIndexTurn).useSpecialAbility(opposition.getTeam().get(targetIndex));break;	//atm only works for attacks, not for friendly
        }																												//boosts
    }	
    /*
    public Monster chooseAttackTarget() {
        //some sort of window thing i guess
        //int i = index of opposition monster
        //Monster monster = opposition.getTeam()[i];
        //return monster;
    }

    public void oppositionAttacks() {

    }*/
	
	public static void main(String[] args) {
		PoisonMaster twitch = new PoisonMaster("Twitch", 25, 5, "rare", 100, 1, 20, 30, 8, 2);
		ArrayList<Monster> starterTeam = new ArrayList<Monster>();
		starterTeam.add(twitch);
		Player testPlayer = new Player("Test McPlayer", starterTeam, new ArrayList<Item>());
		Battle battle = new Battle(PlayerDirectory.getAiPlayers().get(0), 100, 100, testPlayer);
		System.out.println(battle.displayBattleState());
		for (int turn : testPlayer.getTeam().size())
		battle.chooseAttack(testPlayer, 0);
		
		System.out.println(battle.displayBattleState());

	}

	@Override
	public String toString() {
		return "Battle [opposition=" + opposition + ",\npointsReward=" + pointsReward + ", goldreward=" + goldreward
				+ ", hasUsedSpecialAbility=" + Arrays.toString(hasUsedSpecialAbility) + ", isPlayerTurn=" + isPlayerTurn
				+ ", monsterIndexTurn=" + monsterIndexTurn + ",\nmainPlayer=" + mainPlayer + "]";
	}

	public String displayBattleState() {
		String stateString = mainPlayer.getName() + ":\n";
		for (Monster monster : mainPlayer.getTeam()) {
			stateString = stateString + monster.getName() +", hasFainted="+ monster.hasFainted() +", currentHealth="+ monster.getCurrentHealth() + "\n";
		}
		stateString = stateString + "Inventory: " + mainPlayer.getInventory() + "\n\n";
		
		stateString = stateString + opposition.getName() + ":\n";
		for (Monster monster : opposition.getTeam()) {
			stateString = stateString + monster.getName() +", hasFainted="+ monster.hasFainted() +", currentHealth="+ monster.getCurrentHealth() + "\n";
		}
		stateString = stateString + "Inventory: " + opposition.getInventory() + "\n\n";
		
		return stateString;
	}
	
}