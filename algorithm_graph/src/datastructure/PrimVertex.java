package datastructure;
import entity.Vertex;

public class PrimVertex extends Vertex{
	private boolean selected;
	
	public PrimVertex(Vertex vertex){
		selected = false;
		this.name = vertex.getName();
	}
	
	public Vertex toVertex(){
		return new Vertex(name);
	}
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
