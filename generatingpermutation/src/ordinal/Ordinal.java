package ordinal;

import java.util.ArrayList;

public class Ordinal {
	public static int[] getAnFromIndex(int n,int index){
		int ns[]=new int[n];
		int rs[]=new int[n];
		ns[0]=index;
		for(int i = 1;i<n;i++){
			ns[i]=getN(ns[i-1],i);
			rs[i]=getRemainder(ns[i-1],i);
		}
		return rs;
	}
	public static int getN(int n,int i){
		return n/(i+1);
	}
	
	public static int getRemainder(int x,int y){
		return x-x/y*y;
	}
	
	public static void main(String []args){
		int x = 166;
		int y = 4;
		System.out.println(getN(x,y));
	}
}
