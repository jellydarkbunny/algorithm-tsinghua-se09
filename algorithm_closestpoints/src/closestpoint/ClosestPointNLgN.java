package closestpoint;

import java.util.ArrayList;
import entity.MyPoint;
import entity.MyPointPair;
/************************************************************
 * Overview: Using Divide and Conque to gain the closest distance
 * In this algorithm, the list of points are divided by the number of the points. 
 ************************************************************/

public class ClosestPointNLgN extends ClosestPointAlgorithm{
	public double getClosestDistance(ArrayList <MyPoint> points){
		ArrayList <MyPoint> ps = mergeSortByX(points);
		pointPairs.clear();
		if(points.size()==0||points.size()==1){
			return 0;
		}
		divideAndConque(ps);
		return closestDistance;
	}
	private ArrayList <MyPoint> divideAndConque(ArrayList <MyPoint> ps){
		int size = ps.size();
		if(size == 1){
			return ps; 
		}
		ArrayList <MyPoint> x1 = new ArrayList<MyPoint>();
		ArrayList <MyPoint> x2 = new ArrayList<MyPoint>();
		for(int i =0;i<size/2;i++){
			x1.add(ps.get(i));
		}
		for(int i = size/2;i<size;i++){
			x2.add(ps.get(i));
		}
		ArrayList <MyPoint> y1 = divideAndConque(x1);
		ArrayList <MyPoint> y2 = divideAndConque(x2);
		ArrayList <MyPoint> y = combineByY(y1,y2);
		
		//the point in the middle area.(l-d,l+d)
		double middle = ps.get(size/2).getX()/2;
		ArrayList <MyPoint> mps= getMiddelAreaPoints(ps,middle,closestDistance);
		MyPoint a;
		MyPoint b;
		for(int i =0;i<mps.size();i++){
			MyPoint temp = mps.get(i);
			int index = y.indexOf(temp);
			int ySize= y.size();
			for(int j= index;j< ySize-1;j++){
				for(int k = j+1;k< ySize;k++){
					a = y.get(j);
					b = y.get(k);
					if(b.getY() - a.getY() > closestDistance){
						break;
					}
					double distance = a.getDistance(b);
					if(distance == closestDistance){
						pointPairs.add(new MyPointPair(a,b));
					}
					if(distance < closestDistance){
						closestDistance = distance;
						pointPairs.clear();
						pointPairs.add(new MyPointPair(a,b));
					}
				}
			}
		}
		return y;
	}
	//used only for test
	public double getClosestDistanceWithoutRecordingPointPairs(ArrayList<MyPoint> points){
		ArrayList <MyPoint> ps = mergeSortByX(points);
		if(points.size()==0||points.size()==1){
			return 0;
		}
		divideAndConque2(ps);
		return closestDistance;
	}
	private ArrayList <MyPoint> divideAndConque2(ArrayList <MyPoint> ps){
		int size = ps.size();
		if(size == 1){
			return ps; 
		}
		ArrayList <MyPoint> x1 = new ArrayList<MyPoint>();
		ArrayList <MyPoint> x2 = new ArrayList<MyPoint>();
		for(int i =0;i<size/2;i++){
			x1.add(ps.get(i));
		}
		for(int i = size/2;i<size;i++){
			x2.add(ps.get(i));
		}
		ArrayList <MyPoint> y1 = divideAndConque(x1);
		ArrayList <MyPoint> y2 = divideAndConque(x2);
		ArrayList <MyPoint> y = combineByY(y1,y2);
		
		//the point in the middle area.(l-d,l+d)
		double middle = ps.get(size/2).getX()/2;
		ArrayList <MyPoint> mps= getMiddelAreaPoints(ps,middle,closestDistance);
		MyPoint a;
		MyPoint b;
		for(int i =0;i<mps.size();i++){
			MyPoint temp = mps.get(i);
			int index = y.indexOf(temp);
			int ySize= y.size();
			for(int j = index; j < ySize-1; j++){
				for(int k = j+1; k< ySize; k++){
					a = y.get(j);
					b = y.get(k);
					if(b.getY() - a.getY() > closestDistance){
						break;
					}
					double distance = a.getDistance(b);
					if(distance < closestDistance){
						closestDistance = distance;
					}
				}
			}
		}
		return y;
	}
	//ps is sorted by x
	//combine y1, y2 into Y. where
	private ArrayList <MyPoint> combineByY(ArrayList <MyPoint> y1, ArrayList <MyPoint> y2){
		ArrayList <MyPoint>value = new ArrayList<MyPoint>();
		int i = 0;
		int j = 0;
		int sizeY1 = y1.size();
		int sizeY2 = y2.size();
		while(true){
			if(i==sizeY1){
				if(j==sizeY2){
					break;
				}
				value.add(y2.get(j));
				j++;
				continue;
			}
			if(j==sizeY2){
				if(i==sizeY1){
					break;
				}
				value.add(y1.get(i));
				i++;
				continue;
			}
			if(y1.get(i).getY()<=y2.get(j).getY()){
				value.add(y1.get(i));
				i++;
				continue;
			}
			if(y1.get(i).getY()>y2.get(j).getY()){
				value.add(y2.get(j));
				j++;
				continue;
			}
		}
		return value;
	}
	//Get the list of point in the middle area.(l-d,l+d)
	public ArrayList <MyPoint> getMiddelAreaPoints(ArrayList <MyPoint> points,double l, double d){
		int size = points.size();
		int left =0;
		int right = size-1;
		for(int i = size/2;i>=0;i--){
			if((points.get(i).getX()+d)<l){
				left = i;
				break;
			}
			if(i==0){
				left=0;
			}
		}
		for(int i = size/2;i<points.size();i++){
			if(points.get(i).getX()>l+d){
				right = i;
				break;
			}
			if(i==points.size()-1){
				right=points.size()-1;
			}
		}
		if(left==right){
			return new ArrayList<MyPoint>();
		}
		ArrayList <MyPoint> mps= new ArrayList<MyPoint>();
		for(int i = left;i<=right;i++){
			mps.add(points.get(i));
		}
		return mps;
	}
}
