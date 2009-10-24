package closestpoint;

import java.util.ArrayList;
import entity.MyPoint;


public class TestClosestPoint {
	public static void main(String [] args){
		testRandomPoints(1000000);
		//compareThreeAlgorithms();
	}
	/******************************************************************
	 * Effect: Generated n points 
	 * @param n the numbers of the points
	 * This is used to test 1000000 points
	 ******************************************************************/
	public static void testRandomPoints(int n){
		ArrayList <MyPoint> points = getRandomPoints(500,700,1000000);
		ClosestPointNLgN_2 cp = new ClosestPointNLgN_2();
		cp.setName("分治法二");
		runAlgorithm(cp,points);
	}
	/****************************************************************
	 * Compare different algorithms
	 *****************************************************************/
	public static void compareThreeAlgorithms(){
		ArrayList <MyPoint> points1 = getRandomPoints(500,500,10);
		ArrayList <MyPoint> points2 = getRandomPoints(500,500,100);
		ArrayList <MyPoint> points3 = getRandomPoints(500,500,1000);
		ArrayList <MyPoint> points4 = getRandomPoints(500,500,10000);
		ClosestPointN2 cp1 = new ClosestPointN2();
		cp1.setName("暴力算法");
		ClosestPointNLgN cp2 = new ClosestPointNLgN();
		cp2.setName("分治法一");
		ClosestPointNLgN_2 cp3 = new ClosestPointNLgN_2();
		cp3.setName("分治法二");
		System.out.println("10 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points1);
		System.out.println("==========================================");
		System.out.println("100 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points2);
		System.out.println("==========================================");
		System.out.println("1000 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points3);
		System.out.println("==========================================");
		System.out.println("10000 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points4);
		System.out.println("==========================================");
	}
	public static void runGroupAlgorithm(ClosestPointAlgorithm cp1,ClosestPointAlgorithm cp2,ClosestPointAlgorithm cp3, ArrayList <MyPoint> points){
		runAlgorithm(cp1,points);
		runAlgorithm(cp2,points);
		runAlgorithm(cp3,points);
	}
	/************************************************************************
	 * Effect: run the algorithm to get the result
	 * @param algorithm the algorithm used to solve the problem
	 * @param points a list of points
	 ************************************************************************/
	public static void runAlgorithm(ClosestPointAlgorithm algorithm,ArrayList <MyPoint> points){
		double msstart = System.currentTimeMillis();
		double start = System.nanoTime();
		double d =algorithm.getClosestDistanceWithoutRecordingPointPairs(points);
		double end = System.nanoTime();
		double msend = System.currentTimeMillis();
		if((msend-msstart)==0.0){
			System.out.println(algorithm.getName()+"运算时间："+(end-start)+" ns");
		}else{
			System.out.println(algorithm.getName()+"运算时间："+(msend-msstart)+" ms");
		}
		System.out.println(algorithm.getName()+"最短距离："+d);
	}
	public static ArrayList <MyPoint> getRandomPoints(int x,int y,int n){
		ArrayList <MyPoint> points= new ArrayList<MyPoint>();
		for(int i = 0;i<n;i++){
			double a = Math.random()*x;
			double b = Math.random()*y;
			MyPoint p = new MyPoint(a,b);
			points.add(p);
		}
		return points;
	}
}
