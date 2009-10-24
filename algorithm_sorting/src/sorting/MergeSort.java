package sorting;

public class MergeSort extends SortingAlgorithmParent{
	public MergeSort(){
		name = "merge sort";
	}
	public long [] sortLong(long [] original){
		sortOriginal = original;
		mergeSort(0,sortOriginal.length-1);
		return sortOriginal;
	}
	
	private void mergeSort(int startIndex,int endIndex){
		int originalSize = endIndex - startIndex +1;
		if(originalSize==2){
			if(sortOriginal[startIndex]>sortOriginal[endIndex]){
				exchange(startIndex,endIndex);
			}
		}
		if(originalSize>2){
			int middle = originalSize/2+startIndex;
			mergeSort(startIndex, middle-1);
			mergeSort(middle,endIndex);
			combineLong(startIndex,middle,endIndex);
		}
	}
	private void combineLong(int startIndex,int middle, int endIndex){
		int index1 = startIndex;
		int index2 = middle;
		int size1 = middle;
		int size2 = endIndex+1;
		long [] sortedArray = new long [endIndex-startIndex+1];
		int sortedArrayIndex = 0;
		while(true){
			if(index1==size1){
				if(index2==size2){
					break;
				}
				sortedArray[sortedArrayIndex]= sortOriginal[index2];
				sortedArrayIndex++;
				index2++;
				continue;
			}
			if(index2==size2){
				sortedArray[sortedArrayIndex]=sortOriginal[index1];
				sortedArrayIndex++;
				index1++;
				continue;
			}
			if(sortOriginal[index1]<=sortOriginal[index2]){
				sortedArray[sortedArrayIndex] =sortOriginal[index1];
				sortedArrayIndex++;
				index1++;
				continue;
			}
			sortedArray[sortedArrayIndex]=sortOriginal[index2];
			sortedArrayIndex++;
			index2++;
		}
		for(int i = 0;i<sortedArray.length;i++){
			sortOriginal[i+startIndex] = sortedArray[i];
		}
		sortedArray =null;
	}
	 
}
