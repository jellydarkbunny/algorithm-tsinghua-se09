package original;

import java.math.BigInteger;
import java.util.ArrayList;


import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSortingOriginal extends TestCase{
	public void setUp(){
		TestSortingAlgorithmOriginal tsa = new TestSortingAlgorithmOriginal();
		original = tsa.getInit(100000);
	}
	public void tearDown(){
		original.clear();
	}
	public void testInsertionSort(){
		InsertionSortOriginal is = new InsertionSortOriginal();
		ArrayList <BigInteger> result = is.sort(original);
		int size = result.size();
		if(original.size()!= size){
			Assert.assertTrue(false);
		}
		for(int i=0;i<size-1;i++){
			assertTrue(result.get(i).compareTo(result.get(i+1))!=1);
		}
	}
	public void testMergeSort(){
		MergeSortOriginal ms = new MergeSortOriginal();
		ArrayList <BigInteger> result = ms.sort(original);
		int size = result.size();
		if(original.size()!= size){
			Assert.assertTrue(false);
		}
		for(int i=0;i<size-1;i++){
			assertTrue(result.get(i).compareTo(result.get(i+1))!=1);
		}
	}
	public void testQuickSort(){
		QuickSortOriginal qs = new QuickSortOriginal();
		ArrayList <BigInteger> result = qs.sort(original);
		int size = result.size();
		if(original.size()!= size){
			Assert.assertTrue(false);
		}
		for(int i=0;i<size-1;i++){
			assertTrue(result.get(i).compareTo(result.get(i+1))!=1);
		}
	}
	public void testRadixSort(){
		RadixSortOriginal rs = new RadixSortOriginal();
		ArrayList <BigInteger> sortedArray = rs.sort(original);
		int size = sortedArray.size();
		if(original.size()!= size){
			Assert.assertTrue(false);
		}
		assertTrue(rs.checkSortedArray(sortedArray));
	}
	private ArrayList <BigInteger> original;
}
