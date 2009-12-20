package entity;

public class Vertex {
	protected String name;
	public Vertex(){
	}
	public Vertex(String name){
		this.name = name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	 
	
	public String toString(){
		return name;
	}
	 
}
