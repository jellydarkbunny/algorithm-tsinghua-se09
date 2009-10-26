package lis;

import java.util.ArrayList;

public class LisAlgorithm {
	protected int getMaxLength(int [] array){
		int max = 0;
		for(int i = 0;i<array.length;i++){
			if(array[i] > max){
				max = array[i];
			}
		}
		return max;
	}
	
	//返回最长递增子序列。
	public int [] getRecords(int [] array,int b[],int maxLength){
		String bstring = "b[n]:" + arrayToString(b);
		System.out.println(bstring);
		ArrayList <ArrayList<Integer>> records = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<maxLength;i++){
			records.add((new ArrayList<Integer>()));
		}
		for(int i = 0;i<b.length;i++){
			int j = b[i];
			int value = array[i];
			records.get(j-1).add(value);
		}
		ArrayList <Integer> result = new ArrayList<Integer>();
		int lastElement = Integer.MAX_VALUE;
		for(int i = maxLength-1;i>=0;i--){
			ArrayList <Integer> temp = records.get(i);
			int max= getMax(temp,lastElement);
				result.add(max);
				lastElement = max;
		}
		
		int [] longestSeq = new int[maxLength];
		for(int i = 0;i< maxLength;i++){
			longestSeq [i] = result.get(result.size()-1-i);
		}
		String lstring = "最长子序列 :"+arrayToString(longestSeq);
		System.out.println(lstring);
		return longestSeq;
	}
	
 
	
	public int getMax(ArrayList <Integer> array,int lastMax){
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for(int i = 0;i<array.size();i++){
			temp = array.get(i);
			if(max <= temp){
				if(temp<=lastMax){
					max = temp;
				}
			}
		}
		return max;
	}
	public void printArray(ArrayList <Integer> array){
		for(int i = 0;i<array.size();i++){
			System.out.print(array.get(i)+"\t");
		}
		System.out.println();
	}
	public String arrayToString(int [] array){
		String s = "{ ";
		for(int i = 0;i<array.length;i++){
			s=s+array[i]+" ";
		}
		s =s+"}";
		return s;
	}
	public int getLongestLength(int [] input){
		return 0;
	}
	public void setLengthRecords(int [] lengthRecords) {
		this.lengthRecords = lengthRecords;
	}

	public int [] getLengthRecords() {
		return lengthRecords;
	}
	public void setLongestLength(int longestLength) {
		this.longestLength = longestLength;
	}
	public int getLongestLength() {
		return longestLength;
	}
	public void setOriginalArray(int [] originalArray) {
		this.originalArray = originalArray;
	}

	public int [] getOriginalArray() {
		return originalArray;
	}
	private int [] originalArray;
	private int [] lengthRecords;
	private int longestLength;
}


