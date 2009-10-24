package lis;

import java.util.ArrayList;
public class Test {
	public static void main(String[] args){
		int [] array = {1,2,4,3,5,6,9,7,8};
		int [] test1 = {1,2,3,4,5};
		int [] test2 = {1,2,5,4,3};
		int [] test3 = {1,2,7,8,3,4,5};
		//LisAlgorithm algorithm = new LisN2();
		LisAlgorithm algorithm = new LisNLgN();
		run(array,algorithm);
		run(test1,algorithm);
		run(test2,algorithm);
		run(test3,algorithm);
	}
	public static void run(int [] array,LisAlgorithm algorithm){
		String s ="a[n]:"+ algorithm.arrayToString(array);
		System.out.println(s);
		int longest = algorithm.getLongestLength(array);
 		algorithm.getRecords(array,algorithm.getLengthRecords(),longest);
	}
	 
	
	public static ArrayList  <int []>testArray(){
		ArrayList <int []> tests = new ArrayList<int []>();
		int [] test1 = {1,2,3,4,5};
		int [] test2 = {1,2,5,4,3};
		int [] test3 = {4,5,1,2,3};
		tests.add(test1);
		tests.add(test2);
		tests.add(test3);
		return tests;
	}
}
