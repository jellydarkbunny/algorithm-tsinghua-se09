package chessMove;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Test {
	public static void main(String [] args){
		
		int [][] array = getValues(6);
		ChessPiece cp = new ChessPiece();
		ChessPiece [][]cps = cp.initial(array);
		print(cps);
		System.out.println("cps size"+cps.length);
		ChessPiece[][]moved = cp.move(1, 0, cps);
		System.out.println("moved");
		print(moved);
		ChessPiece max = cp.getMax(moved);
		System.out.println("最大的消费："+max.value);
	}
	public static int [][] getValues(int n){
		int [][] result = new int [n][n];
		Random ran = new Random();
		for(int j = n-1;j>=0;j--){
			for(int i=0;i<n;i++ ){
				BigInteger b = new BigInteger(5,ran);
				result [i][j] = b.intValue();
			}
		}
		return result;
		
	}
	public static void print(int [][] array){
		System.out.println("===============");
		for(int j = array.length-1;j>=0;j--){
			for(int i=0;i<array.length;i++ ){
				int value  = array [i][j];
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		System.out.println("=================");
	}
	public static void print(ChessPiece [][] cps){
		System.out.println("===============");
		for(int j = cps.length-1;j>=0;j--){
			System.out.print ("Y"+(j)+":");
			for(int i=0;i<cps.length;i++ ){
				int value  = cps [i][j].value;
				if(value==Integer.MIN_VALUE){
					System.out.print("min\t");
				}else{
					System.out.print(value+"\t");
				}
			}
			System.out.println();
		}
		System.out.println("=================");
	}
	public static ArrayList<Integer> getNumbers(int num){
		Random ran = new Random();
		ArrayList <Integer> array = new ArrayList<Integer>();
		for(int i = 0;i<num;i++){
			BigInteger b = new BigInteger(5,ran);
			array.add(b.intValue());
		}
		return array;
	}
}
