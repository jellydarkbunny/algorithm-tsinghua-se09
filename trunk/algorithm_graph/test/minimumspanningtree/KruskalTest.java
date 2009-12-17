package minimumspanningtree;

import java.util.ArrayList;
import java.util.HashMap;
import entity.Edge;
import entity.Graph;
import entity.Vertex;

public class KruskalTest {
	@SuppressWarnings("static-access")
	public static void main(String [] args){
		KruskalAlgorithm ka = new KruskalAlgorithm();
		Graph graph = getGraphOne();
		ka.getMST(graph);
	}
	public static Graph getGraphOne(){
		Graph graph = new Graph();
		HashMap <String,Vertex> vertexes= new HashMap <String,Vertex>();
		vertexes.put("a",new Vertex("a"));
		vertexes.put("b",new Vertex("b"));
		vertexes.put("c",new Vertex("c"));
		vertexes.put("d",new Vertex("d"));
		vertexes.put("e",new Vertex("e"));
		vertexes.put("f",new Vertex("f"));
		vertexes.put("g",new Vertex("g"));
		vertexes.put("h",new Vertex("h"));
		vertexes.put("i",new Vertex("i"));
		
		ArrayList <Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(vertexes.get("a"),vertexes.get("b"),4));
		edges.add(new Edge(vertexes.get("a"),vertexes.get("h"),8));
		edges.add(new Edge(vertexes.get("b"),vertexes.get("h"),11));
		edges.add(new Edge(vertexes.get("b"),vertexes.get("c"),8));
		edges.add(new Edge(vertexes.get("h"),vertexes.get("i"),7));
		edges.add(new Edge(vertexes.get("h"),vertexes.get("g"),1));
		edges.add(new Edge(vertexes.get("i"),vertexes.get("c"),2));
		edges.add(new Edge(vertexes.get("i"),vertexes.get("g"),6));
		edges.add(new Edge(vertexes.get("c"),vertexes.get("d"),7));
		edges.add(new Edge(vertexes.get("c"),vertexes.get("f"),4));
		edges.add(new Edge(vertexes.get("g"),vertexes.get("f"),2));
		edges.add(new Edge(vertexes.get("d"),vertexes.get("f"),14));
		edges.add(new Edge(vertexes.get("d"),vertexes.get("e"),9));
		edges.add(new Edge(vertexes.get("e"),vertexes.get("f"),10));
		
		graph.setVertexes(vertexes);
		graph.setEdges(edges);
		return graph;
	}
}
