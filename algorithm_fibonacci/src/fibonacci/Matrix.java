package fibonacci;
import java.math.BigInteger;


public class Matrix {
	public Matrix(){
		this.a1 = new BigInteger("1");
		this.a2 = new BigInteger("1");
		this.b1 = new BigInteger("1");
		this.b2 = new BigInteger("0");
	}
	public Matrix(BigInteger a1, BigInteger a2, BigInteger b1,BigInteger b2){
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
		this.b2 = b2;
	}
	// a1 a2  
	// b1 b2  
	public Matrix multiply(Matrix m){
		Matrix result = new Matrix();
		result.a1 = a1.multiply(m.a1).add(a2.multiply(m.b1));
		result.a2 = a1.multiply(m.a2).add(a2.multiply(m.b2));
		result.b1 = b1.multiply(m.a1).add(b2.multiply(m.b1));
		result.b2 = b1.multiply(m.a2).add(b2.multiply(m.b2));
		return result;
	}
	public Matrix multiplyStrassen(Matrix m){
		BigInteger p1 = a1.multiply(m.a2.subtract(m.b2));
		BigInteger p2 = a1.add(a2).multiply(m.b2);
		BigInteger p3 = b1.add(b2).multiply(m.a1);
		BigInteger p4 = b2.multiply(m.b1.subtract(m.a1));
		BigInteger p5 = a1.add(b2).multiply(m.a1.add(m.b2));
		BigInteger p6 = a2.subtract(b2).multiply(m.b1.add(m.b2));
		BigInteger p7 = a1.subtract(b1).multiply(m.a1.add(m.a2));
		Matrix result = new Matrix();
		result.a1 = p5.add(p4).subtract(p2).add(p6);
		result.a2 = p1.add(p2);
		result.b1 = p3.add(p4);
		result.b2 = p5.add(p1).subtract(p3).subtract(p7);
		return result;
	}
	public Matrix pow(int n){
		Matrix m = new Matrix(a1,a2,b1,b2);
		if(n==1){
			return m;
		}
		if(n==2){
			return m.multiply(this);
		}
		return m.pow(n/2).multiply(m.pow(n-n/2));
	}
	public Matrix powStrassen(int n){
		Matrix m = new Matrix(a1,a2,b1,b2);
		if(n==1){
			return m;
		}
		if(n==2){
			return m.multiplyStrassen(this);
		}
		return m.powStrassen(n/2).multiplyStrassen(m.powStrassen(n-n/2));
	}
	public String toString(){
		String s = a1+","+a2+","+b1+","+b2;
		return s;
	}
 

	public BigInteger a1;
	public BigInteger a2;
	public BigInteger b1;
	public BigInteger b2;
}
