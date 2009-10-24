package entity;

public class MyPointPair {
	public MyPointPair(MyPoint p1,MyPoint p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	public void setP1(MyPoint p1){
		this.p1 = p1;
	}
	public MyPoint getP1(){
		return p1;
	}
	public void setP2(MyPoint p2){
		this.p2 = p2;
	}
	public MyPoint getP2(){
		return p2;
	}
	public String toString(){
		return p1+"\t"+p2;
	}
	private MyPoint p1;
	private MyPoint p2;
}
