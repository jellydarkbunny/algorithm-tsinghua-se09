package knapsack01problem;

import java.util.ArrayList;

public class FractionalKnapsack {
	private int maxWeight;
	private ArrayList <Item> items;
	public FractionalKnapsack(int maxWeight){
		this.maxWeight = maxWeight;
	}
	public int getMaxWeight(){
		return maxWeight;
	}
	
	public Item getMedian(ArrayList<Item> items){
		if(items.size()==1){
			return items.get(0);
		}
		if(items.size()<1){
			return null;
		}
		Item median= items.get(0);
		int index = 0;
		for(int i = 1;i<items.size();i++){
			Item temp = items.get(i);
			if(median.getUnitPrice()<=temp.getUnitPrice()){
				if(index<0){
					index++;
				}if(index==0){
					index++;
				}if(index>0){
					index--;
					median = temp;
				}
			}else{
			}
		}
		return median;
	}
}
