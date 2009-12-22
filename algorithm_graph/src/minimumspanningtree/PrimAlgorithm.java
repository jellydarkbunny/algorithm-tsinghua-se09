package minimumspanningtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import datastructure.PrimVertex;
import datastructure.heap.MinPriorityQueue;

import entity.Edge;
import entity.Graph;
import entity.Vertex;

public class PrimAlgorithm {
	public static Graph getMST(Graph graph){
		ArrayList<Edge> oriEdges= graph.getEdges();
		HashMap <String,PrimVertex> primVertexes = new HashMap<String,PrimVertex>();
		Collection <Vertex> c = graph.getVertexes().values();
		for(Vertex v:c){
			PrimVertex pv = new PrimVertex(v);
			primVertexes.put(pv.getName(), pv);
		}

		MinPriorityQueue minQueue = new MinPriorityQueue();
		Iterator <PrimVertex>it = primVertexes.values().iterator();
		if(it.hasNext()){
			PrimVertex p = it.next();
			p.setSelected(true);
			primVertexes.put(p.getName(), p);
			ArrayList <Edge> tempEdges = getEdgesByVertex(oriEdges,p.toVertex());
			minQueue.buildMinHeap(tempEdges);
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int num = 1;
		int vertexSize =primVertexes.size();
		while(num<=vertexSize){
			//add edges to the queue
			//System.out.println("visited vertexes num:"+num);
			//System.out.println("oriEdges size:"+oriEdges.size());
			//System.out.println("minQueue size:"+minQueue.size());
			//System.out.println("heap queue:"+minQueue);
			//System.out.println("mst tree "+edges);
			if(minQueue.size()==0){
				break;
			}
			Edge edge = minQueue.extractMinimum();
			Vertex v1 = edge.getFromVertex();
			Vertex v2 = edge.getToVertex();
			PrimVertex p  = null;
			boolean b1 = primVertexes.get(v1.getName()).isSelected();
			boolean b2 = primVertexes.get(v2.getName()).isSelected();
			if(b1 && b2){
				continue;
			}else{
				if(b1){
					p = primVertexes.get(v2.getName());
				}else if(b2){
					p = primVertexes.get(v1.getName());
				}
				edges.add(edge);
				ArrayList <Edge> tempEdges = getEdgesByVertex(oriEdges,p.toVertex());
				try{
					minQueue.insertEdges(tempEdges);
				}catch(Exception e){
					e.printStackTrace();
				}
				num++;
				primVertexes.get(p.getName()).setSelected(true);
				primVertexes.put(p.getName(), p);
			}
		}
		System.out.println("PRIM ALGORITHM");
		System.out.println("mst vertex num"+graph.getVertexes().size());
		System.out.println("mst vertex"+graph.getVertexes());
		System.out.println("mst tree size"+edges.size());
		System.out.println("mst tree "+edges);
		return new Graph(graph.getVertexes(),edges);
	}
	public static boolean hasVertex(HashMap <String,Vertex> vertexes, Vertex vertex){
		return vertexes.containsKey(vertex.getName());
	}
	public static ArrayList<Edge> getEdgesByVertex(ArrayList<Edge> oriEdges, Vertex vertex){
		ArrayList<Edge> tempEdges = new ArrayList<Edge>();
		int i = 0;
		while(i<oriEdges.size()){
			Edge temp = oriEdges.get(i);
			if(temp.containVertex(vertex)){
				tempEdges.add(new Edge(temp.getFromVertex(),temp.getToVertex(),temp.getWeight()));
				oriEdges.remove(i);
				i--;
			}
			i++;
		}
		return tempEdges;
	}
	
}
