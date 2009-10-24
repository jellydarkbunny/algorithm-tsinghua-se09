package gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import closestpoint.ClosestPointN2;
import entity.MyPoint;
import gui.ClosestPointGUI;
import gui.ScreenPanel;

public class ComputeClosestPointsPairAction implements ActionListener{
	
	public ComputeClosestPointsPairAction(ScreenPanel screenPanel ){
		this.screenPanel = screenPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ArrayList <MyPoint> points = screenPanel.getPoints();
		ClosestPointN2 cp = new ClosestPointN2();
		double msstart = System.currentTimeMillis();
		double start = System.nanoTime();
		double d =cp.getClosestDistance(points);
		double end = System.nanoTime();
		double msend = System.currentTimeMillis();
		screenPanel.setLines(cp.getPointPairs());
		screenPanel.repaint();
		if((msend-msstart)==0.0){
			//System.out.println("暴力算法运算时间："+(end-start)+" ns");
			ClosestPointGUI.println("暴力算法运算时间："+(end-start)+" ns");
		}else{
			//System.out.println("暴力算法运算时间："+(msend-msstart)+" ms");
			ClosestPointGUI.println("暴力算法运算时间："+(msend-msstart)+" ms");
		}
		//System.out.println("暴力算法最短距离："+d);
		ClosestPointGUI.println("暴力算法最短距离："+d);
	}
	private ScreenPanel screenPanel;
}
