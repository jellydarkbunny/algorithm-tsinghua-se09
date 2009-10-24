package sorting;

import java.util.ArrayList;

public class RadixSort extends SortingAlgorithmParent{
	public RadixSort(){
		name = "RadixSort";
	}
	public long [] sortLong(long [] original){
		long [] result = subSort(original,1);
		for(int i =2;i<=10;i++){
			result = subSort(result,i);
		}
		return result;
	}

	private long [] subSort(long [] subArray, int index){
		ArrayList<ArrayList<Long>> array1 = new ArrayList<ArrayList<Long>>();
		for(int i=0;i<10;i++){
			array1.add(new ArrayList<Long>());
		}
		long integer;
		for(int i = 0;i<subArray.length;i++){
			integer = subArray[i];
			int a = getSubIndexValue(String.valueOf(integer),index);
			switch (a){
				case 0:
					array1.get(0).add(integer);
					break;
				case 1:
					array1.get(1).add(integer);
					break;
				case 2:
					array1.get(2).add(integer);
					break;
				case 3:
					array1.get(3).add(integer);
					break;
				case 4:
					array1.get(4).add(integer);
					break;
				case 5:
					array1.get(5).add(integer);
					break;
				case 6:
					array1.get(6).add(integer);
					break;
				case 7:
					array1.get(7).add(integer);
					break;
				case 8:
					array1.get(8).add(integer);
					break;
				case 9:
					array1.get(9).add(integer);
					break;
			}
		}
		int resultIndex = 0;
		long [] result = new long [subArray.length];
		for(int i =0;i<=9;i++){
			ArrayList <Long> temp = array1.get(i);
			for(int j = 0;j<temp.size();j++){
				result[resultIndex] = temp.get(j);
				resultIndex++;
			}
		}
		return result;
	}
	//个位的index为1，十位的index为2
	private int getSubIndexValue(String s,int index){
		int length = s.length();
		if(length < index){
			return 0;
		}
		char c = s.charAt(length-index);
		return charToInt(c);
	}
	 
	//change the char into int, 
	//input range is {1,2,3,4,5,6,7,8,9}
	private int charToInt(char c){
		char zero = '0';
		return c-zero;
	}
}
