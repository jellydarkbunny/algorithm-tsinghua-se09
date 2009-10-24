package entity;
public class MyPoint {
	public MyPoint(){
		this.x = 0;
		this.y = 0;
	}
	public MyPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
	public void setX(double x){
		this.x = x;
	}
	public double getX(){
		return x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getY(){
		return y;
	}
	public double getDistance(MyPoint p){
		double x1 = Math.pow((x-p.getX()), 2);
		double y1 = Math.pow((y-p.getY()), 2);
		double distance = Math.sqrt(x1+y1);
		return distance;
	}
	public double getDistance(MyPoint p1, MyPoint p2){
		double x1 = Math.pow((p1.getX()-p2.getX()), 2);
		double y1 = Math.pow((p1.getY()-p2.getY()), 2);
		double distance = Math.sqrt(x1+y1);
		return distance;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	private double x = 0;
	private double y = 0;
}
