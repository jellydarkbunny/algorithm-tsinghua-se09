package knapsack01problem;

import java.util.ArrayList;

public class TestKnapsack {
	public static void main(String [] args){
		ArrayList <Item> original = Item.getItems(7);
		System.out.println("≥ı ºŒÔ∆∑£∫");
		Item.printItems(original);
		
		Knapsack knap = new Knapsack(13);
		knap.getValuableItems(original);
	}
	
}
