package datastructure.heap;

import java.util.ArrayList;

import entity.Edge;

public class MinPriorityQueue {
	private ArrayList<Edge>edges;
	public MinPriorityQueue(){
		
	}
	public MinPriorityQueue(ArrayList <Edge> edges){
		buildMinHeap(edges);
	}
	public String toString(){
		return edges.toString();
	}
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	public boolean isEmpty(){
		return edges.isEmpty();
	}
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	public void insertEdges(ArrayList<Edge> newEdges)throws HeapException{
		for(Edge edge:newEdges){
			insert(edge);
		}
	}
	public boolean insert(Edge edge) throws HeapException{
		Edge newEdge = new Edge(edge.getFromVertex(),edge.getToVertex(),Integer.MAX_VALUE);
		edges.add(newEdge);
		decreaseEdgeWeight(newEdge,edge.getWeight());
		return false;
	}
	public void buildMinHeap(ArrayList<Edge> oriEdges){
		this.edges = oriEdges;
		for(int i = edges.size()/2-1;i>=0;i--){
			minHeapify(i);
		}
	}
	private void minHeapify(int index){
		int minIndex = index;
		int left = getLeftIndex(index);
		int right = getRightIndex(index);
		Edge parentEdge = edges.get(index);
		if(left < edges.size()){
			Edge leftEdge =edges.get(left);
			if(leftEdge.getWeight()<parentEdge.getWeight()){
			minIndex = left;
			}else{
				minIndex = index;
			}
		}
		if(right < edges.size()){
			Edge rightEdge = edges.get(right);
			if(rightEdge.getWeight()<edges.get(minIndex).getWeight()){
				minIndex = right;
			}
		}
		if(minIndex!=index){
			edges.set(index, edges.get(minIndex));
			edges.set(minIndex, parentEdge);
			minHeapify(minIndex);
		}
	}
	public Edge getMinimum(){
		return edges.get(0);
	}
	public Edge extractMinimum(){
		Edge edge = edges.get(0);
		int lastIndex = edges.size()-1;
		if(lastIndex>0){
			edges.set(0, edges.get(lastIndex));
			edges.remove(lastIndex);
			minHeapify(0);
		}else{
			edges.remove(lastIndex);
		}
		return edge;
	}
	public void decreaseEdgeWeight(Edge edge,int weight)throws HeapException{
		int edgeIndex = edges.indexOf(edge);
		if(edge.getWeight()<weight){
			throw new HeapException("new key is larger than the weight");
		}
		edges.get(edgeIndex).setWeight(weight);
		while(true){
			if(edgeIndex<=0){
				break;
			}
			Edge e1 = edges.get(getParentIndex(edgeIndex));
			Edge e2 = edges.get(edgeIndex);
			if(e1.compareTo(e2)!=1){
				break;
			}
			//do exchange
			edges.set(getParentIndex(edgeIndex), e2);
			edges.set(edgeIndex, e1);
			edgeIndex = getParentIndex(edgeIndex);
		}
	}
	
	//return the index of the array list which starts from 0
	private int getParentIndex(int index){
		return (index+1)/2-1;
	}
	private int getLeftIndex(int index){
		return 2*(index+1)-1;
	}
	private int getRightIndex(int index){
		return 2*(index+1);
	}
	public static void main(String[]args){
		int i = 20;
		int b = 2;
		System.out.println(i/b);
	}
	public int size(){
		return edges.size();
	}
}
