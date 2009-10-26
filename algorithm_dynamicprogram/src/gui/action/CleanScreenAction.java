package gui.action;

import gui.LisGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanScreenAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		LisGUI.clearOutput();
	}

}
