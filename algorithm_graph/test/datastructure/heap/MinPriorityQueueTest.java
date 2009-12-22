package datastructure.heap;

import java.util.ArrayList;

import entity.Edge;
import entity.Vertex;

public class MinPriorityQueueTest {
	public static void main(String []args) throws HeapException{
		insertEdgeTest();
	}
	public static void insertEdgeTest() throws HeapException{
		ArrayList <Edge> edges = getEdges();
		printEdgesWeight(edges);
		MinPriorityQueue  mpq = new MinPriorityQueue(edges);
		printEdgesWeight(mpq.getEdges());
		Edge min = mpq.extractMinimum();
		System.out.println(min.getWeight());
		printEdgesWeight(mpq.getEdges());
		mpq.insert(new Edge(new Vertex(),new Vertex(),1));
		printEdgesWeight(mpq.getEdges());
		
	}
	public static void extractMinTest(){
		ArrayList <Edge> edges = getEdges();
		printEdgesWeight(edges);
		MinPriorityQueue  mpq = new MinPriorityQueue(edges);
		printEdgesWeight(mpq.getEdges());
		Edge min = mpq.extractMinimum();
		System.out.println(min.getWeight());
		printEdgesWeight(mpq.getEdges());
	}
	public static void buildHeapTest(){
		ArrayList <Edge> edges = getEdges();
		printEdgesWeight(edges);
		MinPriorityQueue  mpq = new MinPriorityQueue(edges);
		printEdgesWeight(mpq.getEdges());
	}
	public static ArrayList<Edge> getEdges(){
		ArrayList <Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(new Vertex(),new Vertex(),10));
		edges.add(new Edge(new Vertex(),new Vertex(),9));
		edges.add(new Edge(new Vertex(),new Vertex(),8));
		edges.add(new Edge(new Vertex(),new Vertex(),7));
		edges.add(new Edge(new Vertex(),new Vertex(),6));
		edges.add(new Edge(new Vertex(),new Vertex(),5));
		edges.add(new Edge(new Vertex(),new Vertex(),4));
		edges.add(new Edge(new Vertex(),new Vertex(),3));
		edges.add(new Edge(new Vertex(),new Vertex(),2));
		edges.add(new Edge(new Vertex(),new Vertex(),1));
		
		return edges;
	}
	private static void printEdgesWeight(ArrayList <Edge> edges){
		for(Edge edge:edges){
			System.out.print(edge.getWeight()+"\t");
		}
		System.out.println();
	}
}
