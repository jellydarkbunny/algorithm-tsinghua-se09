package entity;

public class Edge {
	private Vertex fromVertex;
	private Vertex toVertex;
	public Edge(){
		
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
}
