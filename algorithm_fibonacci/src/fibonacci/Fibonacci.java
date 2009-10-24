package fibonacci;

import java.math.*;
/*************************************************************
 * This Class contains different kinds of algorithms to solve the 
 * Fibonacci Problem.
 * 
 **************************************************************/
public class Fibonacci {
	
	/**********************************************************
	 * Use F(n+2)=F(n)+F(n+1) F(0)=0 F(1)=1 to solve the Fibonacci problem
	 * @param n  
	 * @return The Nth Fibonacci Number
	 **********************************************************/
	public BigInteger getFibonacciOne(int n){
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger c = new BigInteger("0");
		if(n==0){
			return a;
		}
		if(n==1){
			return b;
		}
		if(n>1){
			for(int i = 0;i<n-1;i++){
				c = b;
				b = b.add(a);
				a = c;
			}
			return b;
		}
		return new BigInteger("0");
	}
	
	/**************************************************************
	 * F(n)=fie^n/sqrt(5)
	 **************************************************************/
	public BigInteger getFibonacciTwo(int n){
		double fie = (1+Math.sqrt(5))/2;
		BigDecimal value = new BigDecimal(fie);
		double c = 1/Math.sqrt(5);
		value = value.pow(n).multiply(new BigDecimal(c));
		BigInteger answer = changeFormat(value);
		return answer;
	}
	
 	/***********************************************************
	 * Using Matrix to solve the Fibonacci
	 * @param n
	 * @return
	 ***********************************************************/
	public BigInteger getFibonacciThree(int n){
		if(n==0){
			return new BigInteger("0");
		}
		Matrix m = new Matrix();
		Matrix value = m.pow(n);
		return value.a2;
	}
	
	/***********************************************************
	 * Use Strassen's way to solve the Matrix, and then get the
	 * Fibonacci problems solved
	 * @param n
	 * @return
	 **********************************************************/
	public BigInteger getFibonacciFour(int n){
		if(n==0){
			return new BigInteger("0");
		}
		Matrix m = new Matrix();
		Matrix value = m.pow(n);
		return value.a2;
	}
 	
	//change the decimal into the nearest integer.
	public BigInteger changeFormat(BigDecimal decimal){
		BigInteger temp = decimal.toBigInteger();
		BigDecimal compare = (new BigDecimal(temp)).add(new BigDecimal(0.5));
		if(decimal.compareTo(compare)==1){
			return temp.add(new BigInteger("1"));
		}
		return temp;
	}
	
	public int changeFormat(double d){
		int temp = (int) d;
		double compare = 0.5+temp;		
		if(compare<=d){
			return temp+1;
		}
		return temp;
	}
	
}
