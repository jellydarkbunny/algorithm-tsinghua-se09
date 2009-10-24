package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import closestpoint.ClosestPointAlgorithm;
import closestpoint.ClosestPointNLgN_2;
import closestpoint.TestClosestPoint;
import entity.MyPoint;
import gui.ClosestPointGUI;

public class ComputeMillionAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		testRandomPoints(1000000);
	}
	public void testRandomPoints(int n){
		ArrayList <MyPoint> points = TestClosestPoint.getRandomPoints(500,700,1000000);
		ClosestPointNLgN_2 cp = new ClosestPointNLgN_2();
		cp.setName("分治法二");
		runAlgorithm(cp,points);
	}
	private void runAlgorithm(ClosestPointAlgorithm algorithm,ArrayList <MyPoint> points){
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
