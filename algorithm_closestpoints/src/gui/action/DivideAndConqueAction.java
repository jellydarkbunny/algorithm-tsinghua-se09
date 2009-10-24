package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import closestpoint.ClosestPointNLgN;
import entity.MyPoint;
import gui.ClosestPointGUI;
import gui.ScreenPanel;

public class DivideAndConqueAction implements ActionListener{
	public DivideAndConqueAction(ScreenPanel screenPanel){
		this.screenPanel = screenPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ArrayList <MyPoint> points = screenPanel.getPoints();
		ClosestPointNLgN cp = new ClosestPointNLgN();
		double msstart = System.currentTimeMillis();
		double start = System.nanoTime();
		double d = cp.getClosestDistance(points);
		double end = System.nanoTime();
		double msend = System.currentTimeMillis();
		screenPanel.setLines(cp.getPointPairs());
		screenPanel.repaint();
		if((msend-msstart)==0.0){
			//System.out.println("分治法一运算时间："+(end-start)+" ns");
			ClosestPointGUI.println("分治法一运算时间："+(end-start)+" ns");
		}else{
			//System.out.println("分治法一运算时间："+(msend-msstart)+" ms");
			ClosestPointGUI.println("分治法一运算时间："+(msend-msstart)+" ms");
		}
		//System.out.println("分治法一最短距离："+d);
		ClosestPointGUI.println("分治法一最短距离："+d);
	}
	private ScreenPanel screenPanel;
}
