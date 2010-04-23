package conversion;

import java.util.ArrayList;

public class Conversion {
	public Conversion(){
		n = 4;
		init();
	}
	public Conversion(int n){
		this.n = n;
		init();
	}
	private void init(){
		//set the root node
		root = new ConversionNode();
		ArrayList<Integer> elements = new ArrayList<Integer>();
		elements.add(1);
		root.setElements(elements);
		root.setDirection("rightToleft");
	}
	public void printAllPermutation(){
		ArrayList<ConversionNode> nodes = getPermutation();
		for(int i = 0;i<nodes.size();i++){
			System.out.print(nodes.get(i)+"\t");
		}
	}
	//get All permuattion using a queue
	public ArrayList<ConversionNode> getPermutation(){
		ArrayList<ConversionNode> nodes= new ArrayList<ConversionNode>();
		nodes.add(root);
		while(nodes.get(0).getElements().size()<n){
			nodes.get(0).addSons();
			ArrayList<ConversionNode> temps = nodes.get(0).getSons();
			for(int i = 0;i<temps.size();i++){
				nodes.add(temps.get(i));
			}
			nodes.remove(0);
		}
		return nodes;
	}
	private ConversionNode root;
	private int n ;
}
