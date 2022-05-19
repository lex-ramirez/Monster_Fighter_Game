package GameEnvironmentElements;

import java.util.ArrayList;
import Monsters.*;
import ShopAndItems.*;

public class Player {

    private String name;
    private ArrayList<Monster> team  = new ArrayList<Monster>();
    private int[] inventory = {0, 0, 0, 0}; // Number of, in order, AttackDamagePotions, AttackEnhancerPotionas

    
    public Player(String name, ArrayList<Monster> team, int[] inventory) {
        super();
        this.name = name;
        this.team = team;
        this.inventory = inventory;
    }

    public Player(String name, ArrayList<Monster> team) {
        super();
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Monster> getTeam() {
        return team;
    }
    public void setTeam(ArrayList<Monster> team) {
        this.team = team;
    }
    
    public int[] getInventory() {
        return inventory;
    }
    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }
/*
    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
        }
        else {
            throw new IllegalArgumentException("This item is not in the inventory");
        }
    }
    */
    public void displayTeam() {
        //Some sort of window thing??
    }

	@Override
	public String toString() {
		return "Player [name=" + name + ", team=" + team + ", inventory=" + inventory + "]";
	}
    
}