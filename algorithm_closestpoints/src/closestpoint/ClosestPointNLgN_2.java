package closestpoint;

import java.util.ArrayList;
import entity.MyPoint;
import entity.MyPointPair;
/************************************************************
 * Overview: Using Divide and Conque to gain the closest distance
 * In this algorithm, the list of points are divided by the middle value of 
 * the maximum x value and the minimum x value of the points. 
 ************************************************************/
public class ClosestPointNLgN_2 extends ClosestPointAlgorithm{
	public double getClosestDistance(ArrayList <MyPoint> points){
		if(points.size()==0||points.size()==1){
			return 0;
		}
		ArrayList <MyPoint>ps = mergeSortByX(points);
		pointPairs.clear();
		divideAndConque(ps);
		return closestDistance;
	}
	/*****************************************************
	 * Request:The input list should be sorted by x
	 * Effect:  update the closestDistance
	 * 			update the list of closest point pairs.
	 * @param ps
	 * @return return the list of points sorted by y
	 ******************************************************/
	
	private ArrayList <MyPoint> divideAndConque(ArrayList <MyPoint> ps){
		int size = ps.size();
		if(size == 1){
			return ps; 
		}
		if(size==0){
			return ps;
		}
		if(size>1){
			if(ps.get(0).getX()==ps.get(size-1).getX()){
				ArrayList <MyPoint> yList = sortByY(ps);
				for(int i = 0;i<size-1;i++){
					double temp = yList.get(i).getDistance(yList.get(i+1));
					if(temp==closestDistance){
						pointPairs.add(new MyPointPair(yList.get(i),yList.get(i+1)));
					}
					if(temp<closestDistance){
						closestDistance = temp;
						pointPairs.clear();
						pointPairs.add(new MyPointPair(yList.get(i),yList.get(i+1)));
					}
				}
				return yList;
			}
		}
		double middle = (ps.get(size-1).getX()+ps.get(0).getX())/2;
		ArrayList <MyPoint> x1 = new ArrayList<MyPoint>();
		ArrayList <MyPoint> x2 = new ArrayList<MyPoint>();
		
		for(int i =0;i<size;i++){
			MyPoint temp =  ps.get(i);
			if(temp.getX()<=middle){
				x1.add(temp);
			}
			if(temp.getX()>middle){
				x2.add(temp);
			}
		}
		
		ArrayList <MyPoint> y1 = divideAndConque(x1);
		ArrayList <MyPoint> y2 = divideAndConque(x2);
		
		ArrayList <MyPoint> yList = combineByY(y1,y2);
		
		//the point in the middle area.(l-d,l+d)
		ArrayList <MyPoint> mps= getMiddelAreaPoints(ps,x1.size(),middle,closestDistance);
		for(int i =0;i<mps.size();i++){
			MyPoint temp = mps.get(i);
			int index = yList.indexOf(temp);
			for(int j= index;j<yList.size()-1;j++){
				for(int k = j+1;k<yList.size();k++){
					MyPoint a = yList.get(k);
					MyPoint b = yList.get(j);
					if(a.getY()-b.getY()>closestDistance){
						break;
					}
					double distance =a.getDistance(b);
					if(distance==closestDistance){
						pointPairs.add(new MyPointPair(a,b));
						
					}
					if(distance<closestDistance){
						closestDistance = distance;
						pointPairs.clear();
						pointPairs.add(new MyPointPair(a,b));
					}
				}
			}
		}
		return yList;
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
	public ArrayList<MyPoint> getMiddelAreaPoints(ArrayList <MyPoint> points,int leftSize,double l, double d){
		int left = leftSize; int right = leftSize;
		for(int i = leftSize;i>=0;i--){
			if(points.get(i).getX()<=l-d){
				left = i;
				break;
			}
			if(i==0){
				left=0;
			}
		}
		for(int i = leftSize;i<points.size();i++){
			if(points.get(i).getX()>=l+d){
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

	public double getClosestDistanceWithoutRecordingPointPairs(ArrayList <MyPoint> points){
		if(points.size()==0||points.size()==1){
			return 0;
		}
		ArrayList <MyPoint>ps = mergeSortByX(points);
		divideAndConque2(ps);
		return closestDistance;
	}
	private ArrayList <MyPoint> divideAndConque2(ArrayList <MyPoint> ps){
		int size = ps.size();
		if(size == 1){
			return ps; 
		}
		if(size==0){
			return ps;
		}
		if(size>1){
			if(ps.get(0).getX()==ps.get(size-1).getX()){
				ArrayList <MyPoint> yList = sortByY(ps);
				for(int i = 0;i<size-1;i++){
					double temp = yList.get(i).getDistance(yList.get(i+1));
					if(temp<closestDistance){
						closestDistance = temp;
					}
				}
				return yList;
			}
		}
		double middle = (ps.get(size-1).getX()+ps.get(0).getX())/2;
		ArrayList <MyPoint> x1 = new ArrayList<MyPoint>();
		ArrayList <MyPoint> x2 = new ArrayList<MyPoint>();
		
		for(int i =0;i<size;i++){
			MyPoint temp =  ps.get(i);
			if(temp.getX()<=middle){
				x1.add(temp);
			}
			if(temp.getX()>middle){
				x2.add(temp);
			}
		}
		
		ArrayList <MyPoint> y1 = divideAndConque(x1);
		ArrayList <MyPoint> y2 = divideAndConque(x2);
		
		ArrayList <MyPoint> yList = combineByY(y1,y2);
		
		//the point in the middle area.(l-d,l+d)
		ArrayList <MyPoint> mps= getMiddelAreaPoints(ps,x1.size(),middle,closestDistance);
		for(int i =0;i<mps.size();i++){
			MyPoint temp = mps.get(i);
			int index = yList.indexOf(temp);
			for(int j= index;j<yList.size()-1;j++){
				for(int k = j+1;k<yList.size();k++){
					MyPoint a = yList.get(k);
					MyPoint b = yList.get(j);
					if(a.getY()-b.getY()>closestDistance){
						break;
					}
					double distance =a.getDistance(b);
					if(distance<closestDistance){
						closestDistance = distance;
					}
				}
			}
		}
		return yList;
	}
 
}
