package fibonacci;
import java.math.BigInteger;
public class TestFibonacci {
	
	//0,1,1,2,3,5,8,13,21,34......
	public static void main (String [] args){
		int n = 30000;
		compareDifferentAlgorithm(n);
		//testFieProblem();
	}
	
	public static void compareDifferentAlgorithm(int n){
		Fibonacci f = new Fibonacci();
		int j = 0;
		for(int i =0;i<100000;i++){
			j++;
		}

		long start1ms = System.currentTimeMillis();
		long start1 = System.nanoTime();
		BigInteger a = f.getFibonacciOne(n);
		long end1 = System.nanoTime();
		long end1ms = System.currentTimeMillis();
		if((end1ms - start1ms) == 0.0){
			System.out.println("第一种算法运行时间为 :"+(end1-start1)+"ns");
		}else{
			System.out.println("第一种算法运行时间为 :"+(end1ms-start1ms)+"ms");
		}
		
		long start2ms = System.currentTimeMillis();
		long start2 = System.nanoTime();
		BigInteger b = f.getFibonacciThree(n);
		long end2 = System.nanoTime();
		long end2ms = System.currentTimeMillis();
		if((end2ms-start2ms)==0.0){
			System.out.println("第二种算法运行时间为 :"+(end2-start2)+"ns");
		}else{
			System.out.println("第二种算法运行时间为 :"+(end2ms-start2ms)+"ms");
		}
		 
		long start3ms = System.currentTimeMillis();
		long start3 = System.nanoTime();
		BigInteger c = f.getFibonacciFour(n);
		long end3 = System.nanoTime();
		long end3ms = System.currentTimeMillis();
		if((end3ms - start3ms) == 0.0){
			System.out.println("第三种算法运行时间为 :"+(end3-start3)+"ns");
		}else{
			System.out.println("第三种算法运行时间为 :"+(end3ms-start3ms)+"ms");
		}
		if(a.compareTo(b)==0){
			if(b.compareTo(c)==0){
				System.out.println("3个算法结果相同.");
			}
		}
	}
	
	//compare the results of FibonacciOne and FibonacciTwo
	public static void testFieProblem(){
		Fibonacci f = new Fibonacci();
		int i = 0;
		BigInteger big1 = new BigInteger("0");
		BigInteger big2 = new BigInteger("0");
		while(true){
			big1 = f.getFibonacciOne(i);
			big2 = f.getFibonacciTwo(i);
			if(big1.compareTo(big2)==0){
				i++;
			}
			if(big1.compareTo(big2)!=0){
				System.out.println("F("+i+") is not right. And all the numbers after this are not right");
				break;
			}
		}
	}
}
