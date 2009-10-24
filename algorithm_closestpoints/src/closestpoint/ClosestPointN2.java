package closestpoint;

import java.util.ArrayList;

import entity.MyPoint;
import entity.MyPointPair;
/********************************************************
 * Overview:
 * The complexity of this Algorithm is sita(n2)
 * Compute the distance between all pairs of the points,
 * and then pick out the shortest pairs of points,
 * in the meanwhile, figure out the distance.
 ********************************************************/
public class ClosestPointN2 extends ClosestPointAlgorithm {
	public double getClosestDistance(ArrayList <MyPoint> points){
		pointPairs.clear();
		if(points.size()==0){
			return 0;
		}
		if(points.size()==1){
			return 0;
		}
		int size = points.size();
		MyPoint p1=points.get(0);
		MyPoint p2=points.get(1);
		double distance = p1.getDistance(p2);;
		double temp;
		for(int i = 0;i<size;i++){
			for(int j = i+1;j<size;j++){
				p1 = points.get(i);
				p2 = points.get(j);
				temp = p1.getDistance(p2);
				if(temp<distance){
					distance = temp;
					pointPairs.clear();
					pointPairs.add(new MyPointPair(p1,p2));
				}
				if(temp==distance){
					pointPairs.add(new MyPointPair(p1,p2));
				}
			}
		}
		return distance;
	}
	public double getClosestDistanceWithoutRecordingPointPairs(ArrayList <MyPoint> points){
		if(points.size()==0){
			return 0;
		}
		if(points.size()==1){
			return 0;
		}
		int size = points.size();
		MyPoint p1=points.get(0);
		MyPoint p2=points.get(1);
		double distance = p1.getDistance(p2);;
		double temp;
		for(int i = 0;i<size;i++){
			for(int j = i+1;j<size;j++){
				p1 = points.get(i);
				p2 = points.get(j);
				temp = p1.getDistance(p2);
				if(temp<distance){
					distance = temp;
				}
			}
		}
		return distance;
	}

}
