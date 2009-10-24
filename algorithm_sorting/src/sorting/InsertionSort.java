package sorting;

import java.math.BigInteger;
import java.util.ArrayList;

public class InsertionSort extends SortingAlgorithmParent{
	public InsertionSort(){
		name ="insertion sort";
	}
	public ArrayList <BigInteger> sort(ArrayList <BigInteger> original){
		ArrayList <BigInteger> sortedArray = new ArrayList<BigInteger>();
		BigInteger sortedInt;
		BigInteger originalInt;
		boolean b = false;
		for(int i=0;i<original.size();i++){
			originalInt = original.get(i);
			b = false;
			for(int j=0;j<sortedArray.size();j++){
				sortedInt = sortedArray.get(j);
				if(sortedInt.compareTo(originalInt)==1){
					sortedArray.add(j, originalInt);
					b = true;
					break;
				}
			}
			if(!b){
				sortedArray.add(originalInt);
			}
		}
		return sortedArray;
	}
	
	public int [] sortInt(int [] original){
		int [] sortedArray = new int[original.length];
		boolean b = false;
		int sortedInt;
		int originalInt;
		int index =0;
		for(int i=0;i<original.length;i++){
			originalInt = original[i];
			b = false;
			for(int j=0;j<index;j++){
				sortedInt = sortedArray[j];
				if(sortedInt>originalInt){
					for(int k = index-1;k>=j;k--){
						sortedArray[k+1]= sortedArray[k];
					}
					sortedArray[j]=originalInt;
					index ++;
					b = true;
					break;
				}
			}
			if(!b){
				sortedArray[index]=originalInt;
				index++;
			}
		}
		return sortedArray;
	}
	
	public long [] sortLong (long [] original){
		long [] sortedArray = new long [original.length];
		boolean b = false;
		long sortedInt;
		long originalInt;
		int index =0;
		for(int i=0;i<original.length;i++){
			originalInt = original[i];
			b = false;
			for(int j=0;j<index;j++){
				sortedInt = sortedArray[j];
				if(sortedInt>originalInt){
					for(int k = index-1;k>=j;k--){
						sortedArray[k+1]= sortedArray[k];
					}
					sortedArray[j]=originalInt;
					index ++;
					b = true;
					break;
				}
			}
			if(!b){
				sortedArray[index]=originalInt;
				index++;
			}
		}
		return sortedArray;
	}
	
}
