package knapsack01problem;

import java.util.ArrayList;

public class TestFractionalKnapsack {
	public static void main(String []args){
		FractionalKnapsack fk = new FractionalKnapsack(15);
		int n = 10;
		ArrayList <Item> items = Item.getItems(n);
		fk.getMedian(items);
	}
}
