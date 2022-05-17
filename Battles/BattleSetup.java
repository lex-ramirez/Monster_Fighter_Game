package Battles;

import java.util.ArrayList;
import GameEnvironmentElements.*;

public class BattleSetup {

    //private Player Chase = new Player("Chase", {Archer("Slinger", 40, 5, "Rare", 65,0, 0, 10,8), });

    private ArrayList<Battle> battleList;
    private ArrayList<Player> aiPlayers;

    public ArrayList<Battle> getBattleList() {
        return battleList;
    }
    public void setBattleList(ArrayList<Battle> battleList) {
        this.battleList = battleList;
    }
    public ArrayList<Player> getAiPlayers() {
        return aiPlayers;
    }
    public void setAiPlayers(ArrayList<Player> aiPlayers) {
        this.aiPlayers = aiPlayers;
    }

    public String displayBattleOptions() {
        String battleString = "Your battle options are: ";
        for (Battle battle : battleList) {
            battleString = battleString + battle+ ", ";
        }
        return battleString;
    }

    public ArrayList<Battle> generateBattleOptions(int dayCount, String difficulty) {
        double difficultyMultiplier;

        switch (difficulty) {
        case "Easy": difficultyMultiplier = 0.8; break;
        case "Medium": difficultyMultiplier = 1; break;
        case "Hard": difficultyMultiplier = 1.2; break;
        default: throw new IllegalArgumentException(difficulty+" is not a valid difficulty");
        }

        double dayCountMultiplier = dayCount/10 + 0.9;        //multiplier is one on day 1, then increases by .1 
                                                            //each subsequent day

    }

    public void chooseBattle() {

    }

}