package gui.action;

import gui.FibonacciGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreInputAction implements ActionListener{
	
	public PreInputAction(){
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FibonacciGUI.n = Integer.parseInt(FibonacciGUI.textArea.getText());
		FibonacciGUI.index = FibonacciGUI.box.getSelectedIndex();
	}

}