package ordinal;

import java.util.ArrayList;


public class Ordinal {
	
	public Ordinal(){
		fNumbers = new FNumbers();
	}
	public Ordinal(int n){
		this.n= n;
		fNumbers = new FNumbers(n);
	}
	public static int getRemainder(int x,int y){
		return x-x/y*y;
	}
	public int getFactorial(int num){
		int result = 1;
		while(num>1){
			result = result*num;
			num--;
		}
		return result;
	}
	public void printAllPermutation(){
		ArrayList <Integer>result;
		for(int i = 0;i<getFactorial(n)-1;i++){
			result = fNumbers.getPermutationFromFNumber();
			fNumbers.add();
			System.out.print(result+"\t");
		}
	}
	private FNumbers fNumbers;
	private int n;
}
