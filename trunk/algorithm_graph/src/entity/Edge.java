package entity;

public class Edge {
	private Vertex fromVertex;
	private Vertex toVertex;
	private int weight;
	public Edge(){
		
	}
	public Edge(Vertex fromVertex,Vertex toVertex,int weight){
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.weight = weight;
	}
	public Edge(Vertex from,Vertex to){
		this.fromVertex = from;
		this.toVertex = to;
	}
	public Vertex getFromVertex() {
		return fromVertex;
	}
	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}
	public Vertex getToVertex() {
		return toVertex;
	}
	public void setToVertex(Vertex toVertex) {
		this.toVertex = toVertex;
	}
	public String toString(){
		return fromVertex+"-"+weight+"-"+toVertex+"\t";
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
}
