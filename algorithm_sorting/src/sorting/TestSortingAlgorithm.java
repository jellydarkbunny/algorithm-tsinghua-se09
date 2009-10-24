package sorting;

public class TestSortingAlgorithm {
	public static void main(String []args){
		//testAll();
	}
	public static void testAll(){
		SortingAlgorithmParent tsa = new SortingAlgorithmParent();
		long [] original;
		int num = 10;
		while(true){
			if(num == 100000000){
				original = tsa.getInitLong(num,32);
				QuickSort qs = new QuickSort();
				qs.runSortLong(original);
				break;
			}
			if(num >= 1000000){
				original = tsa.getInitLong(num,32);
				compareThreeAlgorithms(original);
			}else{
				original = tsa.getInitLong(num,32);
				compareAlgorithms(original);
			}
			num = num *10;
		}
	}
	public static void compareThreeAlgorithms(long [] original){
		QuickSort qs = new QuickSort();
		qs.runSortLong(original);
		MergeSort ms = new MergeSort();
		ms.runSortLong(original);
		RadixSort rs = new RadixSort();
		rs.runSortLong(original);
	}
	public static void compareAlgorithms(long [] original){
		QuickSort qs = new QuickSort();
		qs.runSortLong(original);
		MergeSort ms = new MergeSort();
		ms.runSortLong(original);
		RadixSort rs = new RadixSort();
		rs.runSortLong(original);
		InsertionSort is = new InsertionSort();
		is.runSortLong(original);
	}
	  
	
}
