package conversion;

import java.util.ArrayList;

public class ConversionNode {
	public ConversionNode(){
		elements = new ArrayList<Integer>();
		direction = "rightToleft";
		sons = new ArrayList<ConversionNode>();
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for(int i = 0;i < elements.size();i++){
			sb.append(elements.get(i)+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return sb.toString();
	}
	public String getNodeDetails(){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < elements.size();i++){
			sb.append(elements.get(i)+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("\t"+direction+"\tsons:"+sons.size());
		
		return sb.toString();
	}
	public void addSons(){
		int n = elements.size()+1;
		if(direction.equals( "rightToleft")){
			boolean flag = false;
			for(int i = n-1;i>=0;i--){
				ConversionNode node = new ConversionNode();
				node.setParent(this);
				if(flag){
					node.setDirection("leftToright");
				}
				flag = !flag;
				elements.add(i, n);
				node.setElements(elements);
				elements.remove(i);
				sons.add(node);
			}
		}else{
			boolean flag = true;
			for(int i =0;i<n;i++){
				ConversionNode node = new ConversionNode();
				node.setParent(this);
				if(flag){
					node.setDirection("leftToright");
				}
				flag = !flag;
				elements.add(i, n);
				node.setElements(elements);
				elements.remove(i);
				sons.add(node);
			}
		}
	}
	public void setElements(ArrayList<Integer>elements){
		this.elements.clear();
		for(int i = 0;i<elements.size();i++){
			this.elements.add(elements.get(i));
		}
	}
	public ArrayList<Integer> getElements(){
		return elements;
	}
	public void setParent(ConversionNode parent){
		this.parent = parent;
	}
	public ConversionNode getParent(){
		return parent;
	}
	public void setDirection (String direction){
		this.direction = direction;
	}
	public ArrayList<ConversionNode> getSons(){
		return sons;
	}
	public String getElementsString(){
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for(int i = 0;i<elements.size();i++){
			sb.append(elements.get(i)+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return sb.toString();
	}
	private ArrayList<Integer> elements;
	private String direction;
	private ConversionNode parent;
	private ArrayList<ConversionNode> sons;
}
