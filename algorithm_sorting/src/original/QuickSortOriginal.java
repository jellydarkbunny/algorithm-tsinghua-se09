package original;

import java.math.BigInteger;
import java.util.ArrayList;


public class QuickSortOriginal extends SortingAlgorithmParentOriginal{
	public QuickSortOriginal(){
		name = "Quick sort";
	}
	 
	
	public long [] sortLong(long [] original){
		sortOriginal = original;
		quickSort(0,sortOriginal.length-1);
		return sortOriginal;
	}
	private void quickSort(int startIndex,int endIndex){
		int originalSize = endIndex - startIndex;
		if(originalSize==1){
			if(sortOriginal[startIndex] > sortOriginal[endIndex]){
				long temp = sortOriginal[startIndex];
				sortOriginal[startIndex] = sortOriginal[endIndex];
				sortOriginal[endIndex] = temp;
			}
		}
		if(originalSize>1){
			long privot = sortOriginal[endIndex];
			int lowIndex=startIndex;
			int highNum=0;
			for(int i = startIndex; i< endIndex;i++){
				long currentValue = sortOriginal[i];
				if(currentValue <= privot){
					if(highNum>0){
						long temp = sortOriginal[lowIndex];
						sortOriginal[lowIndex] = sortOriginal[i];
						sortOriginal[i] = temp;
					} 
					lowIndex++;
				}else{
					highNum++;
				}
			}
			sortOriginal[endIndex] = sortOriginal[lowIndex];
			sortOriginal[lowIndex] = privot;
 			quickSort(startIndex,lowIndex-1);
 			quickSort(lowIndex+1,endIndex);
		}
		
	}
	
	public long [] sortLong_2(long [] original){
		int originalSize = original.length;
		if(originalSize==0||originalSize==1){
			return original;
		}
		long [] tempArray = new long[originalSize];
		long privot = original[originalSize-1];
		int lowIndex=0;
		int highNum=0;
		for(int i = 0;i<originalSize-1;i++){
			if(original[i]<=privot){
				if(highNum>0){
					long temp = tempArray[lowIndex];
					tempArray[lowIndex]=original[i];
					tempArray[i] = temp;
					lowIndex++;
				}else{
					tempArray[i]= original[i];
					lowIndex++;
				}
			}else{
				tempArray[i]= original[i];
				highNum++;
			}
		}
		long [] listLow = new long[lowIndex];
		long [] listHigh = new long[originalSize-lowIndex-1];
		for(int i = 0; i<lowIndex;i++){
			listLow[i]= tempArray [i];
		}
		int listHighIndex = 0;
		for(int i = lowIndex;i<tempArray.length-1;i++){
			listHigh[listHighIndex] = tempArray[i];
			listHighIndex++;
		}
		long [] sorted1 = sortLong(listLow);
		long [] sorted2 = sortLong(listHigh);
		
		long [] sortedArray = combineLong(sorted1,sorted2,privot);
		return sortedArray;
	}
	
	private long [] combineLong(long [] sorted1, long [] sorted2,long privot){
		int size = sorted1.length+sorted2.length+1;
		long [] sortedArray = new long [size];
		int sortedArrayIndex = 0;
		for(int i = 0;i<sorted1.length;i++){
			sortedArray[sortedArrayIndex]= sorted1[i];
			sortedArrayIndex++;
		}
		sortedArray[sortedArrayIndex] = privot;
		sortedArrayIndex++;
		for(int i = 0;i<sorted2.length;i++){
			sortedArray[sortedArrayIndex] = sorted2[i];
			sortedArrayIndex++;
		}
		return sortedArray;
	}
	
	/********************************************************************
	 * Request: The input array are a list of BigIntegers
	 * 			When make the combine operation, the two input array 
	 * 			should be sorted ahead of time.
	 * Effect: Divide and Combine two sorted array into sorted one.
	 * @return a sorted array.
	 *********************************************************************/
	public ArrayList <BigInteger> sort(ArrayList <BigInteger> original){
		int originalSize = original.size(); 
		if(originalSize==0||originalSize==1){
			return original;
		}
		
		ArrayList <BigInteger> listLow = new ArrayList <BigInteger>();
		ArrayList <BigInteger> listHigh = new ArrayList <BigInteger>();
		int privotIndex = original.size()-1;
		BigInteger privot = original.get(privotIndex);
		for(int i =0;i<original.size();i++){
			if(i==privotIndex){
				continue;
			}
			if(original.get(i).compareTo(privot)!=1){
				listLow.add(original.get(i));
			}else{
				listHigh.add(original.get(i));
			}
		}
		ArrayList <BigInteger> sorted1 = sort(listLow);
		ArrayList <BigInteger> sorted2 = sort(listHigh);
		ArrayList<BigInteger> sortedArray = combine(sorted1,sorted2,privot);
		return sortedArray;
	}
	
	public ArrayList <BigInteger> combine(ArrayList <BigInteger> sorted1,ArrayList <BigInteger> sorted2, BigInteger privot){
		ArrayList <BigInteger> sortedArray = new ArrayList<BigInteger>();
		for(int i = 0;i<sorted1.size();i++){
			sortedArray.add(sorted1.get(i));
		}
		sortedArray.add(privot);
		for(int i = 0;i<sorted2.size();i++){
			sortedArray.add(sorted2.get(i));
		}
		return sortedArray;
	}
	
}
