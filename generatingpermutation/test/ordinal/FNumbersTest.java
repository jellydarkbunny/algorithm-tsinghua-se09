package ordinal;

public class FNumbersTest {
	public static void main(String[]args){
		testGetPermutationFromFNumber();
		
	}
	public static void testGetPermutationFromFNumber(){
		FNumbers f =new FNumbers();
		for(int i =0;i<20;i++){
			System.out.print(f.toString());
			f.getPermutationFromFNumber();
			f.add();
		}
	}
	public static void testGetFNumbersFromNaturalNum(){
		for(int i =0;i<20;i++){
			FNumbers f =new FNumbers();
			System.out.println(f.getFNumbersFromNaturalNum(i));
		}
	}
	public static void testFNumberAdd(){
		FNumbers f = new FNumbers();
		for(int i = 0;i<10;i++){
			System.out.println(f);
			f.add();
		}
	}
}
