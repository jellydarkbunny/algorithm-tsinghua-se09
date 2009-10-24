package test;

import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.RadixSort;
import sorting.SortingAlgorithmParent;
import junit.framework.Assert;
import junit.framework.TestCase;


/*****************************************************************
 * This test Case is used to verify whether the four algorithms
 * works.
 * @author Administrator
 *
 */
public class TestSortingLong extends TestCase{
	public void setUp(){
		SortingAlgorithmParent tsa = new SortingAlgorithmParent();
		original = tsa.getInitLong(10);
	}
	public void tearDown(){
		original=null;
	}
	public void testInsertionSort(){
		InsertionSort is = new InsertionSort();
		long [] sortedArray = is.sortLong(original);
		int size = sortedArray.length;
		if(original.length!= size){
			Assert.assertTrue(false);
		}
		assertTrue(is.checkSortedLongArray(sortedArray));
	}
	public void testQuickSort(){
		QuickSort qs = new QuickSort();
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
		MergeSort ms = new MergeSort();
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
		RadixSort rs = new RadixSort();
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
