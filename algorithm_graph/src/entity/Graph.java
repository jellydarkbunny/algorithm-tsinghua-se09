package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**************************************************************
 * G(V,E)
 * 
 * @author Administrator
 *
 */
public class Graph {
	private HashMap <String,Vertex> vertexes;
	private ArrayList <Edge> edges;
	public Graph(){
		vertexes = new HashMap <String,Vertex>();
		edges = new ArrayList <Edge>();
	}
	public String toString(){
		Iterator <Vertex>verterxesIterator = vertexes.values().iterator();
		StringBuilder builder = new StringBuilder();
		while(verterxesIterator.hasNext()){
			builder.append(verterxesIterator.next()+"\t");
		}
		builder.append("\n");
		for(int i = 0;i<edges.size();i++){
			builder.append(edges.get(i));
		}
		builder.append("\n");
		return builder.toString();
	}
	public HashMap<String, Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(HashMap<String, Vertex> vertexes) {
		this.vertexes = vertexes;
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
