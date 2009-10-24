package original;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class TestSortingAlgorithmOriginal {
	
	public static void main(String []args){
 	}
	public void compareAlgorithms(long [] original){
		QuickSortOriginal qs = new QuickSortOriginal();
		qs.runSortLong(original);
		MergeSortOriginal ms = new MergeSortOriginal();
		ms.runSortLong(original);
		RadixSortOriginal rs = new RadixSortOriginal();
		rs.runSortLong(original);
		//InsertionSort is = new InsertionSort();
		//is.runSortLong(original);
	}
	/**************************************************************
	 * 当输入数组数量大于10000000数量级的时候，存储对象的ArrayList会
	 * 造成内存不够的问题。
	 * @param original
	 **************************************************************/
	public void compareAlgorithms(ArrayList <BigInteger> original){
		RadixSortOriginal rs = new RadixSortOriginal();
		rs.runSort(original);
		QuickSortOriginal qs = new QuickSortOriginal();
		qs.runSort(original);
		MergeSortOriginal ms = new MergeSortOriginal();
		ms.runSort(original);
		InsertionSortOriginal is = new InsertionSortOriginal();
		is.runSort(original);
	}
	/******************************************************************
	 * 
	 * @param n
	 * @return
	 ******************************************************************/
	public ArrayList <BigInteger> getInit(int n){
		ArrayList <BigInteger> array = new ArrayList<BigInteger>();
		Random rnd = new Random();
		double start = System.currentTimeMillis();
		for(int i = 0;i<n;i++){
			BigInteger ran = new BigInteger(32,rnd);
			array.add(ran);
		}
		double end = System.currentTimeMillis();
		System.out.println("经过"+(end-start)+"ms，创建了"+n+"个BigInteger数随机数组");
		return array;
	}
	public int [] getInitInt(int n){
		int [] array = new int [n];
		Random rnd = new Random();
		double start = System.currentTimeMillis();
		int numbit =5;
		for(int i = 0;i<n;i++){
			BigInteger ran = new BigInteger(numbit,rnd);
			array[i]= ran.intValue();
		}
		double end = System.currentTimeMillis();
		System.out.println("经过"+(end-start)+"ms，创建了"+n+"个int值随机数组");
		return array;
	}
	public long [] getInitLong(int n){
		int numBits = 32;
		return getInitLong(n,numBits);
	}
	public long [] getInitLong(int n, int numBits){
		long [] array = new long [n];
		Random rnd = new Random();
		double start = System.currentTimeMillis();
		for(int i = 0;i<n;i++){
			BigInteger ran = new BigInteger(numBits, rnd);
			array[i] = ran.longValue();
		}
		double end = System.currentTimeMillis();
		System.out.println("经过"+(end-start)+"ms，创建了"+n+"个Long值随机数组");
		return array;
	}
	public ArrayList <BigInteger> changeLongToBigInteger(long[] array){
		ArrayList <BigInteger> result = new ArrayList <BigInteger>();
		double start = System.currentTimeMillis();
		for(int i = 0;i<array.length;i++){
			result.add(new BigInteger(String.valueOf(array[i])));
		}
		double end = System.currentTimeMillis();
		System.out.println("经过"+(end-start)+"ms，转换了"+result.size()+"个Long为BigInteger的数组");
		return result;
	}
}
