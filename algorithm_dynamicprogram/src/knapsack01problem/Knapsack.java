package knapsack01problem;

import java.util.ArrayList;

public class Knapsack {
	
	public Knapsack(){
		originalItems = new ArrayList<Item>();
		maxValue = 0;
	}
	public Knapsack(int maxWeight){
		originalItems = new ArrayList<Item>();
		this.maxWeight = maxWeight;
		maxValue= 0;
	}
	
	
	public ArrayList<Item> getValuableItems(ArrayList<Item> original){
		int values[][]=new int[original.size()+1][maxWeight+1];
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
					}
				}
			}
		}
		maxValue = values[original.size()][maxWeight];
		//打印数组
		print(values);
		ArrayList <Item> results = new ArrayList <Item>();
		int weight = maxWeight;
		int index = original.size();
		while(index>=1){
			if(weight==0){
				break;
			}
			if(values[index][weight]==values[index-1][weight]){
				index--;
				continue;
			}
			if(values[index][weight]>values[index-1][weight]){
				Item temp =original.get(index-1);
				results.add(temp);
				weight = weight-temp.getWeight();
				index--;
				continue;
			}
		}
		System.out.println("打印装入的物品：");
		Item.printItems(results);
		return results;
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
	public ArrayList<Item> originalItems;
	private int maxValue;
	public ArrayList<Item> getOriginalItems() {
		return originalItems;
	}
	public void setOriginalItems(ArrayList<Item> originalItems) {
		this.originalItems = originalItems;
	}
	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	/**
	 * @return the maxValue
	 */
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxWeight(int maxWeight){
		this.maxWeight = maxWeight;
	}
	public int getMaxWeight(){
		return maxWeight;
	}
}
