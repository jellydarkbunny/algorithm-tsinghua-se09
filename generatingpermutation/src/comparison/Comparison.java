package comparison;

import ordinal.Ordinal;
import conversion.Conversion;
import dictionary.Dictionary;

public class Comparison {
	public static void main(String [] args){
		timeComparison();
	}
	//compare the time among three methods
	public static void timeComparison(){
		// do nothing, just let the CPU run and it will be more
		// fair for the comparison
		for(int i = 0;i<10000;i++){
			
		}
		System.out.println("得到排列并打印所有排列的耗时比较");
		for (int i = 4;i<=6;i++){
			System.out.println("n="+i+"的时候");
			
			Conversion con = new Conversion(i);
			Dictionary dic = new Dictionary(i);
			Ordinal ord= new Ordinal(i);
			
			long start = 0;
			long end =0;
			System.out.println("==================================================================");
			start = System.nanoTime();
			con.printAllPermutation();
			end = System.nanoTime();
			System.out.println("\n换位法打印耗时:"+(end-start)+"ns");
			start = System.nanoTime();
			dic.printAllPermutation();
			end = System.nanoTime();
			System.out.println("\n字典法打印耗时:"+(end-start)+"ns");
			start = System.nanoTime();
			ord.printAllPermutation();
			end = System.nanoTime();
			System.out.println("\n序数法打印耗时:"+(end-start)+"ns");
			System.out.println("==================================================================");
			
		}
		
	}
}
