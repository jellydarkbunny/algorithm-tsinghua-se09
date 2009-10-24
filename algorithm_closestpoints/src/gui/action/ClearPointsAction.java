package gui.action;

import gui.ClosestPointGUI;
import gui.ScreenPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearPointsAction implements ActionListener{

	public ClearPointsAction(ScreenPanel screenPanel){
		this.screenPanel = screenPanel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		screenPanel.clearPoints();
		ClosestPointGUI.clearOutput();
	}
	private ScreenPanel screenPanel;

}
