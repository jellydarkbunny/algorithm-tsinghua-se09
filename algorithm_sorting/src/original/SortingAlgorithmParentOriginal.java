package original;

import java.math.BigInteger;
import java.util.ArrayList;

public class SortingAlgorithmParentOriginal {
	
	/***************************************************************
	 * ִ�������㷨
	 * @param original
	 ***************************************************************/
	public void runSort(ArrayList <BigInteger> original){
		double start = System.currentTimeMillis();
		ArrayList <BigInteger> result = sort(original);
		double end = System.currentTimeMillis();
		System.out.println(original.size()+"���������ͨ��"+name+"�㷨��������ʱ��Ϊ"+(end-start)+"ms");
		boolean b = checkSortedArray(result);
		if(!b){
			System.out.println("�㷨"+name+"����");
		}
	}
	public void runSortInt(int [] original){
		double start = System.currentTimeMillis();
		int [] result = sortInt(original);
		double end = System.currentTimeMillis();
		System.out.println(original.length+"���������ͨ��"+name+"�㷨��������ʱ��Ϊ"+(end-start)+"ms");
		boolean b = checkSortedIntArray(result);
		if(!b){
			System.out.println("�㷨"+name+"����");
		}
	}
	public void runSortLong(long [] original){
		double start = System.currentTimeMillis();
		long [] result = sortLong(original);
		double end = System.currentTimeMillis();
		System.out.println(original.length+"���������ͨ��"+name+"�㷨��������ʱ��Ϊ"+(end-start)+"ms");
		boolean b = checkSortedLongArray(result);
		if(!b){
			System.out.println("�㷨"+name+"����");
		}
	}
	
	/*******************************************************************
	 * ����õ��������Ƿ��ź���
	 * @param sortedArray
	 * @return
	 *******************************************************************/
	public boolean checkSortedArray(ArrayList <BigInteger> sortedArray){
		for(int i=0;i<sortedArray.size()-1;i++){
			if(sortedArray.get(i).compareTo(sortedArray.get(i+1))==1){
				return false;
			}
		}
		return true;
	}
	public boolean checkSortedIntArray(int [] sortedArray){
		for(int i =0;i<sortedArray.length-1;i++){
			if(sortedArray[i]>sortedArray[i+1]){
				return false;
			}
		}
		return true;
	}
	public boolean checkSortedLongArray(long [] sortedArray){
		for(int i =0;i<sortedArray.length-1;i++){
			if(sortedArray[i]>sortedArray[i+1]){
				return false;
			}
		}
		return true;
	}

	/******************************************************************
	 * ��Console�д�ӡ����
	 * @param array
	 ******************************************************************/
	public void printArray(ArrayList <BigInteger> array){
		System.out.print("{");
		for(int i = 0;i<array.size();i++){
			System.out.print(array.get(i).toString()+",");
		}
		System.out.println("}");
	}
	
	public void printIntArray(int [] array){
		System.out.print("{");
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println("}");
	}
	
	public void printLongArray(long [] array){
		System.out.print("{");
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println("}");
	}
	
	protected ArrayList <BigInteger> sort(ArrayList <BigInteger> original){
		return new ArrayList <BigInteger>();
	}
	protected int [] sortInt(int [] original){
		return new int [0];
	}
	protected long [] sortLong(long [] original){
		return new long [0];
	}
	
	protected void setName(String name){
		this.name =name;
	}
	protected String getName(){
		return name;
	}
	protected void setSortOriginal(long [] sortOriginal){
		this.sortOriginal =sortOriginal;
	}
	protected long [] getSortOriginal(){
		return sortOriginal;
	}
	protected String name;
	protected long [] sortOriginal; 
	
}
