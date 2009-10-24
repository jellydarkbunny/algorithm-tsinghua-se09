package original;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSortingLongOriginal extends TestCase{
	public void setUp(){
		TestSortingAlgorithmOriginal tsa = new TestSortingAlgorithmOriginal();
		original = tsa.getInitLong(10);
	}
	public void tearDown(){
		original=null;
	}
	public void testInsertionSort(){
		InsertionSortOriginal is = new InsertionSortOriginal();
		long [] sortedArray = is.sortLong(original);
		int size = sortedArray.length;
		if(original.length!= size){
			Assert.assertTrue(false);
		}
		assertTrue(is.checkSortedLongArray(sortedArray));
	}
	public void testQuickSort(){
		QuickSortOriginal qs = new QuickSortOriginal();
		long [] result = qs.sortLong(original);
		int size = result.length;
		if(original.length!= size){
			Assert.assertTrue(false);
		}
		for(int i=0;i<size-1;i++){
			assertTrue(result[i]<=result[i+1]);
		}
	}
	public void testMergeSort(){
		MergeSortOriginal ms = new MergeSortOriginal();
		long [] result = ms.sortLong(original);
		int size = result.length;
		if(original.length!= size){
			Assert.assertTrue(false);
		}
		for(int i=0;i<size-1;i++){
			assertTrue(result[i]<=result[i+1]);
		}
	}
	public void testRadixSort(){
		RadixSortOriginal rs = new RadixSortOriginal();
		long [] result = rs.sortLong(original);
		int size = result.length;
		if(original.length!= size){
			Assert.assertTrue(false);
		}
		for(int i=0;i<size-1;i++){
			assertTrue(result[i]<=result[i+1]);
		}
	}
	private long [] original;
}
