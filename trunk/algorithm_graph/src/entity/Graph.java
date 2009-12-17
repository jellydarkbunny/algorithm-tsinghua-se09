package entity;

import java.util.ArrayList;
import java.util.HashMap;

/**************************************************************
 * G(V,E)
 * 
 * @author Administrator
 *
 */
public class Graph {
	private HashMap<Integer,Vertex> vertexes;
	private ArrayList <Edge> edges;
	private int [][]matrix;
	public Graph(){
		vertexes = new HashMap<Integer,Vertex>();
		edges = new ArrayList <Edge>();
	}
	//initialize the matrix.
	@SuppressWarnings("unused")
	private void intiMatrix(){
		int size = vertexes.size();
		matrix= new int[size][size];
		for(int i = 0;i<edges.size();i++){
			Edge edge = edges.get(i);
			int from = edge.getFromVertex().getId();
			int to = edge.getToVertex().getId();
			matrix[from][to]=1;
		}
	}
	
	 
	/**
	 * @param edges the edges to set
	 */
	public void setEdges(ArrayList <Edge> edges) {
		this.edges = edges;
	}
	/**
	 * @return the edges
	 */
	public ArrayList <Edge> getEdges() {
		return edges;
	}
	
}
