package original;

import java.math.BigInteger;
import java.util.ArrayList;


public class MergeSortOriginal extends SortingAlgorithmParentOriginal{
	public MergeSortOriginal(){
		name = "merge sort";
	}
	/********************************************************************
	 * 
	 */
	public ArrayList <BigInteger> sort(ArrayList <BigInteger> original){
		int originalSize = original.size();
		if(originalSize==0||originalSize==1){
			return original;
		}
		//Divid
		ArrayList <BigInteger> orig1 = new ArrayList <BigInteger>();
		ArrayList <BigInteger> orig2 = new ArrayList <BigInteger>();
		
		for(int i = 0;i<originalSize;i++){
			if(i<originalSize/2){
				orig1.add(original.get(i));
			}else{
				orig2.add(original.get(i));
			}
		}
		ArrayList <BigInteger> sorted1 = sort(orig1);
		ArrayList <BigInteger> sorted2 = sort(orig2);
		//combine
		ArrayList <BigInteger> sortedArray =combine(sorted1,sorted2);
		return sortedArray;
	}
	public long [] sortLong(long [] original){
		int originalSize = original.length;
		if(originalSize==0||originalSize==1){
			return original;
		}
		long [] orig1 = new long [originalSize/2];
		long [] orig2 = new long [originalSize-originalSize/2];
		int orgi2Index = 0;
		for(int i = 0;i<originalSize;i++){
			if(i<originalSize/2){
				orig1[i]=original[i];
			}else{
				orig2[orgi2Index]=original[i];
				orgi2Index++;
			}
		}
		long [] sorted1 = sortLong(orig1);
		long [] sorted2 = sortLong(orig2);
		long [] sortedArray = combineLong(sorted1,sorted2);
		return sortedArray;
	}
	/********************************************************************
	 * Request: Two input array should be sorted ahead of time.
	 * Effect: Combine two sorted array into one array.
	 * @param sorted1
	 * @param sorted2
	 * @return a sorted array.
	 *********************************************************************/
	private ArrayList <BigInteger> combine(ArrayList <BigInteger> sorted1,ArrayList <BigInteger> sorted2){
		ArrayList <BigInteger> sortedArray = new ArrayList<BigInteger>();
		int index1 = 0;
		int index2 = 0;
		int size1 = sorted1.size();
		int size2 = sorted2.size();
		BigInteger a;
		BigInteger b;
		while(true){
			if(index1==size1){
				if(index2==size2){
					break;
				}
				sortedArray.add(sorted2.get(index2));
				index2++;
				continue;
			}
			if(index2==size2){
				sortedArray.add(sorted1.get(index1));
				index1++;
				continue;
			}
			//still stable sorting
			//a<=b add a to the result
			a = sorted1.get(index1);
			b = sorted2.get(index2);
			if(a.compareTo(b)!=1){
				sortedArray.add(a);
				index1++;
				continue;
			}
			sortedArray.add(b);
			index2++;
		}
		return sortedArray;
	}
	private long [] combineLong(long[] sorted1,long []sorted2){
		int index1 = 0;
		int index2 = 0;
		int size1 = sorted1.length;
		int size2 = sorted2.length;
		long [] sortedArray = new long [size1+size2];
		int sortedArrayIndex = 0;
		while(true){
			if(index1==size1){
				if(index2==size2){
					break;
				}
				sortedArray[sortedArrayIndex]= sorted2[index2];
				sortedArrayIndex++;
				index2++;
				continue;
			}
			if(index2==size2){
				sortedArray[sortedArrayIndex]=sorted1[index1];
				sortedArrayIndex++;
				index1++;
				continue;
			}
			//still stable sorting
			//sorted1[index1] <= sorted2[index2] add sorted1[index1] to the result
			if(sorted1[index1]<=sorted2[index2]){
				sortedArray[sortedArrayIndex] =sorted1[index1];
				sortedArrayIndex++;
				index1++;
				continue;
			}
			sortedArray[sortedArrayIndex]=sorted2[index2];
			sortedArrayIndex++;
			index2++;
		}
		return sortedArray;
	}
}
