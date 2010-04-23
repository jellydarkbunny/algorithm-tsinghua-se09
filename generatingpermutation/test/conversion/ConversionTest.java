package conversion;

import java.util.ArrayList;

public class ConversionTest {
	public static void main(String []args){
		
		testN();
	}
	public static void testN(){
		Conversion con = new Conversion(6);
		con.getPermutation();
	}
	public static void testGetPermutation(){
		Conversion con = new Conversion();
		con.getPermutation();
	}
	public static void testAddSons(){
		ConversionNode root = new ConversionNode();
		ArrayList<Integer> elements = new ArrayList<Integer>();
		elements.add(1);
		root.setElements(elements);
		
		
		root.addSons();
		ArrayList<ConversionNode> test = root.getSons();
		root.getSons().get(0).addSons();
		root.getSons().get(1).addSons();
		ArrayList<ConversionNode> ma = root.getSons().get(0).getSons();
		for(int i = 0;i<ma.size();i++){
			System.out.println(ma.get(i));
		}
		System.out.println(test.size());
	}
}
