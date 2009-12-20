package minimumspanningtree;
import entity.Vertex;
import java.util.HashMap;
public class DisjointSet {
	private int label;
	private HashMap<String,Vertex> vertexes;
	public DisjointSet(int label){
		this.label = label;
		vertexes = new HashMap<String,Vertex>();
	}
	public void union(DisjointSet set){
		HashMap<String,Vertex> temp = set.getVertexes();
		for(Vertex vertex:temp.values()){
			vertexes.put(vertex.getName(),vertex);
		}
	}
	public Vertex find(Vertex vertex){
		return vertexes.get(vertex.getName());
	}
	public void addVertex(Vertex vertex){
		vertexes.put(vertex.getName(),vertex);
	}
	public HashMap<String, Vertex> getVertexes() {
		return vertexes;
	}
	public void setVertexes(HashMap<String, Vertex> vertexes) {
		this.vertexes = vertexes;
	}
	
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	} 

}