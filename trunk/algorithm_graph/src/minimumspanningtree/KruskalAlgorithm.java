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
		HashMap <String,Vertex> vertexes= new HashMap <String,Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int index = 0;
		HashMap<Integer,DisjointSet> forest= new HashMap<Integer,DisjointSet>();
		while(true){
			if(vertexes.size()==graph.getVertexes().size()){
				if(forest.size()==1){
					break;
				}
			}
			Edge temp = sortedEdges.get(index);
			Vertex v1 = temp.getFromVertex();
			Vertex v2 = temp.getToVertex();
			int v1Index = findSet(forest,v1);
			int v2Index = findSet(forest,v2);
			if(v1Index==-1 && v2Index==-1){
				DisjointSet ds = new DisjointSet(index);
				ds.addVertex(v1);
				ds.addVertex(v2);
				vertexes.put(v1.getName(),v1);
				vertexes.put(v2.getName(),v2);
				forest.put(index, ds);
				edges.add(temp);
				index++;
				continue;
			}else if(v1Index==-1){
				DisjointSet ds2 = forest.get(v2Index);
				ds2.addVertex(v1);
				vertexes.put(v1.getName(),v1);
				forest.put(ds2.getLabel(), ds2);
				edges.add(temp);
				index++;
				continue;
			}else if(v2Index==-1){
				DisjointSet ds1 = forest.get(v1Index);
				ds1.addVertex(v2);
				vertexes.put(v2.getName(),v2);
				forest.put(ds1.getLabel(), ds1);
				edges.add(temp);
				index++;
				continue;
			}else if(v1Index==v2Index){
				index++;
				continue;
			}else {
				DisjointSet ds1 = forest.get(v1Index);
				DisjointSet ds2 = forest.get(v2Index);
				ds1.union(ds2);
				forest.put(ds1.getLabel(), ds1);
				forest.remove(ds2.getLabel());
				edges.add(temp);
				index++;
				continue;
			}
		}
		mst.setEdges(edges);
		mst.setVertexes(vertexes);
		System.out.println(mst);
		return mst;
	}
	public static int findSet(HashMap<Integer,DisjointSet> forest,Vertex vertex){
		for(DisjointSet ds:forest.values()){
			if(ds.getVertexes().containsKey(vertex.getName())){
				return ds.getLabel();
			}
		}
		return -1;
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
