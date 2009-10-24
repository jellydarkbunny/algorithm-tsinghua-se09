package sorting;

public class QuickSort extends SortingAlgorithmParent{
	public QuickSort(){
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
}
