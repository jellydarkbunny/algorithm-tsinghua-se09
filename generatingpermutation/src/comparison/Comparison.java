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
		System.out.println("�õ����в���ӡ�������еĺ�ʱ�Ƚ�");
		for (int i = 4;i<=6;i++){
			System.out.println("n="+i+"��ʱ��");
			
			Conversion con = new Conversion(i);
			Dictionary dic = new Dictionary(i);
			Ordinal ord= new Ordinal(i);
			
			long start = 0;
			long end =0;
			System.out.println("==================================================================");
			start = System.nanoTime();
			con.printAllPermutation();
			end = System.nanoTime();
			System.out.println("\n��λ����ӡ��ʱ:"+(end-start)+"ns");
			start = System.nanoTime();
			dic.printAllPermutation();
			end = System.nanoTime();
			System.out.println("\n�ֵ䷨��ӡ��ʱ:"+(end-start)+"ns");
			start = System.nanoTime();
			ord.printAllPermutation();
			end = System.nanoTime();
			System.out.println("\n��������ӡ��ʱ:"+(end-start)+"ns");
			System.out.println("==================================================================");
			
		}
		
	}
}
