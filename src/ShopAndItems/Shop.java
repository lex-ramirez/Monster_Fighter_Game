package ShopAndItems;

import java.util.ArrayList;
import Monsters.*;

/**
 * @author Lex Ramirez
 * This is the shop class, where the player can buy and sell
 * monsters and/or items.
 *
 */
//
public class Shop {
	
	/**
	 * Variables of the class shop
	 */
	private ArrayList<Monster> monsterList;
	private ArrayList<Item> itemList;
	private Monster boughtMonster;
	private Item boughtItem;
	
	/**
	 * Constructor method for class shop
	 */
	public Shop() {
		
		monsterList = new ArrayList<Monster>();
		itemList = new ArrayList<Item>();

	}
	
	/**
	 * Constructor method for shop which takes arguments for itemList and 
	 * monsterList
	 * @param monsters	the desired new monsterList
	 * @param items		the desired new itemList
	 */
	public Shop(ArrayList<Monster> monsters, ArrayList<Item> items) {
		monsterList = monsters;
		itemList = items;
	}
	/**
	 * Adds a monster to the ArrayList monsterList
	 * @param addedMonster
	 */
	public void addMonster(Monster addedMonster) {
		monsterList.add(addedMonster);
	}
	/**
	 * Adds an item to the ArrayList itemList
	 * @param addedItem
	 */
	public void addItem(Item addedItem) {
		itemList.add(addedItem);
	}
	/**
	 * Returns the monsterList (Monsters available in the shop)
	 * @return monsterList
	 */
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}
	/**
	 * Returns the itemList (Items available in the shop)
	 * @return itemList
	 */
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	//Could be a good idea for these to throw an IllegalArgumentException if the player doesn't have enough gold
	/**
	 * 'Buys' a monster at a specified position in the ArrayList, removes that monster and
	 * returns it.
	 * @param position - position of monster to be bought (will be prompted)
	 * @return boughtMonster
	 */
	public Monster buyMonster(int position) {
		
		boughtMonster = monsterList.get(position);
		monsterList.remove(position);
		return boughtMonster;	
	}
	
	/**
	 * 'Buys' an item at a specified position in the ArrayList, removes that item and
	 * returns it.
	 * @param position - position of item to be bought (will be prompted)
	 * @return boughtItem
	 */
	public Item buyItem(int position) {
		
		boughtItem = itemList.get(position);
		itemList.remove(position);
		return boughtItem;
	}
	
	/**
	 * 'Sells' the item that a play wants to sell, adds it to the shop's
	 * ArrayList of Items.
	 * @param soldItem
	 */
	public void sellItem(Item soldItem) {
		
		//Adds the item being sold into shop inventory
		itemList.add(soldItem);
		
		//Use some other method to give gold to the player after selling?
	}
	
	/**
	 * 'Sells' the monster that a player wants to sell, adds it to the
	 * shop's ArrayList of Monsters
	 * @param soldMonster
	 */
	public void sellMonster(Monster soldMonster) {
		
		//Same idea
		monsterList.add(soldMonster);
	}
	
	/**
	 * Prints the description of the shop, useful for showing the player
	 * what's available in the shop.
	 */
	public void getShopDescription() {
		
		System.out.println("Avaiable Items:");
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println(i + ": " + itemList.get(i).getName() + ", Price: " + itemList.get(i).getPrice() + " Gold");
		}
		
		System.out.println("Available Monsters:");
		for(int i = 0; i < monsterList.size(); i++) {
			System.out.println(i + ": " + monsterList.get(i).getName() + ", Price: " + monsterList.get(i).getPrice() + " Gold");
		}
	}

	@Override
	public String toString() {
		return "Shop [monsterList=" + monsterList + ", itemList=" + itemList + ", boughtMonster=" + boughtMonster
				+ ", boughtItem=" + boughtItem + "]";
	}
	
}