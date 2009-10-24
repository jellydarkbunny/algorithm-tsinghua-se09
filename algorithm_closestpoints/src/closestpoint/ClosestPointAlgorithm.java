package closestpoint;

import java.util.ArrayList;

import entity.MyPoint;
import entity.MyPointPair;
/********************************************************************
 * Overview: This is the Super Class of the algorithms for the closest
 * points problems.
 * 
 * @author william
 *
 ********************************************************************/
public class ClosestPointAlgorithm {
	public ClosestPointAlgorithm(){
		pointPairs = new ArrayList<MyPointPair>();
		closestDistance = Double.MAX_VALUE;
		name = "Algorithm";
	}
	/**********************************************************************
	 * Request: A list of points
	 * @param points
	 * @return the closest distance between two points among those given points 
	 ***********************************************************************/
	public double getClosestDistance(ArrayList <MyPoint> points){
		return 0;
	}
	public double getClosestDistanceWithoutRecordingPointPairs(ArrayList <MyPoint> points){
		return 0;
	}
	/**********************************************************************
	 * Request: A list of points
	 * @param points
	 * @return A list of points sorted by X value
	 **********************************************************************/
	public ArrayList <MyPoint> mergeSortByX(ArrayList <MyPoint> points){
		int size = points.size();
		if(size==1){
			return points;
		}
		if(size==0){
			return points;
		}
		ArrayList <MyPoint>x1 = new ArrayList<MyPoint>();
		ArrayList <MyPoint>x2 = new ArrayList<MyPoint>();
		for(int i = 0;i<size/2;i++){
			x1.add(points.get(i));
		}
		for(int i = size/2;i<size;i++){
			x2.add(points.get(i));
		}
		ArrayList <MyPoint> x1List = mergeSortByX(x1);
		ArrayList <MyPoint> x2List = mergeSortByX(x2);
		ArrayList <MyPoint>xList = new ArrayList<MyPoint>();
		int i =0;
		int j =0;
		int x1Size = x1List.size();
		int x2Size = x2List.size();
		while(true){
			if(i==x1Size){
				if(j==x2Size){
					break;
				}
				xList.add(x2List.get(j));
				j++;
				continue;
			}
			if(j==x2Size){
				if(i==x1Size){
					break;
				}
				xList.add(x1List.get(i));
				i++;
				continue;
			}
			if(x1List.get(i).getX()<=x2List.get(j).getX()){
				xList.add(x1List.get(i));
				i++;
				continue;
			}
			if(x1List.get(i).getX()>x2List.get(j).getX()){
				xList.add(x2List.get(j));
				j++;
				continue;
			}
			
		}
		return xList;
	}	
	//Sort the points by the x axis value
	private ArrayList <MyPoint> getNewList(ArrayList <MyPoint> points){
		ArrayList <MyPoint> list = new ArrayList<MyPoint> ();
		for(int i = 0;i<points.size();i++){
			list.add(points.get(i));
		}
		return list;
	}
	
	public ArrayList <MyPoint> sortByX(ArrayList <MyPoint> points){
		ArrayList <MyPoint> value = new ArrayList<MyPoint>();
		ArrayList <MyPoint> ps = getNewList(points);
		int size = points.size();
		int index;
		for(int i =0;i<size;i++){
			index = getMinXPointIndex(ps);
			MyPoint p = ps.get(index);
			value.add(p);
			ps.remove(index);
		}
		return value;
	}
	public ArrayList <MyPoint> sortByY(ArrayList <MyPoint> points){
		ArrayList <MyPoint> value = new ArrayList <MyPoint>();
		ArrayList <MyPoint> ps = getNewList(points);
		int size = points.size();
		int index;
		for(int i = 0;i<size;i++){
			index = getMinYPointIndex(ps);
			value.add(ps.get(index));
			ps.remove(index);
		}
		return value;
	}
	private int getMinXPointIndex(ArrayList <MyPoint> points){
		if(points.size()==1){
			return 0;
		}
		int index = 0; 
		double min = points.get(0).getX();
		for(int i = 1;i<points.size();i++){
			double temp = points.get(i).getX();
			if(temp<min){
				min = temp;
				index = i;
			}
		}
		return index;
	}
	private int getMinYPointIndex(ArrayList <MyPoint> points){
		int index = 0;
		double min = points.get(0).getY();
		double temp;
		for(int i =1;i<points.size();i++){
			temp = points.get(i).getY();
			if(temp<min){
				min = temp;
				index = i;
			}
		}
		return index;
	}
	

	
	public void setPointPairs(ArrayList <MyPointPair> pointPairs){
		this.pointPairs = pointPairs;
	}
	public ArrayList <MyPointPair> getPointPairs(){
		return pointPairs;
	}
	
	public void setPoints(ArrayList <MyPoint> points){
		this.points = points;
	}
	public ArrayList <MyPoint> getPoints(){
		return points;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	protected ArrayList <MyPoint> points;
	protected ArrayList <MyPointPair> pointPairs;
	protected double closestDistance;
	protected String name;
}
