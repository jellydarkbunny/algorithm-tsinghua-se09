package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import closestpoint.ClosestPointAlgorithm;
import closestpoint.ClosestPointN2;
import closestpoint.ClosestPointNLgN;
import closestpoint.ClosestPointNLgN_2;
import closestpoint.TestClosestPoint;
import entity.MyPoint;
import gui.ClosestPointGUI;

public class CompareAlgorithmsAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		compareThreeAlgorithms();
	}
	
	public void compareThreeAlgorithms(){
		ArrayList <MyPoint> points1 = TestClosestPoint.getRandomPoints(500,500,10);
		ArrayList <MyPoint> points2 = TestClosestPoint.getRandomPoints(500,500,100);
		ArrayList <MyPoint> points3 = TestClosestPoint.getRandomPoints(500,500,1000);
		ArrayList <MyPoint> points4 = TestClosestPoint.getRandomPoints(500,500,10000);
		ClosestPointN2 cp1 = new ClosestPointN2();
		cp1.setName("暴力算法");
		ClosestPointNLgN cp2 = new ClosestPointNLgN();
		cp2.setName("分治法一");
		ClosestPointNLgN_2 cp3 = new ClosestPointNLgN_2();
		cp3.setName("分治法二");
		
		ClosestPointGUI.println("10 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points1);
		ClosestPointGUI.println("==========================================");
		ClosestPointGUI.println("100 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points2);
		ClosestPointGUI.println("==========================================");
		ClosestPointGUI.println("1000 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points3);
		ClosestPointGUI.println("==========================================");
		ClosestPointGUI.println("10000 points test");
		runGroupAlgorithm(cp1,cp2,cp3,points4);
		ClosestPointGUI.println("==========================================");
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
			ClosestPointGUI.println(algorithm.getName()+"运算时间："+(end-start)+" ns");
		}else{
			ClosestPointGUI.println(algorithm.getName()+"运算时间："+(msend-msstart)+" ms");
		}
		ClosestPointGUI.println(algorithm.getName()+"最短距离："+d);
	}
	

}
