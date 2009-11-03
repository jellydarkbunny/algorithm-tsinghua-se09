package knapsack01problem;

import java.util.ArrayList;

public class TestKnapsack {
	public static void main(String [] args){
		ArrayList <Item> test = Item.getItems(5);
		for(int i = 0;i<test.size();i++){
			System.out.println(test.get(i));
		}
		
		Knapsack knap = new Knapsack(15);
		knap.getValuableItems(test);
	}
	
}
