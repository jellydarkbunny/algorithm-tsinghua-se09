package knapsack01problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Item {
	private int value;
	private int weight;
	
	public Item(){
		
	}
	
	public Item(int value, int weight){
		this.value = value;
		this.weight = weight;
	}
	
	public String toString(){
		return "("+value+","+weight+")";
	}
	
	public double getUnitPrice(){
		return value/weight;
	}
	
 	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	public static void printItems(ArrayList <Item> results){
		System.out.println("��Ʒ��");
		int valueSum =0;
		int weightSum = 0;
		for(int i = 0;i<results.size();i++){
			Item item = results.get(i);
			valueSum = valueSum + item.getValue();
			weightSum = weightSum + item.getWeight();
			System.out.print(item);
		}
		System.out.println("\n��Ʒ�ܹ���"+weightSum+"\t��Ʒ�ܼ�ֵ"+valueSum);
	}
	public static String getPrintItemsString(ArrayList <Item> results){
		String s = results.size()+"����Ʒ\n";
		int valueSum =0;
		int weightSum = 0;
		for(int i = 0;i<results.size();i++){
			Item item = results.get(i);
			valueSum = valueSum + item.getValue();
			weightSum = weightSum + item.getWeight();
			s = s+item;
		 }
		s=s+"\n��Ʒ�ܹ���"+weightSum+"\t��Ʒ�ܼ�ֵ"+valueSum;
		return s;
	
	}
	public static ArrayList <Item> getItems(int n){
		ArrayList <Item> items = new ArrayList<Item>();
		Random ran = new Random();
		BigInteger value;
		BigInteger weight;
		for(int i = 0;i<n;i++){
			value = new BigInteger(3,ran);
			weight = new BigInteger(3,ran);
			items.add(new Item(value.intValue()+1,weight.intValue()+1));
		}
		return items;
	}
	
}
