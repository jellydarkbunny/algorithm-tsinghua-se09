package knapsack01problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Knapsack {
	
	public Knapsack(int maxWeight){
		this.maxWeight = maxWeight;
	}
	
	public ArrayList<Item> getValuableItems(ArrayList<Item> original){
		int values[][]=new int[original.size()+1][maxWeight+1];
		Set <Item> results = new HashSet<Item>();
		for(int i = 0;i<original.size()+1;i++){
			values[i][0]=0;
		}
		for(int j = 0;j<maxWeight+1;j++){
			values[0][j]=0;
		}
		for(int i = 1;i<original.size()+1;i++){
			Item item = original.get(i-1);
			for(int j = 1;j<maxWeight+1;j++){
				values[i][j] = values[i-1][j];
				if(item.getWeight() <= j ){
					int temp = values[i-1][j-item.getWeight()]+item.getValue();
					if(temp > values[i][j]){
						values[i][j]=temp;
						if(i==original.size()){
							results.add(item);
						}
					}
				}
			}
		}
		print(values);
		Iterator iterator = results.iterator();
		while(iterator.hasNext()){
			System.out.print((Item)iterator.next()+"\t");
		}
		System.out.println();
		return new ArrayList<Item>();
	}
	public void print(int values[][]){
		for(int i = 0;i<values.length;i++){
			for(int j = 0;j<values[i].length;j++){
				System.out.print(values[i][j]+"\t");
			}
			System.out.println();
		}
	}
	private int maxWeight;
	
}
