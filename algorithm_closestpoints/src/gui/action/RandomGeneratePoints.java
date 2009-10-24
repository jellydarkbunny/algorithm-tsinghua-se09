package gui.action;

import entity.MyPoint;
import gui.ClosestPointGUI;
import gui.ScreenPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGeneratePoints implements ActionListener{
	public RandomGeneratePoints(ScreenPanel screenPanel){
		this.screenPanel = screenPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ClosestPointGUI.println("随机生成5个点：");
		for(int i = 1;i<=5;i++){
			double x = Math.random()*screenPanel.getWidth();
			double y = Math.random()*screenPanel.getHeight();
			MyPoint point = new MyPoint(x,y);
			ClosestPointGUI.println(point.toString());
			screenPanel.getPoints().add(point);
		}
		screenPanel.repaint();
	}
	private ScreenPanel screenPanel;
}
