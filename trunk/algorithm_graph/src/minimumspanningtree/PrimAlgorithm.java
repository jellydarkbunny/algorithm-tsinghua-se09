package minimumspanningtree;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Edge;
import entity.Graph;
import entity.Vertex;

public class PrimAlgorithm {
	public static Graph getMST(Graph graph){
		//ArrayList<Edge> oriEdges= graph.getEdges();
		ArrayList<Edge> edges =new ArrayList<Edge> ();
		HashMap <String,Vertex> vertexes = new HashMap <String,Vertex>();
		
		
		return new Graph(vertexes,edges);
	}
	public static boolean hasVertex(HashMap <String,Vertex> vertexes, Vertex vertex){
		return vertexes.containsKey(vertex.getName());
	}
}
