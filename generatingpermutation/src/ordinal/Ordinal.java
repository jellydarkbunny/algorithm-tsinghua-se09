package ordinal;

import java.util.ArrayList;

public class Ordinal {
	public static int getN(int n,int i){
		return n/(i+1);
	}
	public static int getRemainder(int x,int y){
		return x-x/y*y;
	}

	public Ordinal(){
		fNumbers = new FNumbers();
	}
	public static void main(String []args){
		int x = 166;
		int y = 4;
		System.out.println(getN(x,y));
	}
	private FNumbers fNumbers;
}
