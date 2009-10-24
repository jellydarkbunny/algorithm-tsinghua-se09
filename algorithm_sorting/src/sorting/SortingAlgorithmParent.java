package sorting;

import java.math.BigInteger;
import java.util.Random;

public class SortingAlgorithmParent {
	
	/***************************************************************
	 * ִ�������㷨
	 * @param original
	 ***************************************************************/
	public void runSortLong(long [] original){
		double start = System.currentTimeMillis();
		double nastart = System.nanoTime();
		sortLong(original);
		double naend = System.nanoTime();
		double end = System.currentTimeMillis();
		if(end-start==0){
			System.out.println(original.length+"���������ͨ��"+name+"�㷨��������ʱ��Ϊ"+(naend-nastart)+"ns");
		}else{
			System.out.println(original.length+"���������ͨ��"+name+"�㷨��������ʱ��Ϊ"+(end-start)+"ms");
		}
		
	}
	
	/*******************************************************************
	 * ����õ��������Ƿ��ź���
	 * @param sortedArray
	 * @return
	 *******************************************************************/
 	public boolean checkSortedLongArray(long [] sortedArray){
		for(int i =0;i<sortedArray.length-1;i++){
			if(sortedArray[i]>sortedArray[i+1]){
				return false;
			}
		}
		return true;
	}
 	public void checkLongArray(long [] result){
		boolean b = checkSortedLongArray(result);
		if(!b){
			System.out.println("�㷨"+name+"����");
		}
		if(b){
			System.out.println("�㷨"+name+"��ȷ");
		}
 	}

	/******************************************************************
	 * ��Console�д�ӡ����
	 * @param array
	 ******************************************************************/
	public void printLongArray(long [] array){
		System.out.print("{");
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println("}");
	}
	public long [] getInitLong(int n){
		int numBits = 32;
		return getInitLong(n,numBits);
	}
	public long [] getInitLong(int n, int numBits){
		long [] array = new long [n];
		Random rnd = new Random();
		double start = System.currentTimeMillis();
		double nastart = System.nanoTime();
		for(int i = 0;i<n;i++){
			BigInteger ran = new BigInteger(numBits, rnd);
			array[i] = ran.longValue();
		}
		double naend = System.nanoTime();
		double end = System.currentTimeMillis();
		if(end-start==0){
			System.out.println("����"+(naend-nastart)+"ns��������"+n+"��Longֵ�������");
		}else{
			System.out.println("����"+(end-start)+"ms��������"+n+"��Longֵ�������");
		}
		return array;
	}
	public long [] getInitLongMath(int n,int num){
		long [] array = new long[n];
		double start = System.currentTimeMillis();
		for(int i = 0;i<n;i++){
			double d = Math.random();
			array[i] = (long)(d*(Math.pow(2, 32)-1));
		}
		double end = System.currentTimeMillis();
		System.out.println("����"+(end-start)+"ms��������"+n+"��Longֵ�������");
		return array;
	}
	
	protected void exchange(int startIndex, int endIndex){
		long temp = sortOriginal[startIndex];
		sortOriginal[startIndex] = sortOriginal[endIndex];
		sortOriginal[endIndex] = temp;
	}
	
	public long [] sortLong(long [] original){
		return new long [0];
	}
	public void setName(String name){
		this.name =name;
	}
	public String getName(){
		return name;
	}
	public void setSortOriginal(long [] sortOriginal){
		this.sortOriginal =sortOriginal;
	}
	public long [] getSortOriginal(){
		return sortOriginal;
	}
	protected String name;
	protected long [] sortOriginal; 
	
}
