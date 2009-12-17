package minimumspanningtree;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Edge;
import entity.Graph;
import entity.Vertex;
//需要加入不相交集合数据结构
public class KruskalAlgorithm {
	public static Graph getMST(Graph graph){
		System.out.println(graph.getEdges());
		ArrayList<Edge> sortedEdges = getSoredEdge(graph.getEdges());
		Graph mst = new Graph();
		HashMap <Integer,Vertex> vertexes= new HashMap <String,Vertex>();
		HashMap<Integer,Edge> edges = new HashMap<Integer,Edge>();
		int index = 0;
		while(vertexes.size()<graph.getVertexes().size()&&index<sortedEdges.size()){
			Edge temp = sortedEdges.get(index);
			Vertex v1 = temp.getFromVertex();
			Vertex v2 = temp.getToVertex();
			if(vertexes.containsValue(v1)&&vertexes.containsValue(v2)){
				index++;
				continue;
			}else if(vertexes.containsValue(v1)){
				vertexes.keySet()vertexes.get(arg0)
				vertexes.put(v1.getName(), v2);
				edges.put(temp);
				index++;
				continue;
			}else if(vertexes.containsValue(v2)){
				vertexes.put(v1.getName(), v1);
				edges.add(temp);
				index++;
				continue;
			}else{
				vertexes.put(index, v1);
				vertexes.put(index, v2);
				edges.add(temp);
				index++;
				continue;
			}
		}
		mst.setEdges(edges);
		mst.setVertexes(vertexes);
		System.out.println(sortedEdges);
		System.out.println(mst);
		return mst;
	}
	public static ArrayList <Edge> getSoredEdge(ArrayList <Edge> edges){
		ArrayList<Edge> temp = edges;
		ArrayList<Edge> result = new ArrayList<Edge>();
		while(!temp.isEmpty()){
			int tempWeight = Integer.MAX_VALUE;
			int index = 0;
			for(int i= 0;i<temp.size();i++){
				if(tempWeight>temp.get(i).getWeight()){
					tempWeight = temp.get(i).getWeight();
					index = i;
				}
			}
			result.add(temp.get(index));
			temp.remove(index);
		}
		return result;
	}
}
